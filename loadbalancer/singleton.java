/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;

/**
 *
 * @author patry
 */
public class singleton {
     private static singleton instance;
    
    private String duration;
    private String jobid;
    
    
    public singleton(){
        duration="";
        jobid=""; //storing data 
    }
    
    public static synchronized singleton getInstance(){
       // System.out.println("in get instance");
        if(instance==null) instance = new singleton();
        return instance;
        
    }
    
    public void setMydata(String dura, String joba){
        duration=dura;
          jobid=joba; //recieving job requests from case JOB
    }
    
    public String getMyDatadura(){
        return duration; //returning data stored from setMydata
        
    }
    
    public String getMyDatajoba(){
        return jobid;  //same as above
        
    }
}
//singleton used to get the job requests from the initiator and to pass them to the nodes