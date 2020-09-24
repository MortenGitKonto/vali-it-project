package ee.valiit.project.Entity.RowMapper;


import ee.valiit.project.Entity.EntityWOConsumable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperWorkOrderConsumable implements RowMapper<EntityWOConsumable> {
    @Override
    public EntityWOConsumable mapRow(ResultSet resultset, int i) throws SQLException {
        EntityWOConsumable workOrderConsumable = new EntityWOConsumable();
        workOrderConsumable.setId(resultset.getInt("id"));
        workOrderConsumable.setWorkOrderId(resultset.getInt("work_order_id"));
        workOrderConsumable.setConsumableId(resultset.getInt("consumable_id"));
        return workOrderConsumable;
    }
}
