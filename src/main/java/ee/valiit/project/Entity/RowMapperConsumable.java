package ee.valiit.project.Entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperConsumable implements RowMapper<ConsumableEntity> {
    @Override
    public ConsumableEntity mapRow(ResultSet resultset, int i) throws SQLException {
        ConsumableEntity consumable = new ConsumableEntity();
        consumable.setName(resultset.getString("name"));
        consumable.setStock(resultset.getInt("stock"));
        return consumable;
    }
}
