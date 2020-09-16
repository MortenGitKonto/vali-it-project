package ee.valiit.project.Service;

import ee.valiit.project.Entity.ProductEntity;
import ee.valiit.project.Repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProduct {

    @Autowired
    RepositoryProduct repositoryProduct;


    public void newProduct(ProductEntity newProduct) {
        repositoryProduct.newProduct(newProduct);
    }

    public int productID(String name) {
        return repositoryProduct.productID(name);
    }
}
