package ee.valiit.project.Service;

import ee.valiit.project.Entity.ClientEntity;
import ee.valiit.project.Repository.RepositoryDevice;
import ee.valiit.project.Entity.DeviceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDevice {

    @Autowired
    RepositoryDevice repositoryDevice;

    public void createDevice(DeviceEntity request) {
        repositoryDevice.createDevice(request);
    }

    public List<DeviceEntity> getAllDeviceInfo(String query) {
        if (query == "") {
            return repositoryDevice.getAllDevices();
        } else {
            return repositoryDevice.query(query);
        }
    }

    //get all data where counter <= input
    public List<DeviceEntity> getAllCounterLess(int counter) {
        return repositoryDevice.getAllCounterLess(counter);
    }

    //get all data where counter >= input
    public List<DeviceEntity> getAllCounterMore(int counter) {
        return repositoryDevice.getAllCounterMore(counter);
    }

//TODO see functioon pole vist vajalik
    //  public List<DeviceEntity> devicesByClientId(int clientId) {
    //  return repositoryDevice.devicesByClientId(clientId);
    //  }

    // devices by client name or product name or serial number
    public List<ClientEntity> getDevicesBy(String clientLike, String productLike, String serialNumberLike) {
        return repositoryDevice.getDevicesBy(clientLike, productLike, serialNumberLike);
    }
}