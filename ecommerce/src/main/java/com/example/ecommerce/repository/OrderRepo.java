package com.example.ecommerce.repository;

import com.example.ecommerce.modal.entity.Account;
import com.example.ecommerce.modal.entity.Order;
import com.example.ecommerce.modal.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    Page<Order> findByAccount(Account accountId, Pageable pageable);

}
