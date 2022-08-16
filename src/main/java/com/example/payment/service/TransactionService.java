package com.example.payment.service;

import com.example.payment.dto.transaction.TransactionRequest;
import com.example.payment.dto.transaction.TransactionResponse;
import com.example.payment.entity.Transaction;
import com.example.payment.exception.ResourceNotFoundException;

public interface TransactionService {
    TransactionResponse DebitAmount(TransactionRequest transactionDetails);
    TransactionResponse CreditAmount(TransactionRequest transactionDetails);
    double GetBalance(String accountName) throws ResourceNotFoundException;
}
