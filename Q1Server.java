import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author T'jon
 */
public class Q1Server extends Thread{
    private Thread t1;
    private Socket client = null;
    
    public Q1Server(Socket client){
        this.client = client;
    }
    
    @Override
    public void run(){
        try{
        System.out.println("Running " + Thread.currentThread().getName());//prints thread number

                //in&output streams
                InputStream is = client.getInputStream();  
                OutputStream os = client.getOutputStream();
                 
            while(!client.isClosed()){//loops
               
                //input
               int n = is.available();
                 byte[] data = new byte[n];
                 is.read(data, 0, n);
                 String text = new String(data);

                //output
                ByteArrayOutputStream bOut = new ByteArrayOutputStream(data.length);
                bOut.write(data);
                bOut.writeTo(os);//problem here for some reason
                bOut.flush(); 
            }
           //closes all connections
           is.close();
           os.close();
            client.close();
                System.out.println("Client disconnected.\nShutting down.");      
           System.exit(0);
        }catch (IOException ioe) {
            System.err.println(ioe);
                   // throw ioe;
        }
    
        }
    }

        



