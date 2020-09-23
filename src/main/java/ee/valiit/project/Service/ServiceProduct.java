package ee.valiit.project.Service;

import ee.valiit.project.Entity.ProductEntity;
import ee.valiit.project.Entity.ProductEntity;
import ee.valiit.project.Entity.Products;
import ee.valiit.project.Repository.ProductRepository;
import ee.valiit.project.Repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct {

    @Autowired
    RepositoryProduct repositoryProduct;

    @Autowired
    ProductRepository productRepository;

    public void newProduct(ProductEntity newProduct) {
        repositoryProduct.newProduct(newProduct);
    }

    //hibernate
    public void newProductHibernate(String name, Integer stock){
        Products products = new Products();
        products.setName(name);
        products.setStock(stock);
        productRepository.save(products);
    }


    public int productID(String name) {
        return repositoryProduct.productID(name);
    }

    //Get a specific product
    public List<ProductEntity> getProductInfo(Integer id) {

        return repositoryProduct.getProductInfo(id);

    }
    //hibernate get
    public Products getProductHibernate(){
        return productRepository.getOne(1);
    }

    //Get the whole list of Products
    public List<ProductEntity> getProductInfoAll() {
        return repositoryProduct.getProductInfoAll();
    }


}
