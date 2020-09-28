package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityDevice;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperDevice implements RowMapper<EntityDevice>{
    @Override
    public EntityDevice mapRow(ResultSet resultset, int i) throws SQLException {
        EntityDevice device = new EntityDevice();
        device.setId(resultset.getInt("id"));
        device.setClientId(resultset.getInt("client_id"));
        device.setProductId(resultset.getInt("product_id"));
        device.setSerialNumber(resultset.getString("sn"));
        device.setCounter(resultset.getInt("counter"));
        device.setName(resultset.getString("name"));
        return device;
    }
}
