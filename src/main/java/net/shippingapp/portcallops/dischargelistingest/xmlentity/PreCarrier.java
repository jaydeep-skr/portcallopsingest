package net.shippingapp.portcallops.dischargelistingest.xmlentity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="pre_carrier")
public class PreCarrier {

    VesselVoyage vesselVoyage ;

    public VesselVoyage getVesselVoyage() {
        return vesselVoyage;
    }

    @XmlElement (name = "vessel_voyage")
    public void setVesselVoyage(VesselVoyage vesselVoyage) {
        this.vesselVoyage = vesselVoyage;
    }
    
    
}