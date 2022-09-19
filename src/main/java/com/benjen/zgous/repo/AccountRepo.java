package com.benjen.zgous.repo;

import com.benjen.zgous.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    @Query("SELECT s FROM Account s WHERE s.email = ?1")
    Account findAccountByEmail(String email);

//    Account findAccountByName(String firstName);
}
