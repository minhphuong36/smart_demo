package com.example.demo.controller;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/showing")
    public List<ProductDTO> showAllProduct() {
        return productService.getAllProduct();
    }


    @GetMapping("/search")
    public Product searchProduct(@RequestParam String name){
        return  productService.getProductByName(name);
    }
}
