package ee.valiit.project.Service;

import ee.valiit.project.Repository.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClient {
    @Autowired
    RepositoryClient repositoryClient;


    public void createClient(String request) {
        repositoryClient.createClient(request);
    }
}
