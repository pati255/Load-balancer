/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author patry
 */
public class SingletonNode {
    
     private static SingletonNode instance;
    
    private String nodePort;
     LinkedList<String> thesePorts= new LinkedList<String>(); //storing them within a linkedlist with itention of iteration
     Iterator<String>it=thesePorts.iterator(); //iteratoring through ports
    
    
    public SingletonNode(){
         nodePort="";
    }
    
    public static synchronized SingletonNode getInstance(){
        if(instance==null) instance = new SingletonNode();
        return instance;
        
    }
    
    public void setMydata(String ports){
        nodePort=ports;
        thesePorts.add(nodePort);  
    }
    
    public String getMyDataport(){
        return it.next();
      //  return nodePort;
        
    }
    
    
}
//singleton for storing information about the node i.e the port number to be able to send messages to it.