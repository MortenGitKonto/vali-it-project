package ee.valiit.project.Entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperProduct implements RowMapper<ProductEntity> {
    @Override
    public ProductEntity mapRow(ResultSet resultset, int i) throws SQLException {
        ProductEntity product = new ProductEntity();
        product.setName(resultset.getString("name"));
        product.setStock(resultset.getInt("stock"));
        return product;
    }
}
