package com.example.payment.service;

import com.example.payment.dto.payment.CreatePaymentMethodRequest;

public interface PaymentMethodService {
    void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest);
}
