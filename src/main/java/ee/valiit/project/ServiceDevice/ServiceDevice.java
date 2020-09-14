package ee.valiit.project.ServiceDevice;

import ee.valiit.project.Repository.RepositoryDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDevice {
    @Autowired
    private RepositoryDevice repositoryDevice;

    public void createDevice(int clientId, String deviceName, String serialNumber, int counter) {
        repositoryDevice.createDevice(clientId, deviceName, serialNumber, counter);
    }
}
