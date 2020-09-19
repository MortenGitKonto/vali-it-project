package ee.valiit.project.Service;

import ee.valiit.project.Entity.ClientEntity;
import ee.valiit.project.Repository.RepositoryClient;
import ee.valiit.project.Repository.RepositoryDevice;
import ee.valiit.project.Entity.DeviceEntity;
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
    public List<DeviceEntity> getDeviceData(String name) {
        int clientId = repositoryClient.getClientId(name);
        return repositoryDevice.getDeviceData(clientId);
    }

    //search client_id via client name
    public int getClientId(String name) {
        return repositoryClient.getClientId(name);
    }

    public List<ClientEntity> getClientViaName(String nameLike) {
        return repositoryClient.getClientViaName(nameLike);
    }
}
