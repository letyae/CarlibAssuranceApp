package Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
