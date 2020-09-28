package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityWO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWO implements RowMapper<EntityWO> {
    @Override
    public EntityWO mapRow(ResultSet resultset, int i) throws SQLException {
        EntityWO workOrder = new EntityWO();
        workOrder.setDeviceName(resultset.getString("name"));
        workOrder.setJobDescription(resultset.getString("job_description"));
        workOrder.setStatus(resultset.getBoolean("status"));
        workOrder.setTechnicianName(resultset.getString("technician_name"));
        workOrder.setProductName(resultset.getString("product_name"));
        workOrder.setConsumableName(resultset.getString("consumable_name"));
        workOrder.setId(resultset.getInt("id"));
        return workOrder;
    }
}
