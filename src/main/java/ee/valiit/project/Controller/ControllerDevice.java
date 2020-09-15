package ee.valiit.project.Controller;

import ee.valiit.project.Request.Device;
import ee.valiit.project.Service.ServiceDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ControllerDevice {

    @Autowired
    ServiceDevice serviceDevice;

    //create new device
    @PostMapping("device")
    public void createDevice(@RequestBody Device request) {
        serviceDevice.createDevice(request);
    }

    //get all device info by serialNumber
    @GetMapping("device")
    public List<Device> getAllDeviceInfo(@RequestParam(name = "sn", required = false) String sn,
                                         @RequestParam(name = "clientId", required = false) Integer clientId) {
        serviceDevice.getAllDeviceInfo(sn, clientId);
        return serviceDevice.getAllDeviceInfo(sn, clientId);
    }
}
