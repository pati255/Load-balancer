/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;

import java.util.LinkedList;

/**
 *
 * @author patry
 */
public class Node{
   NodeManager Manager= new NodeManager(); //calls for NodeManager class
    
 private String nodeIPAddress;
 private int nodePort;
 private String nodeName;
 public String command;
public String jobID;
 public String duration; //varibales for storing information
  
   
public void Node(){ //funtion to get node
      nodeIPAddress="";
      nodePort=0;
      nodeName="";            
   }
      
   public void Node(String IP,int port,String name){
       nodeIPAddress=IP;
       nodePort=port;
       nodeName=name;
              
   }
   
    //Registration
   public void Reg(String com,String IP,String name){ //registation of nodes
        nodeIPAddress=IP;
        nodeName=name;
       command=com;
   }
   
   
   
  // public void ref(){
     //  Manager.
   //}
 
    
   //for sending jobs 
   public int getNodePort(){
       return nodePort;
   }
   
   public String getNodeName(){
       return nodeName;
   }
   
  public void getJob(String jobsTime,String JobsID){ //getting messages from messagesending
      duration=jobsTime;
      jobID=JobsID;
  }
  
  public String getjobID(){ //returning values to check
      return jobID;
  }
  
  public String getduartion(){ //returning values to check
      return duration;
  }
}
