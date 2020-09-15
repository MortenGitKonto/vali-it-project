package ee.valiit.project.Service;

import ee.valiit.project.Repository.RepositoryDevice;
import ee.valiit.project.Request.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDevice {

    @Autowired
    RepositoryDevice repositoryDevice;

    public void createDevice(Device request) {
        repositoryDevice.createDevice(request);
    }

    public List<Device> getAllDeviceInfo(String sn, Integer clientId) {
        if (sn != null) {
            repositoryDevice.getAllDeviceInfoBySn(sn);
            return repositoryDevice.getAllDeviceInfoBySn(sn);
        } else {
            repositoryDevice.getDeviceData(clientId);
            return repositoryDevice.getDeviceData(clientId);
        }
    }
}
