package com.example.ecommerce.service.clazz;

import com.example.ecommerce.exception.AppException;
import com.example.ecommerce.modal.dto.AccountRequestDTO;
import com.example.ecommerce.modal.entity.Account;
import com.example.ecommerce.modal.entity.Role;
import com.example.ecommerce.repository.AccountRepo;
import com.example.ecommerce.service.implement.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepo accountRepository;

    @Override
    public Page<Account> getAll(Pageable pageable) {
        return  accountRepository.findAll( pageable);
    }

    @Override
    public Account create(AccountRequestDTO dto) {
        Optional<Account> optionalAccount = accountRepository.findByUsername(dto.getUsername());
        if (optionalAccount.isPresent()){
            throw new AppException(404, "USERNAME_EXISTED");
        }
        Account entity = new Account();
        BeanUtils.copyProperties(dto, entity);
        entity.setRole(Role.CUSTOMER);
        return accountRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        if (accountRepository.findById(id).isPresent()) {
            accountRepository.deleteById(id);
        }else {

            throw new AppException(404, "User not found");
        }
    }
}
