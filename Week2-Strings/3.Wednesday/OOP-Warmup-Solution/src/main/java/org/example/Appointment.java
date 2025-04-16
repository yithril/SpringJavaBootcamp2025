package org.example;

public class Appointment {
    private String clientName;
    private String date;
    private String time;
    private String serviceType;

    public Appointment(String clientName, String date, String time, String serviceType) {
        this.clientName = clientName;
        this.date = date;
        this.time = time;
        this.serviceType = serviceType;
    }

    public Appointment(String clientName, String serviceType) {
        this.clientName = clientName;
        this.serviceType = serviceType;
        this.date = "TBD";
        this.time = "TBD";
    }

    //methods
    //getters and setters
    //custom methods
    //override methods
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isConfirmed(){
        if(date.equalsIgnoreCase("TBD") && time.equalsIgnoreCase("TBD")){
            return false;
        }
        else{
            return true;
        }
    }
}
