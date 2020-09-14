package ee.valiit.project.Service;

import ee.valiit.project.Repository.RepositoryWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWO {
    @Autowired
    public RepositoryWO repositoryWO;

    public void createWO(int deviceId, String jobDescription, String technicianName) {
        repositoryWO.createWO(deviceId, jobDescription, technicianName);
    }
}
