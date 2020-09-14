package ee.valiit.project.Service;

import ee.valiit.project.Repository.RepositoryDevice;
import ee.valiit.project.Request.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDevice {

    @Autowired
    RepositoryDevice repositoryDevice;

    public void createDevice(Device request) {
        repositoryDevice.createDevice(request);
    }
}
