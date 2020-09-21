package ee.valiit.project.Entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWorkOrderConsumable implements RowMapper<WorkOrderConsumableEntity> {
    @Override
    public WorkOrderConsumableEntity mapRow(ResultSet resultset, int i) throws SQLException {
        WorkOrderConsumableEntity workOrderConsumable = new WorkOrderConsumableEntity();
        workOrderConsumable.setId(resultset.getInt("id"));
        workOrderConsumable.setWorkOrderId(resultset.getInt("work_order_id"));
        workOrderConsumable.setConsumableId(resultset.getInt("consumable_id"));
        return workOrderConsumable;
    }
}
