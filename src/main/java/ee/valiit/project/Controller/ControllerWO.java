package ee.valiit.project.Controller;

import ee.valiit.project.Entity.EntityMobileWO;
import ee.valiit.project.Entity.EntityWO;
import ee.valiit.project.Entity.EntityWOMulti;
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
    public void createWO(@RequestBody EntityWO request, @RequestParam(name = "consumableAmount", required = false) int consumableAmount,
                         @RequestParam(name = "consumable2", required = false) String consumable2, @RequestParam(name = "consumableAmount2", required = false) int consumableAmount2,
                         @RequestParam(name = "consumable3", required = false) String consumable3, @RequestParam(name = "consumableAmount3", required = false) int consumableAmount3)
    {
        serviceWO.createWO(request, consumableAmount, consumable2, consumableAmount2, consumable3, consumableAmount3);
    }

    @PostMapping("device/mobilewo")
    public void createMobileWO(@RequestBody EntityMobileWO request) {
        serviceWO.createMobileWO(request);
    }


    //Get the whole list of work orders
    @GetMapping("getAllWorkOrders")
    public List<EntityWO> getAllWorkOrders() {
        return serviceWO.getWorkOrderInfoAll();
    }

    //Get the whole list of work orders in simultaneous search page
    @GetMapping("workOrderAll")
    public List<EntityWOMulti> getAllWorkOrdersMulti() {
        return serviceWO.getWorkOrderInfoAllMulti();
    }

    //get all work orders info by specific device id, product id, consumable id, technician id or status.
    @GetMapping("workOrder")
    public List<EntityWO> getAllWorkOrderInfo(@RequestParam(name = "query", required = false) String query)
//                                                     @RequestParam(name = "deviceId", required = false) Integer deviceId,
//                                                     @RequestParam(name = "consumableId", required = false) Integer consumableId,
//                                                     @RequestParam(name = "technicianId", required = false) Integer technicianId,
//                                                     @RequestParam(name = "status", required = false) Boolean status)
    {
        return serviceWO.getAllWorkOrderInfo(query);
    }


    // work orders by four simultaneous input searches
    @GetMapping("workOrderSimultaneousSearch")
    public List<EntityWOMulti> getWorkOrdersBySimultaneousSearch(@RequestParam(name = "client", required = false) String client,
                                                                 @RequestParam(name = "deviceName", required = false) String device,
                                                                 @RequestParam(name = "product", required = false) String product,
                                                                 @RequestParam(name = "technician", required = false) String technician,
                                                                 @RequestParam(name = "status", required = false) Boolean status) {
        return serviceWO.getWorkOrderBySimultaneousSearch(client, device, product, technician, status);
    }


    @GetMapping("workOrderStatus")
    public List<EntityWO> getWorkOrderInfoByStatus(@RequestParam(name = "status") Boolean status)
//                                                     @RequestParam(name = "deviceId", required = false) Integer deviceId,
//                                                     @RequestParam(name = "consumableId", required = false) Integer consumableId,
//                                                     @RequestParam(name = "technicianId", required = false) Integer technicianId,
//                                                     @RequestParam(name = "status", required = false) Boolean status)
    {
        return serviceWO.getAllWorkOrderInfoByStatus(status);
    }


    //Update status of specific work order by id
    @PutMapping("updateWorkOrderStatus/{a}")
    public void updateWorkOrderStatus(@RequestBody EntityWO entityWO, @PathVariable("a") int id) {
        serviceWO.updateWorkOrderStatus(entityWO, id);
    }

    //Update technicianName of specific work order by id
    @PutMapping("updateWorkOrderTechnicianName")
    public void updateWorkOrderStatus(@RequestParam(name = "technicianName") String editedName, @RequestParam(name = "workOrderId") int workOrderId) {
        serviceWO.updateWorkOrderTechnicianName(workOrderId, editedName);
    }

    //Get workorder by ID
    @GetMapping("workOrderById")
    public List<EntityWO> getWorkOrderById(@RequestParam(name = "id") int id) {
        return serviceWO.getWorkOrderById(id);
    }


}
