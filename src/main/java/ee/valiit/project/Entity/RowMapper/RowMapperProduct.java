package ee.valiit.project.Entity.RowMapper;


import ee.valiit.project.Entity.EntityProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperProduct implements RowMapper<EntityProduct> {
    @Override
    public EntityProduct mapRow(ResultSet resultset, int i) throws SQLException {
        EntityProduct product = new EntityProduct();
        product.setName(resultset.getString("name"));
        product.setStock(resultset.getInt("stock"));
        return product;
    }
}
