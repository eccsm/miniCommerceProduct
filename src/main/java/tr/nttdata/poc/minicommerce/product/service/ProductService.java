package tr.nttdata.poc.minicommerce.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.nttdata.poc.minicommerce.product.model.Product;
import tr.nttdata.poc.minicommerce.product.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(String id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null)
            return null;
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Product createProduct(Product product) {
        Product createdProduct = productRepository.save(product);
        return createdProduct;
    }

    public Product updateProduct(String id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null)
            return null;

        if (product.getName() != null && !existingProduct.getName().equals(product.getName()))
            existingProduct.setName(product.getName());
        if (product.getDescription() != null && !existingProduct.getDescription().equals(product.getDescription()))
            existingProduct.setDescription(product.getDescription());
        if (product.getPrice() != 0.0 && existingProduct.getPrice() != product.getPrice())
            existingProduct.setPrice(product.getPrice());
        if (product.getImageuri() != null && !existingProduct.getImageuri().equals(product.getImageuri()))
            existingProduct.setImageuri(product.getImageuri());

        Product updatedProduct = productRepository.save(existingProduct);
        return updatedProduct;
    }

    public boolean deleteProduct(String id) {
        if (!productRepository.existsById(id)) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

}
