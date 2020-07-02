package net.shippingapp.portcallops.dischargelistingest.web;

public class ApplicationInfo {

    String applicationName = "Port Call Operations - Container Discharge List Ingester" ;
    String applicationVersion = "1.0.0" ;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }
    
}