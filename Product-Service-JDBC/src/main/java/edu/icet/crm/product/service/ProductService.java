package edu.icet.crm.product.service;

import edu.icet.crm.product.model.Product;

public interface ProductService {
    Boolean addProduct(Product product);
    Product searchById(String id);
    Product searchByName(String name);
}
