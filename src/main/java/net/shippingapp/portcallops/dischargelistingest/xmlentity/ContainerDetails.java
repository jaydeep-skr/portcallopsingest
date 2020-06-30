package net.shippingapp.portcallops.dischargelistingest.xmlentity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="container_details")

public class ContainerDetails {

    private Equipment equipment ;
    private Commodity commodity ;
    private String    operator ;
    private String    grossWght ;

    public Equipment getEquipment() {
        return equipment;
    }

    @XmlElement (name = "equipment")
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getOperator() {
        return operator;
    }

    @XmlElement (name = "operator")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getGrossWght() {
        return grossWght;
    }

    @XmlElement (name = "gross_weight")
    public void setGrossWght(String grossWght) {
        this.grossWght = grossWght;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    @XmlElement (name = "commodity")
    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
    


}