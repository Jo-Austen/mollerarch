package com.benjen.zgous.service;

import com.benjen.zgous.domain.Account;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface AccountService {
    Account saveUser(Account account);
    Account selectAccountByEmail(String email);

    List<Account> getAll();
}
