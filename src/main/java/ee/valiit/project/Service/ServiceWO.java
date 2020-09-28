package ee.valiit.project.Service;

import ee.valiit.project.Entity.EntityWOConsumable;
import ee.valiit.project.Entity.EntityWOMulti;
import ee.valiit.project.Repository.*;
import ee.valiit.project.Entity.EntityWO;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceWO {
    @Autowired
    public RepositoryWO repositoryWO;

    @Autowired
    RepositoryTechnician repositoryTechnician;

    @Autowired
    RepositoryProduct repositoryProduct;

    @Autowired
    RepositoryConsumable repositoryConsumable;

    @Autowired
    RepositoryWorkOrderConsumable repositoryWorkOrderConsumable;

    public void createWO(EntityWO createWO, int consumableAmount) {
        int techId = repositoryTechnician.getTechnicianId(createWO.getTechnicianName());
        int productId = repositoryProduct.getproductID(createWO.getProductName());
        int consumableId = repositoryConsumable.getConsumableID(createWO.getConsumableName());

        //Creates a work order table row
        repositoryWO.createWO(createWO, techId, productId, consumableId);

        //Creates work order consumables table rows
        int lastId = repositoryWO.getLastWorkOrderId();
        for(int i=1;i<=consumableAmount;i++){
            repositoryWorkOrderConsumable.createWorkOrderConsumable(lastId, consumableId);
        }

        //Updates consumables table by reducing the stock of the specific consumable
        //Currently I hard-code it to 1. Later the amount should be flexible.
        int reduceAmount=consumableAmount;
        int currentStock = repositoryConsumable.getConsumableStock(consumableId);
        repositoryConsumable.updateStock(consumableId, currentStock, reduceAmount);
    }

//    //TOPELT
//    public List<EntityWO> getWorkOrderInfo(int deviceId) {
//        return repositoryWO.getWorkOrderInfo(deviceId);
//    }

    //Get the whole list of work orders
    public List<EntityWO> getWorkOrderInfoAll() {
        return repositoryWO.getWorkOrderInfoAll();
    }


    //Get the whole list of work orders MULTI
    public List<EntityWOMulti> getWorkOrderInfoAllMulti() {
        return repositoryWO.getWorkOrderInfoAllMulti();
    }


    //get all work orders info by specific device id, product id, consumable id, technician id or status.
    public List<EntityWO> getAllWorkOrderInfo(String query) {
        if (query.trim().length() == 0) {
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
    public List<EntityWO> getAllWorkOrderInfoByStatus(Boolean status) {
        return repositoryWO.getAllInfoByStatus(status);
    }


    //Update status of specific work order by id
    public void updateWorkOrderStatus(EntityWO entityWO, Integer id) {
        repositoryWO.updateStatus(entityWO, id);
    }

    public List<EntityWO> getWorkOrderById(int id) {
        return repositoryWO.getWorkOrderInfoById(id);
    }


    public List<EntityWOMulti> getWorkOrderBySimultaneousSearch(String client, String device, String product, String technician, Boolean status) {

        if (client == null) {
            client = "";
        }

        if (device == null) {
            device = "";
        }

        if (technician == null) {
            technician = "";
        }

        if (product == null) {
            product = "";
        }

        if (status == null) {
            return repositoryWO.getWorkOrdersBySimultaneousSearch(client, device, product, technician);
        } else {
            return repositoryWO.getWorkOrdersBySimultaneousSearchWithStatus(client, device, product, technician, status);
        }
    }
}