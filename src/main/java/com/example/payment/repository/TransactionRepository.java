package com.example.payment.repository;

import com.example.payment.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "SELECT SUM(debit_amount) FROM transactions WHERE user_name =:userName", nativeQuery = true)
    double sumOfDebitAmount(@Param("user_name") String userName);

    @Query(value = "SELECT SUM(credit_amount) FROM transactions WHERE user_name =:userName", nativeQuery = true)
    double sumOfCreditAmount(@Param("user_name") String userName);
}
