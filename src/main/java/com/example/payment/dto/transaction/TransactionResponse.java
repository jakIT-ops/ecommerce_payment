package com.example.payment.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {
    private String accountName;
    private double amount;
    private Date systemDate;
}

