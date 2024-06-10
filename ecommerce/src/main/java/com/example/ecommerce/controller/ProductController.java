package com.example.ecommerce.controller;


import com.example.ecommerce.modal.dto.ProducCreatetRequestDto;
import com.example.ecommerce.modal.dto.ProductUpdateRequestDto;
import com.example.ecommerce.modal.dto.search.SearchProduct;
import com.example.ecommerce.modal.entity.Account;
import com.example.ecommerce.modal.entity.Order;
import com.example.ecommerce.modal.entity.Product;
import com.example.ecommerce.repository.OrderRepo;
import com.example.ecommerce.service.implement.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {





    @Autowired
    private  IProductService productService;

    @GetMapping("/getAll")
    public Page<Product> getAll(Pageable pageable){
        return productService.getAll(pageable);
    }

    @PostMapping("/create")
    public Product create(@RequestBody ProducCreatetRequestDto producCreatetRequestDto){
        return productService.create(producCreatetRequestDto);
    }

    @GetMapping("/getById/{id}")
    public Product get_by_id(@PathVariable(name = "id") int id){
        return productService.get_by_id(id);
    }

    @PutMapping("/update")
    public Product update(@RequestBody ProductUpdateRequestDto dto){
        return productService.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id){
        productService.delete(id);
    }

    @GetMapping("/search")
    public Page<Product> search(@RequestBody  SearchProduct searchProduct, Pageable pageable) {

        return productService.search(searchProduct, pageable);

    }
}
