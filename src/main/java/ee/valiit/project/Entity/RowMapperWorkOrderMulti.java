package ee.valiit.project.Entity;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWorkOrderMulti implements RowMapper<WorkOrderMultiEntity> {
    @Override
    public WorkOrderMultiEntity mapRow(ResultSet resultset, int i) throws SQLException {
        WorkOrderMultiEntity workOrderMulti = new WorkOrderMultiEntity();

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

        return workOrderMulti;
    }
}
