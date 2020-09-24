package ee.valiit.project.Entity.RowMapper;


import ee.valiit.project.Entity.EntityConsumable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperConsumable implements RowMapper<EntityConsumable> {
    @Override
    public EntityConsumable mapRow(ResultSet resultset, int i) throws SQLException {
        EntityConsumable consumable = new EntityConsumable();
        consumable.setName(resultset.getString("name"));
        consumable.setStock(resultset.getInt("stock"));
        return consumable;
    }
}
