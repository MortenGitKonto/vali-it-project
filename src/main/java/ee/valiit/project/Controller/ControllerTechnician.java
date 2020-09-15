package ee.valiit.project.Controller;

import ee.valiit.project.Request.Device;
import ee.valiit.project.Request.Technician;
import ee.valiit.project.Service.ServiceTechnician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerTechnician {

    @Autowired
    ServiceTechnician serviceTechnician;

    //Create new technician
    @PostMapping("newTechnician")
    public void createTechnician(@RequestBody Technician request) {
        serviceTechnician.createTechnician(request);
    }

    //search technician via technician name
    @GetMapping("technician/{name}")
    public int getTechnicianId(@PathVariable("name") String name) {
        return serviceTechnician.getTechnicianId(name);
    }
}



