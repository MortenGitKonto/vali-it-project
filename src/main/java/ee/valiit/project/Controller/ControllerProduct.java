package ee.valiit.project.Controller;

import ee.valiit.project.Entity.ProductEntity;
import ee.valiit.project.Service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

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
}
