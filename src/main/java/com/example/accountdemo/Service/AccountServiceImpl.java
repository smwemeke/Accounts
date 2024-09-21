package com.example.accountdemo.Service;

import com.example.accountdemo.DTO.AccountDTO;
import com.example.accountdemo.DTO.AccountReportDTO;
import com.example.accountdemo.Domain.Account;
import com.example.accountdemo.Domain.AccountType;
import com.example.accountdemo.Repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    public void addAccount(AccountDTO accountDTO) {
        Account accts = Account.builder()
                .accountBalance(accountDTO.getAccountBalance())
                .accountNumber(accountDTO.getAccountNumber())
                .userId(accountDTO.getUserId())
                .accountType(accountDTO.getAccountCode())
                .build();

        accountRepository.save(accts);
    }
    @Override
    public List<AccountDTO> getAccounts(int userId) {
       List<Account> list =  accountRepository.findAccountsByUserId(userId);
       List<AccountDTO> listAcct = new ArrayList<>();
      for(Account acct : list){
          AccountDTO accountDTO = AccountDTO.builder()
                  .accountBalance(acct.getAccountBalance())
                  .accountCode(acct.getAccountType())
                  .accountNumber(acct.getAccountNumber())
                  .userId(acct.getUserId())
                  .build();
          listAcct.add(accountDTO);
      }
        return listAcct;
    }
    @Override
    public void deposit(double amount, int accountNumber) {
          Account acc = accountRepository.findAccountByAccountNumber(accountNumber);
          double newBalance = amount + acc.getAccountBalance();
          acc.setAccountBalance(newBalance);
    }
    @Override
    public AccountReportDTO getReport(int userId) {
        List<Account> accountList = accountRepository.findAccountsByUserId(userId);
        List<AccountDTO> accountDTOS = new ArrayList<>();
        double totalBalance =0;
        for(Account acct : accountList){
            AccountDTO accountDTO = AccountDTO.builder()
                    .userId(acct.getUserId())
                    .accountNumber(acct.getAccountNumber())
                    .accountCode(acct.getAccountType())
                    .accountBalance(acct.getAccountBalance())
                    .build();
            accountDTOS.add(accountDTO);
            totalBalance = totalBalance + acct.getAccountBalance();
        }
        AccountReportDTO accountReportDTO = new AccountReportDTO();
        accountReportDTO.setAccounts(accountDTOS);
        accountReportDTO.setTotalBalance(totalBalance);
        return accountReportDTO;
    }
}