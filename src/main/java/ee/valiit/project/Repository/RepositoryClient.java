package ee.valiit.project.Repository;

import ee.valiit.project.Entity.ClientEntity;
import ee.valiit.project.Entity.RowMapperClient;
import ee.valiit.project.Entity.RowMapperDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
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
    public List<ClientEntity> getClientViaName(String nameLike) {
        String sql = "SELECT * FROM clients WHERE client_name ILIKE :request";
        Map paramMap = new HashMap();
        paramMap.put("request", "%"+nameLike+"%");
        System.out.println(jdbcTemplate.query(sql, paramMap, new RowMapperClient()));
        return jdbcTemplate.query(sql, paramMap, new RowMapperClient());
    }

    // devices by client name
    public List<ClientEntity> getDevicesByClientName(String nameLike) {
        String sql = "SELECT * FROM clients\n" +
                "    JOIN devices ON clients.id = devices.client_id\n" +
                "    JOIN products ON products.id = devices.product_id\n" +
                "    WHERE client_name ILIKE :request";
        Map paramMap = new HashMap();
        paramMap.put("request", "%"+nameLike+"%");
        return jdbcTemplate.query(sql, paramMap, new RowMapperDevice());
    }
}
