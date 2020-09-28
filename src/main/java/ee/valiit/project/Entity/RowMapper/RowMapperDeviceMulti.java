package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityDeviceMulti;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperDeviceMulti implements RowMapper<EntityDeviceMulti> {
    @Override
    public EntityDeviceMulti mapRow(ResultSet resultset, int i) throws SQLException {
        EntityDeviceMulti device = new EntityDeviceMulti();
        device.setClientId(resultset.getInt("client_id"));
        device.setProductId(resultset.getInt("product_id"));
        device.setSerialNumber(resultset.getString("sn"));
        device.setCounter(resultset.getInt("counter"));
        device.setClientName(resultset.getString("client_name"));
        device.setProductName(resultset.getString("name"));
        device.setDeviceId(resultset.getInt("id"));
        device.setName(resultset.getString("name"));
        return device;
    }
}
