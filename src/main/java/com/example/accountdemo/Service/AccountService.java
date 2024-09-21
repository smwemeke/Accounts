package com.example.accountdemo.Service;

import com.example.accountdemo.DTO.AccountReportDTO;
import com.example.accountdemo.Domain.Account;
import com.example.accountdemo.DTO.AccountDTO;

import java.util.List;

public interface AccountService {
    void addAccount(AccountDTO accountDTO);
    List<AccountDTO> getAccounts(int userId);
    void deposit(double amount, int accountNumber);
    AccountReportDTO getReport(int userId);
}
