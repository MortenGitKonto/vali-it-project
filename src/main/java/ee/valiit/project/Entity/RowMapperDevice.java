package ee.valiit.project.Entity;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperDevice implements RowMapper<DeviceEntity> {
    @Override
    public DeviceEntity mapRow(ResultSet resultset, int i) throws SQLException {
        DeviceEntity device = new DeviceEntity();
        device.setClientId(resultset.getInt("client_id"));
        device.setProductId(resultset.getInt("product_id"));
        device.setSerialNumber(resultset.getString("sn"));
        device.setCounter(resultset.getInt("counter"));
        return device;
    }
}
