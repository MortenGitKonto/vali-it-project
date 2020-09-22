package ee.valiit.project.Service;

import ee.valiit.project.Entity.ClientEntity;
import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Entity.WorkOrderMultiEntity;
import ee.valiit.project.Repository.RepositoryWO;
import ee.valiit.project.Entity.WorkOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceWO {
    @Autowired
    public RepositoryWO repositoryWO;

    public void createWO(WorkOrderEntity createWO) {
        repositoryWO.createWO(createWO);
    }

//    //TOPELT
//    public List<WorkOrderEntity> getWorkOrderInfo(int deviceId) {
//        return repositoryWO.getWorkOrderInfo(deviceId);
//    }

    //Get the whole list of work orders
    public List<WorkOrderEntity> getWorkOrderInfoAll() {
        return repositoryWO.getWorkOrderInfoAll();
    }

    //get all work orders info by specific device id, product id, consumable id, technician id or status.
    public List<WorkOrderEntity> getAllWorkOrderInfo(String query) {
        if(query.trim().length() == 0){
            return new ArrayList<>();
        //}else if (query.isEmpty()) {
            //return repositoryWO.getWorkOrderInfoAll();
        } else if (query.equals("true") || query.equals("false")) {
            return repositoryWO.getAllInfoByQueryBoolean(query);
        } else {
            return repositoryWO.getAllInfoByQuery(query);
        }
    }

    //get all work orders that are not done
    public List<WorkOrderEntity> getAllWorkOrderInfoByStatus(Boolean status) {
            return repositoryWO.getAllInfoByStatus(status);
    }


    //Update status of specific work order by id
    public void updateWorkOrderStatus(WorkOrderEntity workOrderEntity, Integer id) {
        repositoryWO.updateStatus(workOrderEntity, id);
    }

    public List<WorkOrderEntity> getWorkOrderById(int id) {
        return repositoryWO.getWorkOrderInfoById(id);
    }


    public List<WorkOrderMultiEntity> getWorkOrderBySimultaneousSearch(String device, String product, String technician) {

        return repositoryWO.getWorkOrdersBySimultaneousSearch(device, product, technician);

    }
}