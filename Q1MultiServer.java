
import java.net.*;
import java.io.*;
/**
 *
 * @author T'jon
 */
public class Q1MultiServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try(ServerSocket servSock = new ServerSocket(14147)){

      while(true){//loops         
	//sends client connection to new thread to do the work
            Socket client = servSock.accept();       
                System.out.println("CLIENT CONNECTED");
               Q1Server server = new Q1Server(client);
          		server.start();
          	}
            }catch (IOException ioe) {
            System.err.println(ioe);
        }

      }
       
    }
    

