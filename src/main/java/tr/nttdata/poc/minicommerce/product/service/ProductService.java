package tr.nttdata.poc.minicommerce.product.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import tr.nttdata.poc.minicommerce.product.model.Product;
import tr.nttdata.poc.minicommerce.product.repository.ProductRepository;

import static tr.nttdata.poc.minicommerce.product.service.UtilService.decompressImage;
import static tr.nttdata.poc.minicommerce.product.service.UtilService.imgToBase64;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
