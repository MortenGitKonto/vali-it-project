package ee.valiit.project.Service;



import ee.valiit.project.Entity.EntityTechnician;
import ee.valiit.project.Security.JWTTokenProvider;
import ee.valiit.project.Security.User;
import ee.valiit.project.Repository.RepositoryTechnician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTechnician {

    @Autowired
    RepositoryTechnician repositoryTechnician;

    @Autowired
    JWTTokenProvider jwtTokenProvider;

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

    public User loginTechnician(String username, String password) {
        String pass = repositoryTechnician.getTechnicianPassword(username);
        User user = new User();
        if (password.equals(pass)) {
            user.setStatus(true);
        } else {
            user.setStatus(false);
        }
        user.setToken(jwtTokenProvider.createToken(username));
        return user;
    }
}


