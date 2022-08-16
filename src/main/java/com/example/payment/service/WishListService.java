package com.example.payment.service;

import com.example.payment.entity.User;
import com.example.payment.entity.WishList;

import java.util.List;

public interface WishListService {
    void createWishList(WishList wishList);
    List<WishList> readWishList(User user);
}
