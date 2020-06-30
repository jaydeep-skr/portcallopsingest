package net.shippingapp.portcallops.dischargelistingest.xmlentity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="discharge_list")

public class DischargeListData {

    String terminalID ;
    String estimatedTimeOfArrivalToPort ;
    String estimatedTimeOfDepartFromPort ;
    String previousPortCode ;
    String nextPortCode ;
    String previousPortEtd ;
    String previousPortAtd ;
    String nextPortEta ;
    PreCarrier preCarrier ;
    List <DischargeListShipment> dischargeListShipments ;

   

    

    public String getTerminalID() {
        return terminalID;
    }

    @XmlElement (name = "terminal_id")
    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public String getEstimatedTimeOfArrivalToPort() {
        return estimatedTimeOfArrivalToPort;
    }

    @XmlElement (name = "eta")
    public void setEstimatedTimeOfArrivalToPort(String estimatedTimeOfArrivalToPort) {
        this.estimatedTimeOfArrivalToPort = estimatedTimeOfArrivalToPort;
    }

    public String getEstimatedTimeOfDepartFromPort() {
        return estimatedTimeOfDepartFromPort;
    }

    @XmlElement (name = "etd")
    public void setEstimatedTimeOfDepartFromPort(String estimatedTimeOfDepartFromPort) {
        this.estimatedTimeOfDepartFromPort = estimatedTimeOfDepartFromPort;
    }

    public String getPreviousPortCode() {
        return previousPortCode;
    }

    @XmlElement (name = "previous_port")
    public void setPreviousPortCode(String previousPortCode) {
        this.previousPortCode = previousPortCode;
    }

    public String getNextPortCode() {
        return nextPortCode;
    }

    @XmlElement (name = "next_port")
    public void setNextPortCode(String nextPortCode) {
        this.nextPortCode = nextPortCode;
    }

    public String getPreviousPortEtd() {
        return previousPortEtd;
    }


    @XmlElement (name = "previous_port_etd")
    public void setPreviousPortEtd(String previousPortEtd) {
        this.previousPortEtd = previousPortEtd;
    }

    public String getPreviousPortAtd() {
        return previousPortAtd;
    }

    @XmlElement (name = "previous_port_atd")
    public void setPreviousPortAtd(String previousPortAtd) {
        this.previousPortAtd = previousPortAtd;
    }

    public String getNextPortEta() {
        return nextPortEta;
    }

    @XmlElement (name = "next_port_eta")
    public void setNextPortEta(String nextPortEta) {
        this.nextPortEta = nextPortEta;
    }

    

    
    public PreCarrier getPreCarrier() {
        return preCarrier;
    }

    @XmlElement (name = "pre_carrier")
    public void setPreCarrier(PreCarrier preCarrier) {
        this.preCarrier = preCarrier;
    }

    @XmlElement (name = "discharge_list_shipment")
    public List<DischargeListShipment> getDischargeListShipments() {
        return dischargeListShipments;
    }

    public void setDischargeListShipments(List<DischargeListShipment> dischargeListShipments) {
        this.dischargeListShipments = dischargeListShipments;
    }

    
   

   
    

    
}