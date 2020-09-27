package ee.valiit.project.Repository;

import ee.valiit.project.Entity.EntityTechnician;
import ee.valiit.project.Entity.RowMapper.RowMapperTechnician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryTechnician {

    @Autowired NamedParameterJdbcTemplate jdbcTemplate;

    public void createTechnician(EntityTechnician request) {
        String sql = "INSERT INTO technicians (technician_name, username, password) VALUES (:technician_name, :username, :password)";
        Map paramMap = new HashMap();
        paramMap.put("username", request.getUsername());
        paramMap.put("technician_name", request.getName());
        paramMap.put("password", request.getPassword());
        jdbcTemplate.update(sql, paramMap);
    }

    //Get EntityTechnician id
    public int getTechnicianId(String name) {
            String sql = "SELECT id FROM technicians WHERE technician_name = :name";
            Map paramMap = new HashMap();
            paramMap.put("name", name);
            return jdbcTemplate.queryForObject(sql, paramMap, int.class);
        }

    public List<EntityTechnician> searchTechnicianNamelike(String queryString) {
            String sql = "SELECT * FROM technicians WHERE technician_name ILIKE :name";
            Map paramMap = new HashMap();
            paramMap.put("name", "%"+queryString+"%");
            System.out.println(jdbcTemplate.query(sql, paramMap, new RowMapperTechnician()));
            return jdbcTemplate.query(sql, paramMap, new RowMapperTechnician());
        }
}

