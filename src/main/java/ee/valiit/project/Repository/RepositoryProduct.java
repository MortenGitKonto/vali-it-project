package ee.valiit.project.Repository;

import ee.valiit.project.Entity.*;
import ee.valiit.project.Entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryProduct {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


    //create
    public void newProduct(ProductEntity newProduct) {
        String sql = "INSERT INTO products (name, stock) VALUES (:name, :stock)";
        Map paramMap = new HashMap();
        paramMap.put("name", newProduct.getName());
        paramMap.put("stock", newProduct.getStock());
        jdbcTemplate.update(sql, paramMap);
    }

    //get ID
    public int productID(String name) {
        String sql = "SELECT id FROM products WHERE name = :name";
        Map paramMap = new HashMap();
        paramMap.put("name", name);
        return jdbcTemplate.queryForObject(sql, paramMap, int.class);
    }

    //Get a specific product
    public List<ProductEntity> getProductInfo(Integer id) {
        String sql = "select * from products where id=:id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("id", id);
        return jdbcTemplate.query(sql, paramMap, new RowMapperProduct());
    }

    //Get the whole list of consumables
    public List<ProductEntity> getProductInfoAll() {
        String sql = "select * from products order by id";
        Map<String, Object> paramMap = new HashMap();
        return jdbcTemplate.query(sql, paramMap, new RowMapperProduct());
    }

}
