package net.shippingapp.portcallops.dischargelistingest.xmlentity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="commodity")

public class Commodity {


    private String billOfLadingNumber ;
    private String commodityDesc ;

    public String getBillOfLadingNumber() {
        return billOfLadingNumber;
    }

    @XmlElement (name ="bill_of_lading_number")
    public void setBillOfLadingNumber(String billOfLadingNumber) {
        this.billOfLadingNumber = billOfLadingNumber;
    }

    @XmlElement (name ="commodity_description")
    public String getCommodityDesc() {
        return commodityDesc;
    }

    public void setCommodityDesc(String commodityDesc) {
        this.commodityDesc = commodityDesc;
    }


    
}