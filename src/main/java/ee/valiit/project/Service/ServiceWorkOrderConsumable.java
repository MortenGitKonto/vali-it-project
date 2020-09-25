package ee.valiit.project.Service;

import ee.valiit.project.Entity.EntityWOConsumable;
import ee.valiit.project.Repository.RepositoryWorkOrderConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceWorkOrderConsumable {

    @Autowired
    RepositoryWorkOrderConsumable repositoryWorkOrderConsumable;

//    public void createWorkOrderConsumable(EntityWOConsumable workOrderConsumable) {
//        repositoryWorkOrderConsumable.createWorkOrderConsumable(workOrderConsumable);
//    }

//    public int getConsumableID(String name) {
//        return repositoryConsumable.getConsumableID(name);
//    }
//
    //Get a specific consumable
    public List<EntityWOConsumable> getWorkOrderConsumableInfo(int id) {
        return repositoryWorkOrderConsumable.getWorkOrderConsumableInfo(id);
    }
//
    //Get the whole list of consumables
    public List<EntityWOConsumable> getWorkOrderConsumableInfoAll() {
        return repositoryWorkOrderConsumable.getWorkOrderConsumableInfoAll();
    }


}
