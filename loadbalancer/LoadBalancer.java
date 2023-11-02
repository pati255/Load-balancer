/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.util.Scanner;



/**
 *
 * @author patry
 */
public class LoadBalancer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
      ServerSocket s = new ServerSocket(0); //assigning a free socket
        InetAddress addr = InetAddress.getLocalHost(); 
        
  
      
     if (args.length >10 ){
            System.out.println("invalid port");
            
        }else {
         int port =s.getLocalPort();
        MessageSending myMessages= new MessageSending(port);
        myMessages.runSystem();
        
        //runs the system
        
      
        
    
}
    }
      
      
}    
     
     
        
       
    
    
     

    

