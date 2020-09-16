package ee.valiit.project.Repository;

import ee.valiit.project.Entity.DeviceEntity;
import ee.valiit.project.Entity.RowMapperDevice;
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

    //get all device data by serial number
    public List<DeviceEntity> getAllDeviceInfoBySn(String sn) {
        String sql = "SELECT * FROM devices WHERE sn = :sn";
        Map paramMap = new HashMap();
        paramMap.put("sn", sn);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }


    public List<DeviceEntity> getDeviceDataByProdId(int productId) {
        String sql = "SELECT * FROM devices WHERE product_id = :prodId";
        Map paramMap = new HashMap();
        paramMap.put("prodId", productId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    public List<DeviceEntity> getDeviceDataByCounter(int counter) {
        String sql = "SELECT * FROM devices WHERE counter = :counter";
        Map paramMap = new HashMap();
        paramMap.put("counter", counter);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }



    //TODO
    //get all devices by counter < or > than input figure

}
