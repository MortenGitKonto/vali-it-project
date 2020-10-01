package ee.valiit.project.Repository;

import ee.valiit.project.Entity.EntityClient;
import ee.valiit.project.Entity.RowMapper.RowMapperClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryClient {

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;


    public void createClient(String request) {
        String sql = "INSERT INTO clients (client_name) VALUES (:name)";
        Map paramMap = new HashMap();
        paramMap.put("name", request);
        jdbcTemplate.update(sql, paramMap);
    }

    //Get client id
    public int getClientId(String name) {
        String sql = "SELECT id FROM clients WHERE client_name = :name";
        Map paramMap = new HashMap();
        paramMap.put("name", name);
        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
    }

    // clients by partial match
    public List<EntityClient> getClientViaName(String queryString) {
        String sql = "SELECT * FROM clients WHERE client_name ILIKE :request";
        Map paramMap = new HashMap();
        paramMap.put("request", "%"+queryString+"%");
        System.out.println(jdbcTemplate.query(sql, paramMap, new RowMapperClient()));
        return jdbcTemplate.query(sql, paramMap, new RowMapperClient());
    }


}
