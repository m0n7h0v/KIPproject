package com.kipproject.kip.conroller;

import com.kipproject.kip.model.Device;
import com.kipproject.kip.repo.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
