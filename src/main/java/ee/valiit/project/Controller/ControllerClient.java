package ee.valiit.project.Controller;

import ee.valiit.project.Request.Client;
import ee.valiit.project.Service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClient {
    @Autowired
    ServiceClient serviceClient;

    //create new client
    @PostMapping("client")
    public void createClient(@RequestBody Client request) {
        serviceClient.createClient(request.getName());
    }


}
