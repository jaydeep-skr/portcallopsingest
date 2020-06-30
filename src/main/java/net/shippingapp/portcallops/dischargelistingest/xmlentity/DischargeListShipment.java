package net.shippingapp.portcallops.dischargelistingest.xmlentity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="discharge_list_shipment")

public class DischargeListShipment {

    String bookingNumber ;
    List <DischargeListLine> dischargeListLines ;



    public String getBookingNumber() {
        return bookingNumber;
    }

    @XmlElement (name = "booking_number")
    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @XmlElement (name = "discharge_list_line")
    public List<DischargeListLine> getDischargeListLines() {
        return dischargeListLines;
    }

    public void setDischargeListLines(List<DischargeListLine> dischargeListLines) {
        this.dischargeListLines = dischargeListLines;
    }
    


    
}