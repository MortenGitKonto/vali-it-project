package ee.valiit.project.Service;


import ee.valiit.project.Repository.RepositoryTechnician;
import ee.valiit.project.Request.Device;
import ee.valiit.project.Request.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTechnician {

    @Autowired
    RepositoryTechnician repositoryTechnician;

    public void createTechnician(Technician request) {
        repositoryTechnician.createTechnician(request);
    }

    public int getTechnicianId(String name) {
        return repositoryTechnician.getTechnicianId(name);
    }
}

