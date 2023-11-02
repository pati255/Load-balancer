/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

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
public class Nodes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
         //storing variables 
        InetAddress addr = InetAddress.getLocalHost(); //getting local ip
        ServerSocket s = new ServerSocket(0); //setting a free soceket
        
        
       
 
       
        
        Scanner myJobs = new Scanner(System.in); //gets input into the system
         System.out.println("What is the destination port?"); //asks for destiantion ports
        int finalPort=myJobs.nextInt(); //takes information from that line
        
       try { //try catch error handling used
       if(args.length >10){ //cant have more than 10 arguments 
           System.out.println("invalid argument"); //throws error showing invaid does not process
       } else {  
           String hostName = addr.getHostName(); //gets hostname
           String message = ("REG," + addr.getHostAddress()+ "," + addr.getHostName()+","+s.getLocalPort()); //sends reg message to lb
          
           int destinationPort = finalPort; //takes destinationport from the input
           int localPort = s.getLocalPort(); //takes the localport to send UDP packet
           
           System.out.println("Sending to host:" + hostName);
           System.out.println("Sending to host:" + message);
           System.out.println("Sending to host:" + destinationPort);
           System.out.println("Sending to host:" + s.getLocalPort());
           
           //some messages printed once this has happened to show data being carried across useful for testing and for the user to see if infromation is being contained and sent across instead of returning null
       InetAddress address = InetAddress.getByName(hostName); //hostname of the local machine
       
       
       DatagramPacket Packet = new DatagramPacket(message.getBytes(),message.getBytes().length,address,destinationPort); //sends information with UDP
       DatagramSocket socket = new DatagramSocket(localPort); //uses local machine port
       socket.send(Packet); //sends packet
       socket.close(); //closes socket
       }
       } catch(Exception error){
           error.printStackTrace();
        
           
         
       
       }
      
        if (args.length >10 ){
            System.out.println("invalid port");
            
        }else {
         int port =s.getLocalPort();
        Reciever recieve = new Reciever(port);
      recieve.runSystem();
            } //runs the reciver end after registering with the LB
        
      
    }
           
    
    //class used for sending registration to the node
       
    
    
    
} 
