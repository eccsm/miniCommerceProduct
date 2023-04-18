package tr.nttdata.poc.minicommerce.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tr.nttdata.poc.minicommerce.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}