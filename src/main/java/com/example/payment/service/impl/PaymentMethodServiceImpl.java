package com.example.payment.service.impl;

import com.example.payment.dto.payment.CreatePaymentMethodRequest;
import com.example.payment.dto.payment.PaymentMethodType;
import com.example.payment.entity.CreditCard;
import com.example.payment.repository.CreditCardRepository;
import com.example.payment.service.PaymentMethodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private CreditCardRepository creditCardRepository;

//    @Autowired
//    private AccountFeignClient accountFeignClient;

    @Override
    public void createPaymentMethod(CreatePaymentMethodRequest createPaymentMethodRequest) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userName = (String) authentication =

        if (createPaymentMethodRequest.getPaymentMethodType() == PaymentMethodType.CREDIT_CARD) {
//            CreditCard creditCard = CreditCard.builder()
//                    .userId(createPaymentMethodRequest.getUserId())
        }
    }

}
