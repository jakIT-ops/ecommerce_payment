package com.example.payment.service.impl;

import com.example.payment.entity.User;
import com.example.payment.entity.WishList;
import com.example.payment.repository.WishListRepository;
import com.example.payment.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Override
    public void createWishList(WishList wishList) {
        wishListRepository.save(wishList);
    }

    @Override
    public List<WishList> readWishList(User user) {
        return wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
    }
}
