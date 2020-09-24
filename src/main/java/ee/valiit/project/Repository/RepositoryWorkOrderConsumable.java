package ee.valiit.project.Repository;

import ee.valiit.project.Entity.*;
import ee.valiit.project.Entity.RowMapper.RowMapperWorkOrderConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class RepositoryWorkOrderConsumable {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    //create
    public void createWorkOrderConsumable (EntityWOConsumable workOrderConsumable) {
        String sql = "INSERT INTO work_order_consumables (work_order_id, consumable_id) VALUES (:workOrderId, :consumableId)";
        Map paramMap = new HashMap();
        paramMap.put("workOrderId", workOrderConsumable.getWorkOrderId());
        paramMap.put("consumableId", workOrderConsumable.getConsumableId());
        jdbcTemplate.update(sql, paramMap);
    }
//
//    //get ID
//    public int getConsumableID(String name) {
//        String sql = "SELECT id FROM consumables WHERE name = :name";
//        Map paramMap = new HashMap();
//        paramMap.put("name", name);
//        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
//    }
//
    //Get a specific consumable
    public List<EntityWOConsumable> getWorkOrderConsumableInfo(int id) {
        String sql = "select * from work_order_consumables where id=:id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("id", id);
        return jdbcTemplate.query(sql, paramMap, new RowMapperWorkOrderConsumable());
    }

//
    //Get the whole list of consumables
    public List<EntityWOConsumable> getWorkOrderConsumableInfoAll() {
        String sql = "select * from work_order_consumables order by id";
        Map<String, Object> paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new RowMapperWorkOrderConsumable());
    }




}
