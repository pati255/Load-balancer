/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package initator;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Scanner;
/** //importing libraries needed 
 *
 * @author patry
 */
public class Initator  {

    /**
     * @param args the command line arguments
     */
    public static void main (String [] args) throws Exception { //error handling with exceptions
        
Scanner myJobs = new Scanner(System.in); //used for inputting users requests
System.out.println("Job, enter job ID, enter duration"); //simple printout showing what details need to be inputted
 String command=("JOB"); //first command is set into a variable
 String ID=myJobs.nextLine(); //returns string from the line
 int duration=myJobs.nextInt(); //returns int form line putting it within a variable
InetAddress addr = InetAddress.getLocalHost(); //finding the local host of the pc
System.out.println("Enter destinationPort"); //asking for the destinationPort
int finalPort=myJobs.nextInt(); //input for the destination port
 
 
 System.out.println(command);
 System.out.println("Input JOB ID "+  ID);
 System.out.println("Input duartion "+  duration);  //system outs showing the information
  ServerSocket s = new ServerSocket(0); //using a free socket to assign to the local port
         
        
        
      try { //error handling
       if(args.length >10){ 
           System.out.println("invalid argument");
       } else {  
           String hostName = addr.getHostName(); //gets local machine host name
           String message = (command+ "," + ID + "," + duration); //gets the message variable ready to transmit to host setting in the variables from above
           int destinationPort = finalPort ;
           int localPort = s.getLocalPort() ; //getting the free port 
           
           System.out.println("Sending to host:" + hostName);
           System.out.println("Sending to host:" + message);
           System.out.println("Sending to host:" + destinationPort);
           System.out.println("Sending to host:" + s.getLocalPort());
           
           //showing the system sending messages over
       InetAddress address = InetAddress.getByName(hostName);
      //getting the host name
       
       DatagramPacket Packet = new DatagramPacket(message.getBytes(),message.getBytes().length,address,destinationPort);
       DatagramSocket socket = new DatagramSocket(localPort);
       socket.send(Packet);
       socket.close();
       //sending the actual message through UDP
    
               
       }//try catch error handling used to print if something goes wrong
       } catch(Exception error){
           error.printStackTrace();
           
       }
    }
       }

