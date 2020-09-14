package ee.valiit.project.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryWO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createWO(int deviceId, String jobDescription, String technicianName) {
        String sql = "INSERT INTO work_orders (device_id, job_description, technician_name) " +
                "VALUES (deviceId, jobDescription, technicianName)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("deviceId", deviceId);
        paramMap.put("jobDescription", jobDescription);
        paramMap.put("technicianName", technicianName);
        jdbcTemplate.update(sql, paramMap);
    }
}
