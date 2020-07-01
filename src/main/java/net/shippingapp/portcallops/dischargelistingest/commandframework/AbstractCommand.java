package net.shippingapp.portcallops.dischargelistingest.commandframework;

import java.util.Map;

public abstract class AbstractCommand implements Command {

    protected String name ;
    protected Map    context ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map getContext() {
        return context;
    }

    public void setContext(Map context) {
        this.context = context;
    }

    public abstract void execute() throws CommandException ;
    
    
}