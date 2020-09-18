package ee.valiit.project.Controller;

import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Entity.WorkOrderEntity;
import ee.valiit.project.Service.ServiceWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ControllerWO {
    @Autowired
    private ServiceWO serviceWO;

    @PostMapping("createWO")
    public void createWO(@RequestBody WorkOrderEntity request) {
        serviceWO.createWO(request);
    }


    //Get the whole list of work orders
    @GetMapping("getAllWorkOrders")
    public List<WorkOrderEntity> getAllWorkOrders() {
        return serviceWO.getWorkOrderInfoAll();
    }

    //get all work orders info by specific device id, product id, consumable id, technician id or status.
    @GetMapping("workOrder")
    public List<WorkOrderEntity> getAllWorkOrderInfo(@RequestParam(name = "query", required = false) String query)
//                                                     @RequestParam(name = "deviceId", required = false) Integer deviceId,
//                                                     @RequestParam(name = "consumableId", required = false) Integer consumableId,
//                                                     @RequestParam(name = "technicianId", required = false) Integer technicianId,
//                                                     @RequestParam(name = "status", required = false) Boolean status)
                                                     {
        return serviceWO.getAllWorkOrderInfo(query);
    }

    @GetMapping("workOrderStatus")
    public List<WorkOrderEntity> getWorkOrderInfoByStatus(@RequestParam(name = "status") Boolean status)
//                                                     @RequestParam(name = "deviceId", required = false) Integer deviceId,
//                                                     @RequestParam(name = "consumableId", required = false) Integer consumableId,
//                                                     @RequestParam(name = "technicianId", required = false) Integer technicianId,
//                                                     @RequestParam(name = "status", required = false) Boolean status)
    {
        return serviceWO.getAllWorkOrderInfoByStatus(status);
    }


    //Update status of specific work order by id
    @PutMapping("updateWorkOrderStatus/{a}")
    public void updateWorkOrderStatus(@RequestBody WorkOrderEntity workOrderEntity, @PathVariable ("a") int id){
        serviceWO.updateWorkOrderStatus(workOrderEntity, id);
    }

}
