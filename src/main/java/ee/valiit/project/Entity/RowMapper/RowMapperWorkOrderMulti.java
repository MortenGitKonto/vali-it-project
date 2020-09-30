package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityWOMulti;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWorkOrderMulti implements RowMapper<EntityWOMulti> {
    @Override
    public EntityWOMulti mapRow(ResultSet resultset, int i) throws SQLException {
        EntityWOMulti workOrderMulti = new EntityWOMulti();

        workOrderMulti.setProductName(resultset.getString("product_name"));
        workOrderMulti.setTechnicianName(resultset.getString("technician_name"));
        workOrderMulti.setJobDescription(resultset.getString("job_description"));
        workOrderMulti.setStatus(resultset.getBoolean("status"));
        workOrderMulti.setWorkOrderId(resultset.getInt("id"));
        workOrderMulti.setClientName(resultset.getString("client_name"));
//        jaanus added
        workOrderMulti.setDeviceName(resultset.getString("device_name"));
        workOrderMulti.setColor(resultset.getString("color"));

        return workOrderMulti;
    }
}
