package tr.nttdata.poc.minicommerce.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.nttdata.poc.minicommerce.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}