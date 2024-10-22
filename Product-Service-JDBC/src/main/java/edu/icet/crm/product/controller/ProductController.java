package edu.icet.crm.product.controller;

import edu.icet.crm.product.model.Product;
import edu.icet.crm.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService service;

    @PostMapping("/add-course")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @GetMapping("/search-by-id{id}")
    public Product searchById(@PathVariable Long id){
        return service.searchById(String.valueOf(id));
    }


    @GetMapping("/search-by-name{name}")
    public Product searchByName(@PathVariable String name){
        return service.searchByName(name);
    }


}
