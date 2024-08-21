package edu.icet.crm.product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Product {
    private String name;
    private String description;
    private String price;
}
