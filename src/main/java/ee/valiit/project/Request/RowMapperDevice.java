package ee.valiit.project.Request;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperDevice implements RowMapper<Device> {
    @Override
    public Device mapRow(ResultSet resultset, int i) throws SQLException {
        Device device = new Device();
        device.setClientId(resultset.getInt("client_id"));
        device.setDeviceName(resultset.getString("device_name"));
        device.setSerialNumber(resultset.getString("sn"));
        device.setCounter(resultset.getInt("counter"));
        return device;
    }
}
