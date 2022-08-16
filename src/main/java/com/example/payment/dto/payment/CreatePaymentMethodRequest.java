package com.example.payment.dto.payment;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentMethodRequest {

	@NotNull
	PaymentMethodType paymentMethodType;
	CreditCard creditCard;
	DebitCard debitCard;
	DirectDebit directDebit;
}

