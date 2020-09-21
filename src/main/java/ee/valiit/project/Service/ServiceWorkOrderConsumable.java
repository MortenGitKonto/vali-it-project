package ee.valiit.project.Service;

import ee.valiit.project.Entity.ConsumableEntity;
import ee.valiit.project.Entity.WorkOrderConsumableEntity;
import ee.valiit.project.Repository.RepositoryConsumable;
import ee.valiit.project.Repository.RepositoryWorkOrderConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceWorkOrderConsumable {

    @Autowired
    RepositoryWorkOrderConsumable repositoryWorkOrderConsumable;

    public void createWorkOrderConsumable(WorkOrderConsumableEntity workOrderConsumable) {
        repositoryWorkOrderConsumable.createWorkOrderConsumable(workOrderConsumable);
    }

//    public int getConsumableID(String name) {
//        return repositoryConsumable.getConsumableID(name);
//    }
//
    //Get a specific consumable
    public List<WorkOrderConsumableEntity> getWorkOrderConsumableInfo(int id) {
        return repositoryWorkOrderConsumable.getWorkOrderConsumableInfo(id);
    }
//
    //Get the whole list of consumables
    public List<WorkOrderConsumableEntity> getWorkOrderConsumableInfoAll() {
        return repositoryWorkOrderConsumable.getWorkOrderConsumableInfoAll();
    }


}
