package com.example.payment.controller;

import com.example.payment.dto.transaction.TransactionRequest;
import com.example.payment.dto.transaction.TransactionResponse;
import com.example.payment.exception.ResourceNotFoundException;
import com.example.payment.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/accounts/{accountName}/credit")
    public Map<String, Object> creditTransfer(@PathVariable(value = "accountName") String accountName, @RequestBody TransactionRequest transactionDetails) {
        transactionDetails.setAccountName(accountName);
        final TransactionResponse transactionInformation = transactionService.CreditAmount(transactionDetails);
        Map<String, Object> response = new HashMap<>();
        response.put("success: ", Boolean.TRUE);
        response.put("Account Name: ", transactionInformation.getAccountName());
        response.put("System Date: ", transactionInformation.getSystemDate());
        response.put("Amount: ", transactionInformation.getAmount());
        return response;
    }

    @PostMapping("/accounts/{accountName}/debit")
    public Map<String, Object> debitTransfer(@PathVariable(value = "accountName") String accountName, @RequestBody TransactionRequest transactionDetails) {
        transactionDetails.setAccountName(accountName);
        final TransactionResponse transactionInformation = transactionService.DebitAmount(transactionDetails);
        Map<String, Object> response = new HashMap<>();
        response.put("success: ", Boolean.TRUE);
        response.put("account id: ", transactionInformation.getAccountName());
        response.put("System Date: ", transactionInformation.getSystemDate());
        response.put("Amount: ", transactionInformation.getAmount());
        return response;
    }

    @GetMapping("/accounts/{accountName}/balance")
    public ResponseEntity<Map> getAccountBalance(@PathVariable(value = "accountName") String accountName) throws ResourceNotFoundException {
        double amount = transactionService.GetBalance(accountName);
        Map<String, Object> response = new HashMap<>();
        response.put("amount:", amount);
        return ResponseEntity.ok().body(response);
    }
}
