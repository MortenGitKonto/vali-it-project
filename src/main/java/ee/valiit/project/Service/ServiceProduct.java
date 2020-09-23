package ee.valiit.project.Service;

import ee.valiit.project.Entity.ProductEntity;
import ee.valiit.project.Entity.ProductEntity;
import ee.valiit.project.Entity.Products;
import ee.valiit.project.Repository.ProductRepo;
import ee.valiit.project.Repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct {

    @Autowired
    RepositoryProduct repositoryProduct;

    @Autowired
    ProductRepo productRepo;

    //hibernate create
    public void newProdu(String name, int stock) {
        Products products = new Products();
        products.setName(name);
        products.setStock(stock);
        productRepo.save(products);
    }

//    //hibernate get product id
//    public int getProdu(String name) {
//        productRepo.findOne(s);
//    }


    public void newProduct(ProductEntity newProduct) {
        repositoryProduct.newProduct(newProduct);
    }

    public int productID(String name) {
        return repositoryProduct.productID(name);
    }

    //Get a specific product
    public List<ProductEntity> getProductInfo(Integer id) {
        return repositoryProduct.getProductInfo(id);
    }

    //Get the whole list of products
    public List<ProductEntity> getProductInfoAll() {
        return repositoryProduct.getProductInfoAll();
    }


}
