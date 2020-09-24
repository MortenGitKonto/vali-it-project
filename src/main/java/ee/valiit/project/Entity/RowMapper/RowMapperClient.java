package ee.valiit.project.Entity.RowMapper;

import ee.valiit.project.Entity.EntityClient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperClient implements RowMapper<EntityClient> {
    @Override
    public EntityClient mapRow(ResultSet resultset, int i) throws SQLException {
        EntityClient client = new EntityClient();
        client.setName(resultset.getString("client_name"));
        client.setId(resultset.getInt("id"));
        return client;
    }
}
