package tr.nttdata.poc.minicommerce.product.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tr.nttdata.poc.minicommerce.product.model.Product;
import tr.nttdata.poc.minicommerce.product.service.ProductService;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/addProduct", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        return productService.createProduct(product, file);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @Valid @RequestBody Product updatedProduct) {
        Product product = productService.getProductById(id);
        if (product != null) {
            updatedProduct.setId(id);
            Product savedProduct = productService.updateProduct(id, updatedProduct);
            return ResponseEntity.ok(savedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
