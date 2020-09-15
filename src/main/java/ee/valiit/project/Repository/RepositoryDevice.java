package ee.valiit.project.Repository;

import ee.valiit.project.Request.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryDevice {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void createDevice(Device request) {
        String sql = "INSERT INTO devices (client_id, device_name, s/n, counter) VALUES (:client_id, :device_name, :s/n, :counter)";
        Map paramMap = new HashMap();
        paramMap.put("client_id", request.getClientId());
        paramMap.put("device_name", request.getDeviceName());
        paramMap.put("s/n", request.getSerialNumber());
        paramMap.put("counter", request.getCounter());
        jdbcTemplate.update(sql, paramMap);
    }
}