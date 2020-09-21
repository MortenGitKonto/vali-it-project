package ee.valiit.project.Controller;

import ee.valiit.project.Entity.ConsumableEntity;
import ee.valiit.project.Entity.WorkOrderConsumableEntity;
import ee.valiit.project.Service.ServiceConsumable;
import ee.valiit.project.Service.ServiceWorkOrderConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ControllerWorkOrderConsumable {

    @Autowired
    ServiceWorkOrderConsumable serviceWorkOrderConsumable;

    //create new work order consumable
    @PostMapping("workOrderConsumable")
    public void createWorkOrderConsumable(@RequestBody WorkOrderConsumableEntity workOrderConsumable) {
        serviceWorkOrderConsumable.createWorkOrderConsumable(workOrderConsumable);
    }
//
//    //search consumable unique id via consumable name
//    @GetMapping("consumable/{name}")
//    public int getConsumableID(@PathVariable("name") String name) {
//        return serviceConsumable.getConsumableID(name);
//    }
//
    //Get a specific work order consumable
    @GetMapping("workOrderConsumableInfoById")
    public List<WorkOrderConsumableEntity> getWorkOrderConsumableInfo(@RequestParam(name = "id") int id) {
        return serviceWorkOrderConsumable.getWorkOrderConsumableInfo(id);
    }
//
    //Get the whole list of workorder consumables
    @GetMapping("workOrderConsumableInfo")
    public List<WorkOrderConsumableEntity> getWorkOrderConsumableInfoAll() {
        return serviceWorkOrderConsumable.getWorkOrderConsumableInfoAll();
    }

}
