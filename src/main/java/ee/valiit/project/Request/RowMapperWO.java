package ee.valiit.project.Request;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWO implements RowMapper<RequestWorkOrder> {
    @Override
    public RequestWorkOrder mapRow(ResultSet resultset, int i) throws SQLException {
        RequestWorkOrder workOrder = new RequestWorkOrder();
        workOrder.setDeviceId(resultset.getInt("device_id"));
        workOrder.setJobDescription(resultset.getString("job_description"));
        workOrder.setStatus(resultset.getBoolean("status"));
        workOrder.setTechnicianId(resultset.getInt("technician_id"));
        return workOrder;
    }
}
