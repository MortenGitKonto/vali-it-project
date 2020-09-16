package ee.valiit.project.Controller;

import ee.valiit.project.Entity.ConsumableEntity;
import ee.valiit.project.Service.ServiceConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

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
}
