package ee.valiit.project.Service;

import ee.valiit.project.Entity.EntityConsumable;
import ee.valiit.project.Repository.RepositoryConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceConsumable {

    @Autowired
    RepositoryConsumable repositoryConsumable;

    public void createConsumable(EntityConsumable consumable) {
        repositoryConsumable.createConsumable(consumable);
    }

    public int getConsumableID(String name) {
        return repositoryConsumable.getConsumableID(name);
    }

    //Get a specific consumable
    public List<EntityConsumable> getConsumableInfo(Integer id) {
        return repositoryConsumable.getConsumableInfo(id);
    }

    //Get the whole list of consumables
    public List<EntityConsumable> getConsumableInfoAll() {
        return repositoryConsumable.getConsumableInfoAll();
    }


}
