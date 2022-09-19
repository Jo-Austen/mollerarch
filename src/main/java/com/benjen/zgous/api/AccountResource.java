package com.benjen.zgous.api;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.benjen.zgous.domain.Account;
import com.benjen.zgous.repo.AccountRepo;
import com.benjen.zgous.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepo accountRepo;

    @PostMapping("/account/save")
    public ResponseEntity<Account> saveUser(@RequestBody Account account) {
        System.out.println("save start...");
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/account/save").toUriString());
        return ResponseEntity.created(uri).body(accountService.saveUser(account));
    }

    @GetMapping("/account/getAll")
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity.ok().body(accountService.getAll());
    }

    @DeleteMapping("/account/{accountId}/delete")
    public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable(value = "accountId") Long accountId) {
        accountRepo.deleteById(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
