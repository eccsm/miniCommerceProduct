package tr.nttdata.poc.minicommerce.product.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Document(collection = "product")
public class Product implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String imageUri;

    public Product(String name, String description, double price, String imageUri) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUri = imageUri;
    }
}
