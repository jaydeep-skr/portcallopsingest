package net.shippingapp.portcallops.dischargelistingest.xmlentity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name ="equipment")

public class Equipment {

    private String equipmentNumber ;
    private String equipmentSize ;
    private String equipmentType ;
    private String equipmentISOCode ;

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    @XmlElement (name = "equipment_number")
    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getEquipmentSize() {
        return equipmentSize;
    }

    @XmlElement (name = "equipment_size")
    public void setEquipmentSize(String equipmentSize) {
        this.equipmentSize = equipmentSize;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    @XmlElement (name = "equipment_type")
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentISOCode() {
        return equipmentISOCode;
    }

    @XmlElement (name = "equipment_iso_code")
    public void setEquipmentISOCode(String equipmentISOCode) {
        this.equipmentISOCode = equipmentISOCode;
    }
    
}