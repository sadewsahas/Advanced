package lk.icet.ecom.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;

@Setter
@Getter
@AllArgsConstructor
public class Product {
    private String name;
    private String description;
}
