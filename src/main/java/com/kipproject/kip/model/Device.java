package com.kipproject.kip.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer deviceId;

    private String deviceName;

    private Integer numberOfDevices;

    private String deviceDescription;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getNumberOfDevices() {
        return numberOfDevices;
    }

    public void setNumberOfDevices(Integer numberOfDevices) {
        this.numberOfDevices = numberOfDevices;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String descriptionDevices) {
        this.deviceDescription = descriptionDevices;
    }
}
