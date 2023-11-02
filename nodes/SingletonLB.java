/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

/**
 *
 * @author patry
 */
public class SingletonLB {
    //taking the port from LB to send automatically finished job message
    
  
    private static SingletonLB instance; //instance is same as an object
    
    private String LBport;//creating a field to store data
 
    
    
    public SingletonLB(){
         LBport="";  //assigning empty value and making this public
    }
    
    public static synchronized SingletonLB getInstance(){ //allows access to multiple threads to this shared resource
        if(instance==null) instance = new SingletonLB();
        return instance;
        //returns this object
    }
    
    public void setMydata(String porta){
        LBport=porta; //stores data from messagesending class
          
    }
    
    public String getMyDataport(){
        return LBport; //returns the data which has been stored from messagesending class
        
    }
    
    
           
}

