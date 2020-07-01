package net.shippingapp.portcallops.dischargelistingest.commandframework;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {

    private List queue = new  ArrayList() ;

    public void addCommandToQueue(Command command) {
        queue.add(command) ;
    }

    public void runQueue() {
    
        try {

             for(int i=0 ; i < queue.size() ; i++) {
                 Command command = (Command) queue.get(i) ;
                 command.execute(); 
             }


        } catch (Exception e) {
            e.printStackTrace(); 
        }


    }
    
}