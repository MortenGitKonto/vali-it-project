package ee.valiit.project.Repository;

import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Entity.RowMapperDevice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryDevice {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public void createDevice(DeviceEntity request) {
        String sql = "INSERT INTO devices (client_id, product_id, sn, counter) VALUES (:client_id, :product_id, :sn, :counter)";
        Map paramMap = new HashMap();
        paramMap.put("client_id", request.getClientId());
        paramMap.put("product_id", request.getProductId());
        paramMap.put("sn", request.getSerialNumber());
        paramMap.put("counter", request.getCounter());
        jdbcTemplate.update(sql, paramMap);
    }

    //get all devices
    public List<DeviceEntity> getAllDevices() {
        String sql = "SELECT * FROM devices";
        Map paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    //get all device data by client_id
    public List<DeviceEntity> getDeviceData(int clientId) {
        String sql = "SELECT * FROM devices WHERE client_id = :client_id";
        Map paramMap = new HashMap();
        paramMap.put("client_id", clientId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    public List<DeviceEntity> query(String queryString) {
        String sql = "SELECT * FROM devices WHERE sn ILIKE :queryString " +
//                "OR client_id = :queryInteger " +
                "OR product_id = :queryInteger ";
//                "OR counter = :queryInteger";
        Map paramMap = new HashMap();
        paramMap.put("queryString", "%"+queryString+"%");
        Integer queryInteger = null;
        if(StringUtils.isNumeric(queryString)){
            queryInteger = Integer.valueOf(queryString);
        }

        paramMap.put("queryInteger", queryInteger);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    public List<DeviceEntity> getAllCounterLess(int counter) {
        String sql = "SELECT * FROM devices WHERE counter <= :counter";
        Map paramMap = new HashMap();
        paramMap.put("counter", counter);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    public List<DeviceEntity> getAllCounterMore(int counter) {
        String sql = "SELECT * FROM devices WHERE counter >= :counter";
        Map paramMap = new HashMap();
        paramMap.put("counter", counter);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }
}
