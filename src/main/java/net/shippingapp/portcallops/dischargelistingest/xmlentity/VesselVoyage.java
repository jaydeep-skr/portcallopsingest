package net.shippingapp.portcallops.dischargelistingest.xmlentity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="vessel_voyage")

public class VesselVoyage {

    String vesselCode ;
    String voyageCode ;

    public String getVesselCode() {
        return vesselCode;
    }

    @XmlElement (name = "vessel_code")
    public void setVesselCode(String vesselCode) {
        this.vesselCode = vesselCode;
    }

    public String getVoyageCode() {
        return voyageCode;
    }

    @XmlElement (name = "voyage_number")
    public void setVoyageCode(String voyageCode) {
        this.voyageCode = voyageCode;
    }

    

    
}