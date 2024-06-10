package com.example.ecommerce.service.implement;

import com.example.ecommerce.modal.dto.OrderRequestDto;
import com.example.ecommerce.modal.entity.Account;
import com.example.ecommerce.modal.entity.Order;
import com.example.ecommerce.modal.entity.OrderStatus;
import com.example.ecommerce.modal.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {

    void create(OrderRequestDto dto);

    Order buyProduct(int orderId);

    Order cancelProduct(int orderId);

    List<Order> getAll();

    List<Order> findByStatus(OrderStatus oderStatus, int accountId);

    Page<Order> history(Account account, Pageable pageable) ;
}
