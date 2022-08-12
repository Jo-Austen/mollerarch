package com.benjen.mollerarch.service.impl;

import com.benjen.mollerarch.bean.Account;
import com.benjen.mollerarch.mapper.AccountMapper;
import com.benjen.mollerarch.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctByid(Long id){
        return accountMapper.getAcct(id);
    }
}
