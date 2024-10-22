package edu.icet.crm.product.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.product.entity.ProductEntity;
import edu.icet.crm.product.model.Product;
import edu.icet.crm.product.repository.ProductRepository;
import edu.icet.crm.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    final ProductRepository repository;
    final ModelMapper mapper;


    @Override
    public Boolean addProduct(Product product) {
        repository.save(mapper.map(product, ProductEntity.class));
        return true;

    }

    @Override
    public Product searchById(String id) {
        Optional<ProductEntity> byId = repository.findById(id);
        return mapper.map(byId, Product.class);
    }

    @Override
    public Product searchByName(String name) {
        Optional<ProductEntity> byName = repository.findByName(name);
        return mapper.map(byName, Product.class);
    }
}
