package ee.valiit.project.Service;

import ee.valiit.project.Entity.EntityProduct;
import ee.valiit.project.Repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct {

    @Autowired
    RepositoryProduct repositoryProduct;

    public void newProduct(EntityProduct newProduct) {
        repositoryProduct.newProduct(newProduct);
    }

    public int productID(String name) {
        return repositoryProduct.getproductID(name);
    }

    //Get a specific product
    public List<EntityProduct> getProductInfo(Integer id) {

        return repositoryProduct.getProductInfo(id);

    }

    //Get the whole list of Products
    public List<EntityProduct> getProductInfoAll() {
        return repositoryProduct.getProductInfoAll();
    }
}
