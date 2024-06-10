package com.example.ecommerce.service.implement;

import com.example.ecommerce.modal.dto.AccountRequestDTO;
import com.example.ecommerce.modal.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {

    Page<Account> getAll(Pageable pageable);

    Account create(AccountRequestDTO dto);

    void delete(int id);
}
