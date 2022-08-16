package com.example.payment.repository;

import com.example.payment.entity.Cart;
import com.example.payment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByUserOrderByCreatedAtDesc(User user);

    void deleteByUser(User user);
}