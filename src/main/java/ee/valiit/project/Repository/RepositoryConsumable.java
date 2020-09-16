package ee.valiit.project.Repository;

import ee.valiit.project.Entity.ConsumableEntity;
import ee.valiit.project.Entity.RowMapperConsumable;
import ee.valiit.project.Entity.RowMapperWO;
import ee.valiit.project.Entity.WorkOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class RepositoryConsumable {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    //create
    public void createConsumable(ConsumableEntity consumable) {
        String sql = "INSERT INTO consumables (name, stock) VALUES (:name, :stock)";
        Map paramMap = new HashMap();
        paramMap.put("name", consumable.getName());
        paramMap.put("stock", consumable.getStock());
        jdbcTemplate.update(sql, paramMap);
    }

    //get ID
    public int getConsumableID(String name) {
        String sql = "SELECT id FROM consumables WHERE name = :name";
        Map paramMap = new HashMap();
        paramMap.put("name", name);
        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
    }

    //Get a specific consumable
    public List<ConsumableEntity> getConsumableInfo(Integer id) {
        String sql = "select * from consumables where id=:id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("id", id);
        return jdbcTemplate.query(sql, paramMap, new RowMapperConsumable());
    }

    //Get the whole list of consumables
    public List<ConsumableEntity> getConsumableInfoAll() {
        String sql = "select * from consumables order by id";
        Map<String, Object> paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new RowMapperConsumable());
    }




}
