package net.shippingapp.portcallops.dischargelistingest.xmlentity;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XMLParseApp {

    public static void main(String args[]) throws Exception {

        File xmlFilePath = new File("/Users/swarajitroy/Downloads/LISTDATA/AMPS_discharge_as_XML.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(DischargeListDocument.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        DischargeListDocument dischargeReport = (DischargeListDocument) jaxbUnmarshaller.unmarshal(xmlFilePath);
        System.out.println("Container Discharge List for Terminal = " + dischargeReport.getDischargeListData().getTerminalID());
        System.out.println(dischargeReport.getDischargeListData().getEstimatedTimeOfArrivalToPort());
        System.out.println(dischargeReport.getDischargeListData().getEstimatedTimeOfDepartFromPort());
        System.out.println(dischargeReport.getDischargeListData().getPreviousPortCode());
        System.out.println(dischargeReport.getDischargeListData().getNextPortCode());
        System.out.println(dischargeReport.getDischargeListData().getPreviousPortEtd());
        System.out.println(dischargeReport.getDischargeListData().getPreviousPortAtd());
        System.out.println(dischargeReport.getDischargeListData().getNextPortEta());
        System.out.println(dischargeReport.getDischargeListData().getPreCarrier().getVesselVoyage().getVesselCode());
        System.out.println(dischargeReport.getDischargeListData().getPreCarrier().getVesselVoyage().getVoyageCode());

        System.out.println(dischargeReport.getDischargeListData().getDischargeListShipments().size());
        for (int i =0 ; i < dischargeReport.getDischargeListData().getDischargeListShipments().size() ; i++) {
            DischargeListShipment dls = (DischargeListShipment) 
                                         dischargeReport.getDischargeListData().getDischargeListShipments().get(i) ;
            System.out.println(dls.getBookingNumber()) ;
            System.out.println("number of lines = " + dls.getDischargeListLines().size());

            System.out.println(dls.getDischargeListLines().get(0).getContainerDetails().getEquipment().getEquipmentNumber());
            System.out.println(dls.getDischargeListLines().get(0).getContainerDetails().getEquipment().getEquipmentSize());
            System.out.println(dls.getDischargeListLines().get(0).getContainerDetails().getOperator());
            System.out.println(dls.getDischargeListLines().get(0).getContainerDetails().getCommodity().getCommodityDesc());
            System.out.println("****");

        }
      
       

    }

}