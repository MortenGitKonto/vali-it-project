package ee.valiit.project.Service;

import ee.valiit.project.Entity.ConsumableEntity;
import ee.valiit.project.Repository.RepositoryConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceConsumable {

    @Autowired
    RepositoryConsumable repositoryConsumable;

    public void createConsumable(ConsumableEntity consumable) {
        repositoryConsumable.createConsumable(consumable);
    }

    public int getConsumableID(String name) {
        return repositoryConsumable.getConsumableID(name);
    }

    //Get a specific consumable
    public List<ConsumableEntity> getConsumableInfo(Integer id) {
        return repositoryConsumable.getConsumableInfo(id);
    }

    //Get the whole list of consumables
    public List<ConsumableEntity> getConsumableInfoAll() {
        return repositoryConsumable.getConsumableInfoAll();
    }


}
