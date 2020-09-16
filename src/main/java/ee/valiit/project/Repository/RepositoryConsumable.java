package ee.valiit.project.Repository;

import ee.valiit.project.Entity.ConsumableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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
}
