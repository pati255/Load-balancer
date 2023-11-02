/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author patry
 */
public class Reciever  {
    
   private int serverPort = -1;
    private DatagramSocket socket = null;
    
   public Reciever(int port){
  

       
       serverPort=port ; //ports assigned to variable
       
   } 
    
    public void runSystem(){
          
          //display message to show that system is running
        System.out.println("System is runnning...");
        System.out.println("listening on port number:" + serverPort); //showing what port the LB is using
        Nodes node=new Nodes();
        sender done=new sender();
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
               switch(elements[0]){ //classic switch case scenario loop to keep the system going without shutting dow
                   case "Job":
                       System.out.println("Got a JOB message");             //case scenario for what happens when a job message is sent through
                       String jobTime=(elements[1]);
                       String jobID= elements[2];
                      // String myLB=elements[3];
                     //  SingletonLB.getInstance().setMydata(myLB);
                       int durations=Integer.parseInt(jobTime);
                       TimeUnit.SECONDS.sleep(durations);
                       done.finsish();
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
                //nothing happens after error is caught
            }
                
        }
           
    }
}