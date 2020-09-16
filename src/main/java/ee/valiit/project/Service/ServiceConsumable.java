package ee.valiit.project.Service;

import ee.valiit.project.Entity.ConsumableEntity;
import ee.valiit.project.Repository.RepositoryConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
