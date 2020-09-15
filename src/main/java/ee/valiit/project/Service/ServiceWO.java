package ee.valiit.project.Service;

import ee.valiit.project.Repository.RepositoryWO;
import ee.valiit.project.Request.RequestWorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWO {
    @Autowired
    public RepositoryWO repositoryWO;

    public void createWO(RequestWorkOrder createWO) {
        repositoryWO.createWO(createWO);
    }
}
