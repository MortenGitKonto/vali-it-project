package ee.valiit.project.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperClient implements RowMapper<ClientEntity> {
    @Override
    public ClientEntity mapRow(ResultSet resultset, int i) throws SQLException {
        ClientEntity client = new ClientEntity();
        client.setName(resultset.getString("client_name"));
        client.setId(resultset.getInt("id"));
        return client;
    }
}
