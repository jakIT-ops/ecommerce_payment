package com.example.payment.dto.transaction;

import com.example.payment.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private String accountName;
    private String transactionValue;
    private double amount;
}
