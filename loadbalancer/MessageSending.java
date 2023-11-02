/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;

/**
 *
 * @author patry
 */
public class MessageSending  {
    
    private int serverPort = -1;
    private DatagramSocket socket = null;
    
   public MessageSending(int port){
  

       
       serverPort=port ; //ports assigned to variable
       
   } 
    
    public void runSystem(){
          Node details=new Node(); //accessing other classes
          NodeManager controls= new NodeManager(); //accessing other classes with functions
          Sender send=new Sender();
          //display message to show that system is running
        System.out.println("System is runnning...");
        System.out.println("listening on port number:" + serverPort); //showing what port the LB is using
        
        try{ //error handling
            socket = new DatagramSocket(serverPort);//sending pacekts through UDP
            socket.setSoTimeout(0); //lack of timeout so the socket does not close
            boolean repeat= true; //boolean to stop the forever loop
            while(repeat){ //foever loop
                byte [] packetData = new byte[1024]; //sending bytes over udp
                DatagramPacket packet = new DatagramPacket(packetData,packetData.length);
                socket.receive(packet); //recieving packet
                String message = new String(packetData); //message is converted to a string from the packet data recieved
                System.out.println("Message recieved "+ message); //shows the message for clarifications
                
                String [] elements = message.trim().split(","); //seperates into elements   //splits these elements into categories to be able to show which switch case they go into
               switch(elements[0]){ //classic switch case scenario loop to keep the system going without shutting down
                   case "REG":
                       System.out.println("Got a REG message");
                       
                      String IpAddressNode = elements[1];
                       // System.out.println(IpAddressNode);
                      String nodeName=elements[2];
                      String command=elements[0];
                      String NodePorts=elements[3];
                     
                      SingletonNode.getInstance().setMydata(NodePorts);
                      
                      controls.registerNode(nodeName);
                      
                      
                       break;
                   case "JOB":
                       System.out.println("Got a JOB message");             //case scenario for what happens when a job message is sent through
                       String jobTime=elements[2];
                       String jobID= elements[1];
                       details.getJob(jobTime,jobID);
                       System.out.println(details.duration);
                       System.out.println(details.getjobID());
                        singleton.getInstance().setMydata(jobTime, jobID);
                       send.sending();
                       break;
                   case "FINISHED":
                       System.out.println("Got a FINISHED message");
                      //String finalnode=elements[0];
                      controls.removeNode();                        //case scenario of what happens when a job has been finished final message goes through 
                       break;
                   case "HEALTH":
                       System.out.println("Got a HEALTH message");
                       //not done but would like to implement in the future for expansion of program and added complexity 
                       break;
                   case "STOP": //case scenario of what happens when the message is STOP
                       repeat= false;
                       break;
                   default:
                       System.out.println("Unknown"+ elements[0]); //default, if the first part of the string contains something which is not specified above then it will default to unknown and will show what was being passed through
               } 
            }
            System.out.println("Shutting down.."); //shutting the system down
        }catch(Exception error){
            error.printStackTrace();
        }finally{                                 //finally closing the socket and ending the program.
            try {
                socket.close();
            }catch(Exception error){
                //nothing happens
            }
                
        }
           
    }
    
  
}
