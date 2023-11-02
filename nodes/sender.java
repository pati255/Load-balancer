/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;      //importig all functions
import java.net.ServerSocket;
import java.util.Scanner;
/**
 *
 * @author patry
 */
public class sender {
  
    public void finsish() throws InterruptedException, IOException { //throwing exceptions
        ServerSocket s = new ServerSocket(0); //assigning a free socket
        InetAddress addr = InetAddress.getLocalHost(); //getting local hosts
      
       
      
        Scanner myJobs = new Scanner(System.in); //input coming in
         System.out.println("What is the destination port?"); //output statement
        int finalPort=myJobs.nextInt(); //taking the user input
        
       try {
             
           
           String hostName = addr.getHostName(); //gets hot name
           String message = ("FINISHED"); //sends a finished message
         
            
       //    int mynewport =Integer.parseInt(SingletonLB.getInstance().getMyDataport());
           int destinationPort =finalPort; //port to send to
           int localPort = s.getLocalPort(); //local free port of the machine which would be same as the one from reg message
           
           System.out.println("Sending to host:" + hostName);
           System.out.println("Sending to host:" + message);
           System.out.println("Sending to host:" + destinationPort);
           System.out.println("Sending to host:" + s.getLocalPort());
           //printing statements out
           
       InetAddress address = InetAddress.getByName(hostName);
       // String message="REG,192.168.1.20,2000,Node1";
       
       DatagramPacket Packet = new DatagramPacket(message.getBytes(),message.getBytes().length,address,destinationPort); //sending data across
       DatagramSocket socket = new DatagramSocket(localPort); //sending on localport not hard coded
       socket.send(Packet); //sending the packet
       socket.close(); 
       
       } catch(Exception error){
           error.printStackTrace();//throw error handling used
       
}}}