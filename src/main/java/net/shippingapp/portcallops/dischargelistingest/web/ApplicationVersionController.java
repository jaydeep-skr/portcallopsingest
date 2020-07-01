package net.shippingapp.portcallops.dischargelistingest.web;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationVersionController {

    

    @GetMapping("/appinfo")
    public ResponseEntity<ApplicationInfo> getApplicationInfo() {

       
        ApplicationInfo applicationInfo = new ApplicationInfo() ;
        return ResponseEntity.ok(applicationInfo);

       
    }

}