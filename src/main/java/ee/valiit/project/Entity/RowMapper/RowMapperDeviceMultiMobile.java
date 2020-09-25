package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityDeviceMulti;
import ee.valiit.project.Entity.EntityDeviceMultiMobile;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperDeviceMultiMobile implements RowMapper<EntityDeviceMultiMobile> {
    @Override
    public EntityDeviceMultiMobile mapRow(ResultSet resultset, int i) throws SQLException {
        EntityDeviceMultiMobile device = new EntityDeviceMultiMobile();
        device.setClientId(resultset.getInt("client_id"));
        device.setProductId(resultset.getInt("product_id"));
        device.setSerialNumber(resultset.getString("sn"));
        device.setCounter(resultset.getInt("counter"));
        device.setProductName(resultset.getString("name"));
        device.setDeviceId(resultset.getInt("id"));

        device.setDeviceName(resultset.getString("name") + " - " + resultset.getString("sn"));
        return device;
    }
}
