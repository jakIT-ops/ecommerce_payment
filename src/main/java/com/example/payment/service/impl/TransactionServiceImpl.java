package com.example.payment.service.impl;

import com.example.payment.dto.transaction.TransactionRequest;
import com.example.payment.dto.transaction.TransactionResponse;
import com.example.payment.entity.Transaction;
import com.example.payment.entity.User;
import com.example.payment.exception.ResourceNotFoundException;
import com.example.payment.repository.TransactionRepository;
import com.example.payment.repository.UserRepository;
import com.example.payment.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Override
    public TransactionResponse DebitAmount(TransactionRequest transactionDetails) {

        User user = userRepository.findByUserName(transactionDetails.getAccountName());
                //.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + transactionDetails.getUserName()));;

        Transaction transaction = Transaction.builder()
                .user(user)
                .transactionValue(transactionDetails.getTransactionValue())
                .debitAmount(transactionDetails.getAmount())
                .createdAt(new Date())
                .build();

        transactionRepository.save(transaction);
        TransactionResponse result = new TransactionResponse(
            transactionDetails.getAccountName(),
                transactionDetails.getAmount(),
                new Date()
        );

        return result;
    }

    @Override
    public TransactionResponse CreditAmount(TransactionRequest transactionDetails) {
        User user = userRepository.findByUserName(transactionDetails.getAccountName());
        //.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + transactionDetails.getUserName()));;

        Transaction transaction = Transaction.builder()
                .user(user)
                .transactionValue(transactionDetails.getTransactionValue())
                .creditAmount(transactionDetails.getAmount())
                .createdAt(new Date())
                .build();

        transactionRepository.save(transaction);
        TransactionResponse result = new TransactionResponse(
                transactionDetails.getAccountName(),
                transactionDetails.getAmount(),
                new Date()
        );

        return result;
    }

    @Override
    public double GetBalance(String accountName) throws ResourceNotFoundException {
        double creditAmount, debitAmount, balance;

        User account = userRepository.findByUserName(accountName);
        //.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + accountId));
        creditAmount = transactionRepository.sumOfCreditAmount(accountName);
        debitAmount = transactionRepository.sumOfDebitAmount(accountName);
        balance = creditAmount - debitAmount;
        return balance;
    }
}
