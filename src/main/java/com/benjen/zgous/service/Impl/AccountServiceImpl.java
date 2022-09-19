package com.benjen.zgous.service.Impl;

import com.benjen.zgous.domain.Account;
import com.benjen.zgous.repo.AccountRepo;
import com.benjen.zgous.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Account saveUser(Account account) {

        return accountRepo.save(account);
    }

    @Override
    public Account selectAccountByEmail(String email) {
        return accountRepo.findAccountByEmail(email);
    }

    @Override
    public List<Account> getAll() {
        return accountRepo.findAll();
    }

}
