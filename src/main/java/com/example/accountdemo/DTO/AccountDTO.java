package com.example.accountdemo.DTO;

import com.example.accountdemo.Domain.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
    private int userId;
    @Column(length = 6)
    private int accountNumber;
    private double accountBalance;
    private String accountCode;
}
