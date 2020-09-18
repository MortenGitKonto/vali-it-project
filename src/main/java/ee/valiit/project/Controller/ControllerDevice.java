package ee.valiit.project.Controller;

import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Service.ServiceDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ControllerDevice {

    @Autowired
    ServiceDevice serviceDevice;

    //create new device
    @PostMapping("device")
    public void createDevice(@RequestBody DeviceEntity request) {
        serviceDevice.createDevice(request);
    }

    //get all device info by any DeviceEntity variable
    @GetMapping("device")
    public List<DeviceEntity> getAllDeviceInfo(@RequestParam(name = "query", required = false) String query){
        return serviceDevice.getAllDeviceInfo(query);
    }

    //get all device info where counter <= input
    @GetMapping("deviceCounterLess")
    public List<DeviceEntity> getDeviceDataCounterLess(@RequestParam("counter") int counter) {
        return serviceDevice.getAllCounterLess(counter);
    }

    //get all device info where counter >= input
    @GetMapping("deviceCounterMore")
    public List<DeviceEntity> getDeviceDataCounterMore(@RequestParam("counter") int counter) {
        return serviceDevice.getAllCounterMore(counter);
    }
}