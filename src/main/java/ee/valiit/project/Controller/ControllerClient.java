package ee.valiit.project.Controller;

import ee.valiit.project.Entity.EntityClient;
import ee.valiit.project.Entity.EntityDevice;
import ee.valiit.project.Service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ControllerClient {
    @Autowired
    ServiceClient serviceClient;

    //create new client
    @PostMapping("client")
    public void createClient(@RequestBody EntityClient request) {
        serviceClient.createClient(request.getName());
    }

    //search client_id via client name; and then return all device data via identified client_id
    @GetMapping("client/{name}")
    public List<EntityDevice> client_id(@PathVariable("name") String name) {
        return serviceClient.getDeviceData(name);
    }

    @GetMapping("clientId/{name}")
    //search client_id via client name
    public int getClientId(@PathVariable("name") String name) {
        return serviceClient.getClientId(name);
    }

    // clients by partial match
    @GetMapping("/client/namelike")
    public List<EntityClient> searchClient(@RequestParam(value = "queryString", required = false) String queryString) {
//        if (queryString == null) {
//            queryString = "";
//        }
        return serviceClient.getClientViaName(queryString);
    }

}
