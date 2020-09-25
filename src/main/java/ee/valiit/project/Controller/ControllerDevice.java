package ee.valiit.project.Controller;

import ee.valiit.project.Entity.EntityClient;
import ee.valiit.project.Entity.EntityDevice;
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
//    @PostMapping("device")
//    public void createDevice(@RequestBody EntityDevice request) {
//        serviceDevice.createDevice(request);
//    }

    //create new device by name info
    @PostMapping("device")
    public void newDevice(@RequestParam("client") String clientName,
                          @RequestParam("sn") String sn,
                          @RequestParam("counter") int counter,
                          @RequestParam("product") String productName) {
        serviceDevice.newDevice(clientName, sn, counter, productName);
    }

    //get all device info by any EntityDevice variable
    @GetMapping("device")
    public List<EntityDevice> getAllDeviceInfo(@RequestParam(name = "query", required = false) String query){
        return serviceDevice.getAllDeviceInfo(query);
    }

//TODO pole vist vajalik
    //    get devices by clientId
    //    @GetMapping("device/{clientId}")
    //    public List<EntityDevice> devicesByClientId(@PathVariable("clientId") int clientId) {
    //        return serviceDevice.devicesByClientId(clientId);
    //    }

    //get all device info where counter <= input
    @GetMapping("deviceCounterLess")
    public List<EntityDevice> getDeviceDataCounterLess(@RequestParam("counter") int counter) {
        return serviceDevice.getAllCounterLess(counter);
    }

    //get all device info where counter >= input
    @GetMapping("deviceCounterMore")
    public List<EntityDevice> getDeviceDataCounterMore(@RequestParam("counter") int counter) {
        return serviceDevice.getAllCounterMore(counter);
    }

    // devices by client name
    @GetMapping("devicelike")
    public List<EntityClient> getDevicesByClientName(@RequestParam(name = "clientLike", required = false) String clientLike,
                                                     @RequestParam(name = "productLike", required = false) String productLike,
                                                     @RequestParam(name = "serialNumberLike", required = false) String serialNumberLike) {
        return serviceDevice.getDevicesBy(clientLike, productLike, serialNumberLike);
    }
}