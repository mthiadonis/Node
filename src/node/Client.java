package node;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Client extends Thread{
    
    public void communicate(String url, int port) throws IOException{
        
         int number, temp=0;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket(url,port);
        Scanner sc1 = new Scanner(s.getInputStream());
        String word;
        String received = "Greet";
        do{
        //System.out.println("Client waiting for a word to be entered");
        ///word = sc.nextLine();
        word = JOptionPane.showInputDialog(received);
        if(word == null){word = "quit";}
        PrintStream p;
        p = new PrintStream(s.getOutputStream());
        p.println(word);
        
        //String question;
        
        received = sc1.nextLine();
        //question = sc1.nextLine();
        System.out.println(received);
        //System.out.println(question);
        }while(!word.equals("q"));
    }//end of communicate()

    @Override
    public void run() {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            System.out.println("CLIENT IS RUNNING");
            communicate("localhost",5000);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
}
