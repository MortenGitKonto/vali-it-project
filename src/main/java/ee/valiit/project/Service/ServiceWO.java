package ee.valiit.project.Service;

import ee.valiit.project.Entity.EntityMobileWO;
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

    @Autowired
    RepositoryDevice repositoryDevice;

    public void createWO(EntityWO createWO, int consumableAmount, String consumable2, int consumableAmount2, String consumable3, int consumableAmount3) {
        int techId = repositoryTechnician.getTechnicianId(createWO.getTechnicianName());

        int productId = repositoryProduct.getproductID(createWO.getDeviceName().substring(0,createWO.getDeviceName().indexOf(" -")));
//      System.out.println(createWO.getDeviceName().substring(0,createWO.getDeviceName().indexOf(" -")));

        int deviceId = repositoryDevice.getDeviceId(createWO.getDeviceName());

        //Creates a work order table row
        repositoryWO.createWO(createWO, techId, productId, deviceId);

        //Consumable1 ID
        int consumableId = repositoryConsumable.getConsumableID(createWO.getConsumableName());

        //Creates work order consumables table rows
        int lastId = repositoryWO.getLastWorkOrderId();
        for(int i=1;i<=consumableAmount;i++){
            repositoryWorkOrderConsumable.createWorkOrderConsumable(lastId, consumableId);
        }

        //Updates consumables table by reducing the stock of the specific consumable
        int currentStock = repositoryConsumable.getConsumableStock(consumableId);
        repositoryConsumable.updateStock(consumableId, currentStock, consumableAmount);

        if(consumable2.equals("")) {

        } else {
            //Consumable2 ID
            int consumableId2 = repositoryConsumable.getConsumableID(consumable2);

            //Creates work order consumables table rows
            for (int i = 1; i <= consumableAmount2; i++) {
                repositoryWorkOrderConsumable.createWorkOrderConsumable(lastId, consumableId);
            }

            //Updates consumables table by reducing the stock of the specific consumable
            currentStock = repositoryConsumable.getConsumableStock(consumableId2);
            repositoryConsumable.updateStock(consumableId2, currentStock, consumableAmount2);
        }

        if(consumable3.equals("")) {
        }else{
            //Consumable2 ID
            int consumableId3 = repositoryConsumable.getConsumableID(consumable3);

            //Creates work order consumables table rows
            for (int i = 1; i <= consumableAmount3; i++) {
                repositoryWorkOrderConsumable.createWorkOrderConsumable(lastId, consumableId3);
            }

            //Updates consumables table by reducing the stock of the specific consumable
            currentStock = repositoryConsumable.getConsumableStock(consumableId3);
            repositoryConsumable.updateStock(consumableId3, currentStock, consumableAmount3);
        }


    }

    public void createMobileWO(EntityMobileWO request) {
        repositoryWO.createMobileWO(request);
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