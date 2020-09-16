package ee.valiit.project.Controller;

import ee.valiit.project.Entity.ConsumableEntity;
import ee.valiit.project.Entity.ProductEntity;
import ee.valiit.project.Service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ControllerProduct {

    @Autowired
    ServiceProduct serviceProduct;

    //create new
    @PostMapping("product")
    public void createProduct(@RequestBody ProductEntity newProduct) {
        serviceProduct.newProduct(newProduct);
    }

    //get ID
    @GetMapping("product/{name}")
    public int getProductID(@RequestBody String name) {
        return serviceProduct.productID(name);
    }

    //Get a specific product
    @GetMapping("productInfo/{id}")
    public List<ProductEntity> getProductInfo(@PathVariable("id") Integer id) {
        return serviceProduct.getProductInfo(id);
    }

    //Get the whole list of products
    @GetMapping("productInfo")
    public List<ProductEntity> getProductInfoAll() {
        return serviceProduct.getProductInfoAll();
    }

}
