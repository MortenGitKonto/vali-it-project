package ee.valiit.project.Repository;

import ee.valiit.project.Entity.RowMapperWO;
import ee.valiit.project.Entity.WorkOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryWO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createWO(WorkOrderEntity createWO) {
        String sql = "INSERT INTO work_orders (device_id, job_description, technician_id, status) " +
                "VALUES (:device_id, :job_description, :technician_id, :status)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("device_id", createWO.getDeviceId());
        paramMap.put("job_description", createWO.getJobDescription());
        paramMap.put("technician_id", createWO.getTechnicianId());
        paramMap.put("status", createWO.isStatus());
        jdbcTemplate.update(sql, paramMap);
    }

    //Get a specific work order
    public List<WorkOrderEntity> getWorkOrderInfo(int deviceId) {
        String sql = "select * from work_orders where device_id=:deviceId";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("deviceId", deviceId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //Get the whole list of work orders
    public List<WorkOrderEntity> getWorkOrderInfoAll() {
        String sql = "select * from work_orders order by id";
        Map<String, Object> paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

}
