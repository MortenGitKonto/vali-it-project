package ee.valiit.project.Repository;

import ee.valiit.project.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RepositoryClient {

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;

    public void createClient(String request) {
        String sql = "INSERT INTO clients (client_name) VALUE (:name)";
        Map paramMap = new HashMap();
        paramMap.put("name", request);
        jdbcTemplate.update(sql, paramMap);
    }
}
