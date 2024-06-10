package com.example.ecommerce.controller;


import com.example.ecommerce.modal.dto.AccountRequestDTO;
import com.example.ecommerce.modal.entity.Account;
import com.example.ecommerce.service.implement.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/accounts")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private  IAccountService accountService;


    @GetMapping("/getAll")
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountService.getAll( pageable);
    }

    @PostMapping("/create")
    public void createAccount (@RequestBody  AccountRequestDTO accountRequestDTO) {

       accountService.create(accountRequestDTO);

    }
    @DeleteMapping("/delete/{id}")
    public void delete ( @PathVariable(name = "id") int id) {
        accountService.delete(id);
    }




}
