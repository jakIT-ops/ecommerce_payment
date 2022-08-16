package com.example.payment.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectDebit {
	private String iban;
	private String accountNumber;
	private String branchCode;
	private String currency;
}




