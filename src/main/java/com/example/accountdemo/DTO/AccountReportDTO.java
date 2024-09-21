package com.example.accountdemo.DTO;

import com.example.accountdemo.Domain.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountReportDTO {
    private List<AccountDTO> accounts;
    private double totalBalance;

}