package tr.nttdata.poc.minicommerce.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.nttdata.poc.minicommerce.product.model.Product;
import tr.nttdata.poc.minicommerce.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
