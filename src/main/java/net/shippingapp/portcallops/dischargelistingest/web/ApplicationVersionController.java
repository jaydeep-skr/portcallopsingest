package net.shippingapp.portcallops.dischargelistingest.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.shippingapp.portcallops.dischargelistingest.command.ContextConstants;
import net.shippingapp.portcallops.dischargelistingest.command.ParseLegacyDischargeFeedCommand;
import net.shippingapp.portcallops.dischargelistingest.command.PersistDischargeListDataCommand;
import net.shippingapp.portcallops.dischargelistingest.commandframework.Command;
import net.shippingapp.portcallops.dischargelistingest.commandframework.CommandQueue;
import net.shippingapp.portcallops.dischargelistingest.commandframework.CommandQueueContext;

@RestController
@RequestMapping("/")
public class ApplicationVersionController {

    @GetMapping("/appinfo")
    public ResponseEntity<ApplicationInfo> getApplicationInfo() {

        String xmlFilePath = System.getProperty("app.sample.xml.payload") ;
        System.out.println("xmlFilePath = " + xmlFilePath) ;
        
        try {

            CommandQueue ingestQueue = new CommandQueue() ;
            CommandQueueContext queueContext = new CommandQueueContext() ;
            queueContext.addToContext(ContextConstants.DISCHARGE_LIST_XML_SAMPLE_FILE, 
                                      xmlFilePath);
    
            Command parseLegacyDischargeFeedCommand = new ParseLegacyDischargeFeedCommand() ;
            parseLegacyDischargeFeedCommand.setQueueContext(queueContext);
            ingestQueue.addCommandToQueue(parseLegacyDischargeFeedCommand);

            Command persistDischargeListDataCommand = new PersistDischargeListDataCommand() ;
            persistDischargeListDataCommand.setQueueContext(queueContext);
            ingestQueue.addCommandToQueue(persistDischargeListDataCommand) ;

            ingestQueue.runQueue();

        } catch (Exception e) {

            e.printStackTrace();

        }
       


        ApplicationInfo applicationInfo = new ApplicationInfo() ;
        return ResponseEntity.ok(applicationInfo);

       
    }

}