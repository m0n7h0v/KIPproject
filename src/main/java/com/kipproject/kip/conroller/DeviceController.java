package com.kipproject.kip.conroller;

import com.kipproject.kip.model.Device;
import com.kipproject.kip.repo.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "device")
public class DeviceController {
    @Autowired
    private DeviceRepo deviceRepo;

    @GetMapping(path = "all")
    public String getAllDevices(Model model){

        Iterable<Device> devices = deviceRepo.findAll();
        model.addAttribute("devices",devices);

        return "showAllDevices";
    }
    @GetMapping("filter")
    public String filterForm(Model model) {
        model.addAttribute("deviceF", new Device());
        return "filter";
    }

    @PostMapping("filter")
    public String filter(@ModelAttribute Device deviceF, Model model){
        model.addAttribute("deviceF",deviceF);
        Iterable<Device> deviceByDeviceName = deviceRepo.findDeviceByDeviceName(deviceF.getDeviceName());
        model.addAttribute("deviceByDeviceName",deviceByDeviceName);
        return "filter";
    }

    @GetMapping("add")
    public String addForm(Model model) {
        model.addAttribute("device", new Device());
        return "addDevice";
    }

    @PostMapping("add")
    public String addSubmit(@ModelAttribute Device device, Model model) {
        model.addAttribute("device", device);
        deviceRepo.save(copyModelToObject(device));
        return "redirect:/device/all";
    }

    public Device copyModelToObject(Device device){
        Device newDev = new Device();
        newDev.setDeviceName(device.getDeviceName());
        newDev.setNumberOfDevices(device.getNumberOfDevices());
        newDev.setDeviceDescription(device.getDeviceDescription());
        return newDev;
    }
}
