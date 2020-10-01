package ee.valiit.project.Controller;

import ee.valiit.project.Entity.EntityTechnician;
import ee.valiit.project.Security.JWTTokenProvider;
import ee.valiit.project.Security.User;
import ee.valiit.project.Service.ServiceTechnician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ControllerTechnician {

    @Autowired
    ServiceTechnician serviceTechnician;

    @Autowired
    JWTTokenProvider jwtTokenProvider;

    //Create new technician
    @PostMapping("newTechnician")
    public void createTechnician(@RequestBody EntityTechnician request) {
        serviceTechnician.createTechnician(request);
    }

    //search technician via technician name
    @GetMapping("technician/{name}")
    public int getTechnicianId(@PathVariable("name") String name) {
        return serviceTechnician.getTechnicianId(name);
    }

    @GetMapping("technician/namelike")
    public List<EntityTechnician> searchTechnicianNamelike(@RequestParam(value = "queryString", required = false) String queryString) {
        if (queryString == null) {
            queryString = "";
        }
        return serviceTechnician.searchTechnicianNamelike(queryString);
    }

    @PostMapping("technician/logIn")
    public User login(@RequestBody EntityTechnician userpass) {
        return serviceTechnician.loginTechnician(userpass.getUsername(), userpass.getPassword());
    }

}



