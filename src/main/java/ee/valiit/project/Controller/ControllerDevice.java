package ee.valiit.project.Controller;

import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Service.ServiceDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public List<DeviceEntity> getAllDeviceInfo(@RequestParam(name = "sn", required = false) String sn,
                                               @RequestParam(name = "clientId", required = false) Integer clientId,
                                               @RequestParam(name = "productId", required = false) Integer productId,
                                               @RequestParam(name = "counter", required = false) Integer counter) {
        return serviceDevice.getAllDeviceInfo(sn, clientId, productId, counter);
    }
}
