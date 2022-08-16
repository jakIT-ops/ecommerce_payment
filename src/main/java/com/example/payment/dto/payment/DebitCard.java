package com.example.payment.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitCard {
	private String cardNumber;
	private String last4Digits;
	private int expirationMonth;
	private int expirationYear;
	private int cvv;
}



