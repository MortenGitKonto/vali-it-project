package ee.valiit.project.Controller;

import ee.valiit.project.Entity.WorkOrderEntity;
import ee.valiit.project.Service.ServiceWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerWO {
    @Autowired
    private ServiceWO serviceWO;

    @PostMapping("createWO")
    public void createWO(@RequestBody WorkOrderEntity request) {
        serviceWO.createWO(request);
    }

    //Get a specific work order
    @GetMapping("getOneWorkOrder/{a}")
    public List<WorkOrderEntity> getOneWorkOrder (@PathVariable("a") int deviceId) {
        return serviceWO.getWorkOrderInfo(deviceId);
    }

    //Get the whole list of work orders
    @GetMapping("getAllWorkOrders")
    public List<WorkOrderEntity> getAllWorkOrders() {
        return serviceWO.getWorkOrderInfoAll();
    }


}
