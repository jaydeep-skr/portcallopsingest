package net.shippingapp.portcallops.dischargelistingest.commandframework;

import java.util.Map;

public interface Command {

    public String getName();

    public void setName();

    public void setContext();

    public Map getContext();

    public void execute() throws CommandException;

}