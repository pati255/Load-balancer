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
public class NodeManager {
    
    
   private LinkedList availableNodes;
    
    public NodeManager(){
        availableNodes= new LinkedList();
         
    }
    //storing nodes within the node
    public void show(){
        
       System.out.println("nodes registered:" + availableNodes);
    }
    
    public void registerNode(String newNode){
            availableNodes.add(newNode);
        
}
  //takes  the job id and 
   public boolean doJob(String jobMessage,String nodeID){
       return true;
   }
     
     
     //removes the first node in the list of nodes
     public void removeNode(){
         availableNodes.remove(0);
     }
     
     
    
     
}


