package com.example.payment.controller;

import com.example.payment.common.ApiResponse;
import com.example.payment.dto.cart.AddToCartDto;
import com.example.payment.dto.cart.CartDto;
import com.example.payment.entity.Product;
import com.example.payment.entity.User;
import com.example.payment.exception.AuthenticationFailException;
import com.example.payment.exception.ProductNotExistException;
import com.example.payment.service.AuthenticationService;
import com.example.payment.service.CartService;
import com.example.payment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, /*@RequestParam("token") */String token)
        throws ProductNotExistException, AuthenticationFailException {
        // First authenticate the token
        authenticationService.authenticate(token);

        // get the user
        User user = authenticationService.getUser(token);

        // find the product to add and add item by service
        Product product = productService.getProductById(addToCartDto.getProductId());
        cartService.addToCart(addToCartDto, product, user);

        // return response
        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
        // First authenticate the token
        authenticationService.authenticate(token);

        // get the user
        User user = authenticationService.getUser(token);

        // get items in the cart for the user.
        CartDto cartDto = cartService.listCartItems(user);

        return new ResponseEntity<CartDto>(cartDto, HttpStatus.OK);
    }
}
