package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityWO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWO implements RowMapper<EntityWO> {
    @Override
    public EntityWO mapRow(ResultSet resultset, int i) throws SQLException {
        EntityWO workOrder = new EntityWO();
        workOrder.setDeviceId(resultset.getInt("device_id"));
        workOrder.setJobDescription(resultset.getString("job_description"));
        workOrder.setStatus(resultset.getBoolean("status"));
        workOrder.setTechnicianId(resultset.getInt("technician_id"));
        workOrder.setProductId(resultset.getInt("product_id"));
        workOrder.setConsumableId(resultset.getInt("consumable_id"));
        workOrder.setId(resultset.getInt("id"));
        return workOrder;
    }
}
