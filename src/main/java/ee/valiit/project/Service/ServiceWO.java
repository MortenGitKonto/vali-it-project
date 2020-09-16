package ee.valiit.project.Service;

import ee.valiit.project.Repository.RepositoryWO;
import ee.valiit.project.Entity.WorkOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceWO {
    @Autowired
    public RepositoryWO repositoryWO;

    public void createWO(WorkOrderEntity createWO) {
        repositoryWO.createWO(createWO);
    }

    //Get a specific work order
    public List<WorkOrderEntity> getWorkOrderInfo(int deviceId) {
        return repositoryWO.getWorkOrderInfo(deviceId);
    }

    //Get the whole list of work orders
    public List<WorkOrderEntity> getWorkOrderInfoAll() {
        return repositoryWO.getWorkOrderInfoAll();
    }





}
