package com.example.accountdemo.Controller;

import com.example.accountdemo.DTO.AccountDTO;
import com.example.accountdemo.DTO.AccountReportDTO;
import com.example.accountdemo.Domain.Account;
import com.example.accountdemo.Service.AccountService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> addAccount(@RequestBody AccountDTO accountDTO){
        accountService.addAccount(accountDTO);
        return new ResponseEntity<>("Account created successfully",HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAccounts(@PathParam ("userId") Integer userId){
        List<AccountDTO> myAccts = accountService.getAccounts(userId);
        return new ResponseEntity<>(myAccts, HttpStatus.ACCEPTED);
    }
    @PutMapping("/{accountNumber}/deposit")
    public ResponseEntity<?> deposit(@RequestBody AccountDTO accountDTO, @PathVariable ("accountNumber") int accountNumber){
        accountService.deposit(accountDTO.getAccountBalance(),accountNumber);
        return new ResponseEntity<>("Amount deposited successfully", HttpStatus.CREATED);
    }
    @GetMapping("/report")
    public ResponseEntity<?>getAccountReport(@PathParam("userId") Integer userId){
        AccountReportDTO accountReportDTO = accountService.getReport(userId);
        return new ResponseEntity<>(accountReportDTO, HttpStatus.ACCEPTED);
    }
}