package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityWOMulti;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWorkOrderMulti implements RowMapper<EntityWOMulti> {
    @Override
    public EntityWOMulti mapRow(ResultSet resultset, int i) throws SQLException {
        EntityWOMulti workOrderMulti = new EntityWOMulti();

        workOrderMulti.setProductId(resultset.getInt("product_id"));
        workOrderMulti.setProductName(resultset.getString("name"));
        workOrderMulti.setSerialNumber(resultset.getString("sn"));
        workOrderMulti.setTechnicianId(resultset.getInt("technician_id"));
        workOrderMulti.setTechnicianName(resultset.getString("technician_name"));
        workOrderMulti.setJobDescription(resultset.getString("job_description"));
        workOrderMulti.setStatus(resultset.getBoolean("status"));
        workOrderMulti.setWorkOrderId(resultset.getInt("id"));
        workOrderMulti.setConsumableId(resultset.getInt("consumable_id"));
        workOrderMulti.setDeviceId(resultset.getInt("device_id"));
        workOrderMulti.setClientName(resultset.getString("client_name"));
//        jaanus added
        workOrderMulti.setDeviceName(resultset.getString("name"));

        return workOrderMulti;
    }
}
