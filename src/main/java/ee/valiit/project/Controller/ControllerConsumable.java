package ee.valiit.project.Controller;

import ee.valiit.project.Entity.ConsumableEntity;
import ee.valiit.project.Service.ServiceConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ControllerConsumable {

    @Autowired
    ServiceConsumable serviceConsumable;

    //create new consumable
    @PostMapping("consumable")
    public void createConsumable(@RequestBody ConsumableEntity consumable) {
        serviceConsumable.createConsumable(consumable);
    }

    //search consumable unique id via consumable name
    @GetMapping("consumable/{name}")
    public int getConsumableID(@PathVariable("name") String name) {
        return serviceConsumable.getConsumableID(name);
    }

    //Get a specific consumable
    @GetMapping("consumableInfo/{id}")
    public List<ConsumableEntity> getConsumableInfo(@PathVariable("id") Integer id) {
        return serviceConsumable.getConsumableInfo(id);
    }

    //Get the whole list of consumables
    @GetMapping("consumableInfo")
    public List<ConsumableEntity> getConsumableInfoAll() {
        return serviceConsumable.getConsumableInfoAll();
    }

}
