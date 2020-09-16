package ee.valiit.project.Entity;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWO implements RowMapper<WorkOrderEntity> {
    @Override
    public WorkOrderEntity mapRow(ResultSet resultset, int i) throws SQLException {
        WorkOrderEntity workOrder = new WorkOrderEntity();
        workOrder.setDeviceId(resultset.getInt("device_id"));
        workOrder.setJobDescription(resultset.getString("job_description"));
        workOrder.setStatus(resultset.getBoolean("status"));
        workOrder.setTechnicianId(resultset.getInt("technician_id"));
        return workOrder;
    }
}
