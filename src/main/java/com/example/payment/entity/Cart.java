package com.example.payment.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToMany
    @JoinColumn(name = "product_id", nullable = false)
    private List<Product> product;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private List<User> user;

    private int quantity;

    public Cart(){}

    public Cart(Product product, int quantity, User user) {
        this.product = (List<Product>) product;
        this.quantity = quantity;
        this.user = (List<User>) user;
        this.createdAt = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createdAt;
    }

    public void setCreateDate(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Product getProduct() {
        return (Product) product;
    }

    public void setProduct(Product product) {
        this.product = (List<Product>) product;
    }

    public User getUser() {
        return (User) user;
    }

    public void setUser(User user) {
        this.user = (List<User>) user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
