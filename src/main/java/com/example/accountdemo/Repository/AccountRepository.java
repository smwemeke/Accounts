package com.example.accountdemo.Repository;

import com.example.accountdemo.Domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository <Account , Integer>{

   List<Account> findAccountsByUserId(int userId);
   Account findAccountByAccountNumber(int accountNumber);
}