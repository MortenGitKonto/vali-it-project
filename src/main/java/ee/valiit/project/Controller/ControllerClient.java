package ee.valiit.project.Controller;

import ee.valiit.project.Request.Client;
import ee.valiit.project.Request.Device;
import ee.valiit.project.Service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerClient {
    @Autowired
    ServiceClient serviceClient;

    //create new client
    @PostMapping("client")
    public void createClient(@RequestBody Client request) {
        serviceClient.createClient(request.getName());
    }

    //search client_id via client name; and then return all device data via identified client_id
    @GetMapping("client/{name}")
    public Device client_id(@PathVariable("name") String name) {
        return serviceClient.getDeviceData(name);
    }

    @GetMapping("clientId/{name}")
    //search client_id via client name
    public int getClientId(@PathVariable("name") String name) {
        return serviceClient.getClientId(name);
    }

}
