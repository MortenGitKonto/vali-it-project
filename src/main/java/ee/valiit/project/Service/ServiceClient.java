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

    // clients by partial match
    public List<ClientEntity> getClientViaName(String nameLike) {
        if (nameLike != "") {
            return repositoryClient.getClientViaName(nameLike);
        } else {
            return null;
        }
    }

    // devices by client name or product name or serial number
    public List<ClientEntity> getDevicesByClientName(String clientLike, String productLike, String serialNumberLike) {
        return repositoryClient.getDevicesByClientName(clientLike, productLike, serialNumberLike);
    }
}
