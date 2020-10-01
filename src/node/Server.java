package node;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


        
public class Server extends Thread {
    
    private ServerSocket serverSocket;
    private int port;
    Socket socket;
    
    public Server(){
        try {                
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            
    public Server(int port ){
        try {                
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
            
            
            
    public void respond(int port) throws IOException
    {
        String responseArr[][] = new String[10][2];
        responseArr[0][0] = "what is my name";
        responseArr[0][1] = "Your name is Mthi Adonis";
        responseArr[1][0] = "hello";
        responseArr[1][1] = "hi to you too";
        responseArr[2][0] = "how are you";
        responseArr[2][1] = "well thanks and you";
        responseArr[3][0] = "bye";
        responseArr[3][1] = "If you're tired then respond with \"q\"";                
                
        //ServerSocket serverSocket = new ServerSocket(port);
        Socket ss = serverSocket.accept();
        Scanner sc = new Scanner(ss.getInputStream());
        PrintStream p;
        p = new PrintStream(ss.getOutputStream());
        //number = sc.nextInt();
        String str;
        do{
             
            str = sc.nextLine();
            String response ="";
         
            for(int i =0;i<4;i++){
                if(str.compareToIgnoreCase(responseArr[i][0])==0){
                response = responseArr[i][1];
                break;
         }
         else {
             response = "I don't know what you're saying";
         }
         }  
         p.println( response);
         }while(!(str.equalsIgnoreCase("q")||str.equalsIgnoreCase("quit")));
         p.println("Bye!");
            }//end of respond()
            
              @Override
    public void run() {
        System.out.println("SERVER IS RUNNING");
                try {
                    respond(5000);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
    }
    
}
