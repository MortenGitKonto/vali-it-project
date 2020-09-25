package ee.valiit.project.Repository;

import ee.valiit.project.Entity.*;
import ee.valiit.project.Entity.RowMapper.RowMapperWO;
import ee.valiit.project.Entity.RowMapper.RowMapperWorkOrderMulti;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@CrossOrigin(origins = "http://localhost:8081")
public class RepositoryWO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //Create a new work order
    public void createWO(EntityWO createWO, int technicianId, int consumableId, int productId) {
        String sql = "INSERT INTO work_orders (device_id, job_description, technician_id, status, consumable_id, product_id)" +
                "VALUES (:device_id, :job_description, :technician_id, :status, :consumable_id, :product_id)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("device_id", createWO.getDeviceId());
        paramMap.put("job_description", createWO.getJobDescription());
        paramMap.put("technician_id", technicianId);
        paramMap.put("status", createWO.isStatus());
        paramMap.put("consumable_id", consumableId);
        paramMap.put("product_id", productId);
        jdbcTemplate.update(sql, paramMap);
    }

    //Get a specific work order
    public List<EntityWO> getWorkOrderInfo(int deviceId) {
        String sql = "select * from work_orders where device_id=:deviceId";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("deviceId", deviceId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //Get the whole list of work orders
    public List<EntityWO> getWorkOrderInfoAll() {
        String sql = "select * from work_orders order by id";
        Map<String, Object> paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }


    //All work orders info by device id
    public List<EntityWO> getAllWorkOrderInfoByDeviceId(Integer deviceId) {
        String sql = "SELECT * FROM work_orders WHERE device_id = :device_id";
        Map paramMap = new HashMap();
        paramMap.put("device_id", deviceId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //All work orders info by technician id
    public List<EntityWO> getAllWorkOrderInfoByTechnicianId(Integer technicianId) {
        String sql = "SELECT * FROM work_orders WHERE technician_id = :technician_id";
        Map paramMap = new HashMap();
        paramMap.put("technician_id", technicianId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //All work orders info by consumable id
    public List<EntityWO> getAllWorkOrderInfoByConsumableId(Integer consumableId) {
        String sql = "SELECT * FROM work_orders WHERE consumable_id = :consumable_id";
        Map paramMap = new HashMap();
        paramMap.put("consumable_id", consumableId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //All work orders info by QUERY
    public List<EntityWO> getAllInfoByQuery(String queryString) {
        String sql = "SELECT * FROM work_orders WHERE device_id = :queryInteger " +
                "OR technician_id = :queryInteger OR " +
                " product_id = :queryInteger OR consumable_id = :queryInteger";

        Map paramMap = new HashMap();
        //paramMap.put("queryString", queryString);

        Integer queryInteger = null;
        if (StringUtils.isNumeric(queryString)) {
            queryInteger = Integer.valueOf(queryString);
        }

        paramMap.put("queryInteger", queryInteger);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //All work orders info by TRUE/FALSE
    public List<EntityWO> getAllInfoByQueryBoolean(String queryString) {
        String sql = "SELECT * FROM work_orders WHERE status = :status";
        Map paramMap = new HashMap();
        paramMap.put("status", Boolean.valueOf(queryString));
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //get all work orders that are not done
    public List<EntityWO> getAllInfoByStatus(Boolean status) {
        String sql = "SELECT * FROM work_orders WHERE status = :status";
        Map paramMap = new HashMap();
        paramMap.put("status", status);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }


    //All work orders info by product id
    public List<EntityWO> getAllWorkOrderInfoByProductId(Integer productId) {
        String sql = "SELECT * FROM work_orders WHERE product_id = :product_id";
        Map paramMap = new HashMap();
        paramMap.put("product_id", productId);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //work order info by WO id
    public List<EntityWO> getWorkOrderInfoById(int id) {
        String sql = "SELECT * FROM work_orders WHERE id = :id";
        Map paramMap = new HashMap();
        paramMap.put("id", id);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }

    //All work orders info by status
    public List<EntityWO> getAllWorkOrderInfoByStatus(boolean status) {
        String sql = "SELECT * FROM work_orders WHERE status = :status";
        Map paramMap = new HashMap();
        paramMap.put("status", status);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWO());
    }


    /////
//    //Update all info of one specific work order by
//    public void updateAllInfo(EntityWO workOrderEntity) {
//        String sql = "update work_orders set technician_id = :technicianId, device_id = :deviceId, product_id = :productId, consumable_id = :consumableId, status = :status where id= :id";
//        Map<String, Object> paramMap = new HashMap();
//        paramMap.put("technicianId", workOrderEntity.getTechnicianId());
//        paramMap.put("deviceId", workOrderEntity.getDeviceId());
//        paramMap.put("productId", workOrderEntity.getProductId());
//        paramMap.put("consumableId", workOrderEntity.getConsumableId());
//        paramMap.put("status", workOrderEntity.isStatus());
//        paramMap.put("id", workOrderEntity.ge);
//        template.update(sql, paramMap);
//    }

    ///
    //Update status of one specific work order by id
    public void updateStatus(EntityWO entityWO, Integer id) {
        String sql = "update work_orders set status = :status where id= :id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("status", entityWO.isStatus());
        paramMap.put("id", id);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<EntityWOMulti> getWorkOrdersBySimultaneousSearch(String client, String device, String product, String technician) {
        String sql = "SELECT * FROM work_orders " +
                "JOIN technicians ON technicians.id = work_orders.technician_id " +
                "JOIN devices ON devices.id = work_orders.device_id " +
                "JOIN products ON products.id = work_orders.product_id " +
                "JOIN clients ON clients.id = devices.client_id " +
                "WHERE devices.sn ILIKE :serialNumber " +
                "and products.name ILIKE :productName " +
                "and clients.client_name ILIKE :clientName " +
                "and technicians.technician_name ILIKE :technicianName";
        //"AND work_orders.status = :status";
        Map paramMap = new HashMap();

        paramMap.put("serialNumber", "%" + device + "%");
        paramMap.put("productName", "%" + product + "%");
        //paramMap.put("status", "status");
        paramMap.put("technicianName", "%" + technician + "%");
        paramMap.put("clientName", "%" + client + "%");

        return jdbcTemplate.query(sql, paramMap, new RowMapperWorkOrderMulti());
    }

        //Get the whole list of work orders
        public List<EntityWOMulti> getWorkOrderInfoAllMulti() {
            String sql = "SELECT * FROM work_orders " +
                    "JOIN technicians ON technicians.id = work_orders.technician_id " +
                    "JOIN devices ON devices.id = work_orders.device_id " +
                    "JOIN products ON products.id = work_orders.product_id " +
                    "JOIN clients ON clients.id = devices.client_id ";

            //"AND work_orders.status = :status";
            Map paramMap = new HashMap();

            return jdbcTemplate.query(sql, paramMap, new RowMapperWorkOrderMulti());
        }


    public List<EntityWOMulti> getWorkOrdersBySimultaneousSearchWithStatus(String client, String device, String product, String technician, Boolean status) {
        String sql = "SELECT * FROM work_orders " +
                "JOIN technicians ON technicians.id = work_orders.technician_id " +
                "JOIN devices ON devices.id = work_orders.device_id " +
                "JOIN products ON products.id = work_orders.product_id " +
                "JOIN clients ON clients.id = devices.client_id " +
                "WHERE devices.sn ILIKE :serialNumber " +
                "and products.name ILIKE :productName " +
                "and clients.client_name ILIKE :clientName " +
                "and technicians.technician_name ILIKE :technicianName " +
                "and work_orders.status = :status";

        Map paramMap = new HashMap();

        paramMap.put("status", status);
        paramMap.put("serialNumber", "%"+device+"%");
        paramMap.put("productName", "%"+product+"%");
        paramMap.put("technicianName", "%"+technician+"%");
        paramMap.put("clientName", "%"+client+"%");

        return jdbcTemplate.query(sql, paramMap, new RowMapperWorkOrderMulti());
    }

    public int getLastWorkOrderId() {
        String sql = "SELECT MAX(id) FROM work_orders";
        Map paramMap = new HashMap();
        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
    }


}
