package com.example.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public Product retrieveTheProduct(Long id){
        Product product = productRepository.findById(id).get();
        //let it initialise
        product.getImage().getDefaultImageData().getName();
        return product;
    }

    @Transactional
    public Product save(Product product){
        return productRepository.save(product);
    }
}
