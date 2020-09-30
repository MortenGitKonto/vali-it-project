package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityTechnician;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperTechnician implements RowMapper<EntityTechnician> {
    @Override
    public EntityTechnician mapRow(ResultSet resultset, int i) throws SQLException {
        EntityTechnician technician = new EntityTechnician();
        technician.setName(resultset.getString("technician_name"));
        technician.setId(resultset.getInt("id"));
        technician.setColor(resultset.getString("color"));
        return technician;
    }
}
