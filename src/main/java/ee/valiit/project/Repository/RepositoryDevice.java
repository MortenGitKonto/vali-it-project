package ee.valiit.project.Repository;

import ee.valiit.project.Entity.EntityClient;
import ee.valiit.project.Entity.EntityDevice;
import ee.valiit.project.Entity.EntityDeviceMultiMobile;
import ee.valiit.project.Entity.EntityWO;
import ee.valiit.project.Entity.RowMapper.RowMapperDevice;
import ee.valiit.project.Entity.RowMapper.RowMapperDeviceMulti;
import ee.valiit.project.Entity.RowMapper.RowMapperDeviceMultiMobile;
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

    public void createDevice(int clientId, String sn, int counter, int productId, String productName) {
        String sql = "INSERT INTO devices (client_id, product_id, sn, counter, name) VALUES (:client_id, :product_id, :sn, :counter,:name)";
        Map paramMap = new HashMap();
        paramMap.put("client_id", clientId);
        paramMap.put("product_id", productId);
        paramMap.put("sn", sn);
        paramMap.put("counter", counter);
        paramMap.put("name", productName+" - "+sn);
        jdbcTemplate.update(sql, paramMap);
    }

    //get all devices
    public List<EntityDevice> getAllDevices() {
        String sql = "SELECT * FROM devices";
        Map paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    //get all device data by client_id
    public List<EntityDevice> getDeviceData(int clientId) {
        String sql = "SELECT * FROM devices WHERE client_id = :client_id";
        Map paramMap = new HashMap();
        paramMap.put("client_id", clientId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    public List<EntityDevice> query(String queryString) {
        String sql = "SELECT * FROM devices " +
                "JOIN clients ON clients.id = client_id " +
                "WHERE client_name ILIKE :queryString " +
                "OR name ILIKE :queryString";
        Map paramMap = new HashMap();
        paramMap.put("queryString", "%"+queryString+"%");
        return jdbcTemplate.query(sql, paramMap, new RowMapperDeviceMulti());
    }

//
    public List<EntityDevice> searchDeviceNamelike(String queryString) {
        String sql = "SELECT * FROM devices WHERE name ILIKE :queryString";
        Map paramMap = new HashMap();
        paramMap.put("queryString", "%"+queryString+"%");
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

//    public List<EntityDeviceMultiMobile> searchDeviceNamelike(String queryString) {
//        String sql = "SELECT * FROM devices " +
//                "JOIN products ON products.id = product_id " +
//                "WHERE name ILIKE :queryString OR sn ILIKE :queryString";
//        Map paramMap = new HashMap();
//        paramMap.put("queryString", "%"+queryString+"%");
//        return jdbcTemplate.query(sql, paramMap, new RowMapperDeviceMultiMobile());
//    }

    public List<EntityDevice> getAllCounterLess(int counter) {
        String sql = "SELECT * FROM devices WHERE counter <= :counter";
        Map paramMap = new HashMap();
        paramMap.put("counter", counter);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    //Get device id
    public int getDeviceId(String deviceName) {
        String sql = "SELECT id FROM devices WHERE name = :name";
        Map paramMap = new HashMap();
        paramMap.put("name", deviceName);
        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
    }

    public List<EntityDevice> getAllCounterMore(int counter) {
        String sql = "SELECT * FROM devices WHERE counter >= :counter";
        Map paramMap = new HashMap();
        paramMap.put("counter", counter);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    public List<EntityDevice> devicesByClientId(int clientId) {
        String sql = "SELECT * FROM devices WHERE client_id = :clientId";
        Map paramMap = new HashMap();
        paramMap.put("clientId", clientId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }

    // devices by client, product or serialNr
    public List<EntityClient> getDevicesBy(String clientLike, String productLike, String serialNumberLike) {
        String sql = "SELECT * FROM devices " +
                "JOIN clients ON clients.id = devices.client_id " +
                "JOIN products ON products.id = devices.product_id " +
                "WHERE clients.client_name ILIKE :clientLike " +
                "AND products.name ILIKE :productLike " +
                "AND devices.sn ILIKE :serialNumberLike";
        Map paramMap = new HashMap();
        paramMap.put("clientLike", "%"+clientLike+"%");
        paramMap.put("productLike", "%"+productLike+"%");
        paramMap.put("serialNumberLike", "%"+serialNumberLike+"%");
        return jdbcTemplate.query(sql, paramMap, new RowMapperDeviceMulti());
    }

}
