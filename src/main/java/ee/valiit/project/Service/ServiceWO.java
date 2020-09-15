package ee.valiit.project.Service;

import ee.valiit.project.Repository.RepositoryWO;
import ee.valiit.project.Request.RowMapperWO;
import ee.valiit.project.Request.RequestWorkOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceWO {
    @Autowired
    public RepositoryWO repositoryWO;

    public void createWO(RequestWorkOrder createWO) {
        repositoryWO.createWO(createWO);
    }

    //Get a specific work order
    public RequestWorkOrder getWorkOrderInfo(int deviceId) {
        return repositoryWO.getWorkOrderInfo(deviceId);
    }

    //Get the whole list of work orders
    public List<RequestWorkOrder> getWorkOrderInfoAll() {
        return repositoryWO.getWorkOrderInfoAll();
    }




}
