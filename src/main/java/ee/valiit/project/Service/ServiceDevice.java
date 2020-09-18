package ee.valiit.project.Service;

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
}