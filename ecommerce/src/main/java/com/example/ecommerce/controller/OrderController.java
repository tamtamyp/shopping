package com.example.ecommerce.controller;


import com.example.ecommerce.modal.dto.OrderRequestDto;
import com.example.ecommerce.modal.entity.Account;
import com.example.ecommerce.modal.entity.Order;
import com.example.ecommerce.modal.entity.Product;
import com.example.ecommerce.repository.AccountRepo;
import com.example.ecommerce.repository.OrderRepo;
import com.example.ecommerce.service.implement.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private  IOrderService orderService;

    @Autowired
    private AccountRepo accountRepo;

    @PostMapping("/create")
    public void create(@RequestBody OrderRequestDto dto){
         orderService.create(dto);
    }

    @PostMapping("/buy/{id}")
    public Order buyProduct(@PathVariable int id ){
        return orderService.buyProduct(id);
    }

    @PostMapping("/cancel/{id}")
    public Order cancelProduct(@PathVariable int id){
        return orderService.cancelProduct(id);
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<Page<Order>> history(@PathVariable int userId, Pageable pageable) {
//        Account account =  accountRepo.findById(userId).get();

//        return orderService.history(userId, pageable);
        Account account = new Account();
        account.setId(userId);
        Page<Order> orderList = orderService.history(account, pageable);


        return ResponseEntity.ok(orderList);
//        return orderService.history(account, pageable);



    }

}
