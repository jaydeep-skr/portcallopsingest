package net.shippingapp.portcallops.dischargelistingest.xmlentity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="gleoReport")

public class DischargeListDocument {

    DischargeListData dischargeListData ;

    public DischargeListData getDischargeListData() {
        return dischargeListData;
    }

    @XmlElement (name = "discharge_list")
    public void setDischargeListData(DischargeListData dischargeListData) {
        this.dischargeListData = dischargeListData;
    }
    
    
}