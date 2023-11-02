/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Scanner;
/**
 *
 * @author patry
 */
public class Sender {
  
    public void sending() throws InterruptedException, IOException {
        ServerSocket s = new ServerSocket(0); //assigning a free socket
        InetAddress addr = InetAddress.getLocalHost(); //gets local host
        Node nodes=new Node(); //assigns new field to access functions from the node class
       
       
       try {
            
           int localPort = s.getLocalPort();
            int myNodePort=Integer.parseInt(SingletonNode.getInstance().getMyDataport()); //turns string into into
             int destinationPort = myNodePort; //takes int to send the job to the nodes
            
           String hostName = addr.getHostName();
           String message = ("Job,"+singleton.getInstance().getMyDatadura()+","+singleton.getInstance().getMyDatajoba()); //data being returned to send to the nodes
      
        //sending jobs to nodes
           
           
           System.out.println("Sending to host:" + hostName);
           System.out.println("Sending to host:" + message);
           System.out.println("Sending to host:" + destinationPort);
           System.out.println("Sending to host:" + s.getLocalPort());
           
           
       InetAddress address = InetAddress.getByName(hostName); //gets localhost
    
       
       DatagramPacket Packet = new DatagramPacket(message.getBytes(),message.getBytes().length,address,destinationPort); //data being sent
       DatagramSocket socket = new DatagramSocket(localPort);
       socket.send(Packet);
       socket.close();
       
       } catch(Exception error){
           error.printStackTrace();
       
}}}