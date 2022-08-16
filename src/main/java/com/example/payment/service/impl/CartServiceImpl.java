package com.example.payment.service.impl;

import com.example.payment.dto.cart.AddToCartDto;
import com.example.payment.dto.cart.CartDto;
import com.example.payment.dto.cart.CartItemDto;
import com.example.payment.entity.Cart;
import com.example.payment.entity.Product;
import com.example.payment.entity.User;
import com.example.payment.repository.CartRepository;
import com.example.payment.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public void addToCart(AddToCartDto addToCartDto, Product product, User user) {
        Cart cart = new Cart(product, addToCartDto.getQuantity(),  user);
        cartRepository.save(cart);
    }

    @Override
    public CartDto listCartItems(User user) {
        // First get all the cart items for user
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedAtDesc(user);

        // Convert cart to cartItemDto
        List<CartItemDto> cartItems = new ArrayList<>();
        for(Cart cart:cartList){
            CartItemDto cartItemDto = new CartItemDto(cart);
            cartItems.add(cartItemDto);
        }

        // calculate the total price
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems) {
            totalCost += cartItemDto.getProduct().getPrice() * cartItemDto.getQuantity();
        }

        // return cart DTO
        return new CartDto(cartItems, totalCost);
    }

    @Override
    public void deleteUserCartItems(User user) {
        cartRepository.deleteByUser(user);
    }
}
