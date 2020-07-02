package net.shippingapp.portcallops.dischargelistingest.commandframework;

public class CommandException extends Exception {

    public CommandException(Exception e) {
        super(e) ;
    }
    
}