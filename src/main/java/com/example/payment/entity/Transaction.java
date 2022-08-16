package com.example.payment.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(targetEntity = User.class, fetch =  FetchType.EAGER)
    @JoinColumn(name = "user_name")
    User user;

    @Column(name = "transaction_value")
    private String transactionValue;
    @Column(name = "debit_amount")
    private double debitAmount;
    @Column(name = "credit_amount")
    private double creditAmount;
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
}