package ee.valiit.project.Controller;

import ee.valiit.project.Request.RequestWorkOrder;
import ee.valiit.project.Service.ServiceWO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerWO {
    @Autowired
    private ServiceWO serviceWO;

    @PostMapping("createWO")
    public void createWO(@RequestBody RequestWorkOrder request) {
        serviceWO.createWO(request.getDeviceId(),
                request.getJobDescription(),
                request.getTechnicianName());
    }
}
