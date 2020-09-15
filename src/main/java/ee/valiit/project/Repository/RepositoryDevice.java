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
        String sql = "INSERT INTO devices (client_id, device_name, sn, counter) VALUES (:client_id, :device_name, :sn, :counter)";
        Map paramMap = new HashMap();
        paramMap.put("client_id", request.getClientId());
        paramMap.put("device_name", request.getDeviceName());
        paramMap.put("sn", request.getSerialNumber());
        paramMap.put("counter", request.getCounter());
        jdbcTemplate.update(sql, paramMap);
    }

    //get all device data by client_id
    public Device getDeviceData(int clientId) {
        String sql = "SELECT * FROM devices WHERE client_id = :client_id";
        Map paramMap = new HashMap();
        paramMap.put("client_id", clientId);
        return jdbcTemplate.queryForObject(sql, paramMap, Device.class);
    }
}
