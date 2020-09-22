package ee.valiit.project.Repository;

import ee.valiit.project.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Integer> {

}
