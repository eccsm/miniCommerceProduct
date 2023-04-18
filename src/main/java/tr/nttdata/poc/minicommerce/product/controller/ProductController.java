package tr.nttdata.poc.minicommerce.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.nttdata.poc.minicommerce.product.model.Product;
import tr.nttdata.poc.minicommerce.product.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    @Cacheable(value = "productsCache")
    public List<Product> getAllProducts() {
        System.out.println("getting from mongo");
        return productService.getAllProducts();
    }
}
