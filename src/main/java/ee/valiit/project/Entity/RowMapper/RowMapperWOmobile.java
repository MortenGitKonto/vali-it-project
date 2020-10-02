package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityWO;
import ee.valiit.project.Entity.EntityWOmobile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWOmobile implements RowMapper<EntityWOmobile> {
    @Override
    public EntityWOmobile mapRow(ResultSet resultset, int i) throws SQLException {
        EntityWOmobile workOrder = new EntityWOmobile();
        workOrder.setClientName(resultset.getString("client_name"));
        workOrder.setDeviceName(resultset.getString("device_name"));
        workOrder.setJobDescription(resultset.getString("job_description"));
        workOrder.setColor(resultset.getString("color"));
        return workOrder;
    }
}
