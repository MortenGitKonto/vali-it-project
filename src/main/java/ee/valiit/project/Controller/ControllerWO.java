package ee.valiit.project.Controller;

import ee.valiit.project.Entity.ClientEntity;
import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Entity.WorkOrderEntity;
import ee.valiit.project.Entity.WorkOrderMultiEntity;
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

    //Get the whole list of work orders in simultaneous search page
    @GetMapping("workOrderAll")
    public List<WorkOrderMultiEntity> getAllWorkOrdersMulti() {
        return serviceWO.getWorkOrderInfoAllMulti();
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


    // work orders by four simultaneous input searches
    @GetMapping("workOrderSimultaneousSearch")
    public List<WorkOrderMultiEntity> getWorkOrdersBySimultaneousSearch(@RequestParam(name = "client", required = false) String client,
                                                                        @RequestParam(name = "device", required = false) String device,
                                                                        @RequestParam(name = "product", required = false) String product,
                                                                        @RequestParam(name = "technician", required = false) String technician,
                                                                        @RequestParam(name = "status", required = false) Boolean status) {
        return serviceWO.getWorkOrderBySimultaneousSearch(client, device, product, technician, status);
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
    public void updateWorkOrderStatus(@RequestBody WorkOrderEntity workOrderEntity, @PathVariable("a") int id) {
        serviceWO.updateWorkOrderStatus(workOrderEntity, id);
    }

    //Get workorder by ID
    @GetMapping("workOrderById")
    public List<WorkOrderEntity> getWorkOrderById(@RequestParam(name = "id") int id) {
        return serviceWO.getWorkOrderById(id);
    }


}
