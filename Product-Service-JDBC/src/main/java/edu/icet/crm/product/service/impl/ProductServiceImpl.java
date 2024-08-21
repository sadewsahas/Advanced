package edu.icet.crm.product.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.product.entity.ProductEntity;
import edu.icet.crm.product.model.Product;
import edu.icet.crm.product.repository.ProductRepository;
import edu.icet.crm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void saveProduct(Product product) {
        ProductEntity entity = mapper.convertValue(product, ProductEntity.class);
        repository.save(entity);
    }
}
