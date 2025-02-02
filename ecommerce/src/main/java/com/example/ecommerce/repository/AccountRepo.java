package com.example.ecommerce.repository;

import com.example.ecommerce.modal.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {

  Optional<Account> findByUsername(String username);
}
