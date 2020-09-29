package ee.valiit.project.Service;


import ee.valiit.project.Entity.EntityTechnician;
import ee.valiit.project.Repository.RepositoryTechnician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTechnician {

    @Autowired
    RepositoryTechnician repositoryTechnician;

    public void createTechnician(EntityTechnician request) {
        repositoryTechnician.createTechnician(request);
    }

    public int getTechnicianId(String name) {
        return repositoryTechnician.getTechnicianId(name);
    }

    public List<EntityTechnician> searchTechnicianNamelike(String queryString) {
        if (queryString == null) {
            queryString = "";
        }
        return repositoryTechnician.searchTechnicianNamelike(queryString);
    }

    public Boolean loginTechnician(EntityTechnician login) {
        String password = repositoryTechnician.getTechnicianPassword(login.getUsername());
        if (password.equals(login.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}


