package ee.valiit.project.Service;

import ee.valiit.project.Entity.EntityClient;
import ee.valiit.project.Entity.EntityDevice;
import ee.valiit.project.Repository.RepositoryClient;
import ee.valiit.project.Repository.RepositoryDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClient {
    @Autowired
    RepositoryClient repositoryClient;

    @Autowired
    RepositoryDevice repositoryDevice;

    public void createClient(String request) {
        repositoryClient.createClient(request);
    }

    //search client_id via client name; and then return all device data via identified client_id
    public List<EntityDevice> getDeviceData(String name) {
        int clientId = repositoryClient.getClientId(name);
        return repositoryDevice.getDeviceData(clientId);
    }

    //search client_id via client name
    public int getClientId(String name) {
        return repositoryClient.getClientId(name);
    }

    // clients by partial match
    public List<EntityClient> getClientViaName(String queryString) {
        if (queryString == null) {
            queryString = "";
        }
        return repositoryClient.getClientViaName(queryString);
    }

}
