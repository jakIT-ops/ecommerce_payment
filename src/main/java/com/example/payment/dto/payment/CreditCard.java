package com.example.payment.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
	private String firstName;
	private String lastName;
	private String cardNumber;
	private String last4Digits;
	private int expirationMonth;
	private int expirationYear;
	private int cvv;
}

