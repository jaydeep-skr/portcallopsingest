package net.shippingapp.portcallops.dischargelistingest.command;

import net.shippingapp.portcallops.dischargelistingest.commandframework.CommandException;

import net.shippingapp.portcallops.dischargelistingest.xmlentity.DischargeListDocument;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


public class ParseLegacyDischargeFeedCommand extends BaseCommand {

    

    public void execute() throws CommandException {

       
        DischargeListDocument dischargeReport = null ;

        try {

            File xmlFilePath = new File(System.getProperty("app.sample.xml.payload"));
            JAXBContext jaxbContext = JAXBContext.newInstance(DischargeListDocument.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            dischargeReport = (DischargeListDocument) jaxbUnmarshaller.unmarshal(xmlFilePath);
            System.out.println(dischargeReport.getDischargeListData().getTerminalID());


            this.getQueueContext().addToContext(ContextConstants.DISCHARGE_LIST_XML_TO_OBJECT_KEY, 
                                               dischargeReport);
       
        } catch (Exception e) {

            e.printStackTrace();
            throw new CommandException(e) ;
        }

        

    }
    
}