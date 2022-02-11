package com.kipproject.kip.repo;

import com.kipproject.kip.model.Device;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepo extends CrudRepository<Device,Integer> {
    public List<Device> findDeviceByDeviceName(String deviceName);
}
