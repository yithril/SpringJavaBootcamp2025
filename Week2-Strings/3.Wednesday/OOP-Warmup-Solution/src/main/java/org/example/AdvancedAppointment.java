package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

//This is very advanced so if you don't get it that's perfectly fine.
public class AdvancedAppointment {
    private String clientName;
    private Optional<LocalDate> date;
    private Optional<LocalTime> time;
    private ServiceType serviceType;

    public AdvancedAppointment(String clientName, LocalDate date, LocalTime time, ServiceType serviceType) {
        this.clientName = clientName;
        this.date = Optional.ofNullable(date);
        this.time = Optional.ofNullable(time);
        this.serviceType = serviceType != null ? serviceType : ServiceType.OTHER;
    }

    // Partial constructor: no date/time
    public AdvancedAppointment(String clientName, ServiceType serviceType) {
        this.clientName = clientName;
        this.date = Optional.empty();
        this.time = Optional.empty();
        this.serviceType = serviceType != null ? serviceType : ServiceType.OTHER;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Optional<LocalDate> getDate() {
        return date;
    }

    public void setDate(Optional<LocalDate> date) {
        this.date = date;
    }

    public Optional<LocalTime> getTime() {
        return time;
    }

    public void setTime(Optional<LocalTime> time) {
        this.time = time;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isConfirmed() {
        return date.isPresent() && time.isPresent();
    }
}
