package tr.nttdata.poc.minicommerce.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import tr.nttdata.poc.minicommerce.product.model.Product;
import tr.nttdata.poc.minicommerce.product.repository.ProductRepository;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableScheduling
public class ProductServiceApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.deleteAll();


		productRepository.save(
				new Product("Apple", "Best apple in the world", 12.5,
						"https://storage.googleapis.com/ntt-mini-commerce/product-pic/Apple.jpg"));
		productRepository.save(
				new Product("Orange", "Best orange in the world", 13.5,
						"https://storage.googleapis.com/ntt-mini-commerce/product-pic/Orange.jpg"));
		productRepository.save(
				new Product("Banana", "Best banana in the world", 14.5,
						"https://storage.googleapis.com/ntt-mini-commerce/product-pic/Banana.jpg"));

	}
}
