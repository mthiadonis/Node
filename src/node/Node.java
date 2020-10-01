
package node;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Node {

   
    public static void main(String[] args) {
        
        
        Thread sr = new Server();
        Thread cl = new Client();
        
        sr.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
        }
        cl.start();
        
        
        
        
        
        
    }//end of main
    
}
