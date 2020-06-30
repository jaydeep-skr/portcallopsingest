package net.shippingapp.portcallops.dischargelistingest.xmlentity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="discharge_list_line")

public class DischargeListLine {

    private ContainerDetails containerDetails ;

    @XmlElement (name ="container_details")
    public ContainerDetails getContainerDetails() {
        return containerDetails;
    }

    public void setContainerDetails(ContainerDetails containerDetails) {
        this.containerDetails = containerDetails;
    }
    
}