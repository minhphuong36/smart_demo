package com.example.demo.service;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Product> listProduct() {
        return (List<Product>) productRepository.findAll();
    }

    public List<ProductDTO> getAllProduct() {
        List<Product> products = listProduct();

        return products.stream().map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());

    }


    public Product getProductByName(@RequestParam String name) {
        return productRepository.findByName(name);
    }


}
