package ee.valiit.project.Controller;

import ee.valiit.project.Entity.EntityTechnician;
import ee.valiit.project.Entity.JWTTokenProvider;
import ee.valiit.project.Entity.User;
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
    public List<EntityTechnician> searchTechnicianNamelike(@RequestParam("queryString") String queryString) {
        return serviceTechnician.searchTechnicianNamelike(queryString);
    }

    @GetMapping("technician/logIn")
    public User login(@RequestParam("username")String user, @RequestParam("password") String pass) {
        return serviceTechnician.loginTechnician(user, pass);
    }

}



