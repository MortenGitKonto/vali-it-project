package ee.valiit.project.Service;

import ee.valiit.project.Entity.EntityClient;
import ee.valiit.project.Entity.EntityDevice;
import ee.valiit.project.Repository.RepositoryDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDevice {

    @Autowired
    RepositoryDevice repositoryDevice;

    public void createDevice(EntityDevice request) {
        repositoryDevice.createDevice(request);
    }

    public List<EntityDevice> getAllDeviceInfo(String query) {
        if (query == "") {
            return repositoryDevice.getAllDevices();
        } else {
            return repositoryDevice.query(query);
        }
    }

    public List<EntityDevice> deviceByDeviceName(String queryString) {
            return repositoryDevice.deviceByDeviceName(queryString);
    }

    //get all data where counter <= input
    public List<EntityDevice> getAllCounterLess(int counter) {
        return repositoryDevice.getAllCounterLess(counter);
    }

    //get all data where counter >= input
    public List<EntityDevice> getAllCounterMore(int counter) {
        return repositoryDevice.getAllCounterMore(counter);
    }

//TODO see functioon pole vist vajalik
    //  public List<EntityDevice> devicesByClientId(int clientId) {
    //  return repositoryDevice.devicesByClientId(clientId);
    //  }

    // devices by client name or product name or serial number
    public List<EntityClient> getDevicesBy(String clientLike, String productLike, String serialNumberLike) {
        return repositoryDevice.getDevicesBy(clientLike, productLike, serialNumberLike);
    }
}