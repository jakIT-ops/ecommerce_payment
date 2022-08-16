package com.example.payment.service;

import com.example.payment.dto.cart.AddToCartDto;
import com.example.payment.dto.cart.CartDto;
import com.example.payment.entity.Product;
import com.example.payment.entity.User;
import com.example.payment.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CartService {
    void addToCart(AddToCartDto addToCartDto, Product product, User user);
    CartDto listCartItems(User user);
    void deleteUserCartItems(User user);
}
