package ee.valiit.project.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperDeviceMulti implements RowMapper<DeviceEntityMulti> {
    @Override
    public DeviceEntityMulti mapRow(ResultSet resultset, int i) throws SQLException {
        DeviceEntityMulti device = new DeviceEntityMulti();
        device.setClientId(resultset.getInt("client_id"));
        device.setProductId(resultset.getInt("product_id"));
        device.setSerialNumber(resultset.getString("sn"));
        device.setCounter(resultset.getInt("counter"));
        device.setClientName(resultset.getString("client_name"));
        device.setProductName(resultset.getString("name"));
        device.setDeviceId(resultset.getInt("id"));
        return device;
    }
}
