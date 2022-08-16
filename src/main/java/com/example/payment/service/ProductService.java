package com.example.payment.service;

import com.example.payment.dto.product.ProductDto;
import com.example.payment.entity.Category;
import com.example.payment.entity.Product;
import com.example.payment.exception.ProductNotExistException;

import java.util.List;

public interface ProductService {
    List<ProductDto> listProducts();
    Product getProductFromDto(ProductDto productDto, Category category);
    void addProduct(ProductDto productDto, Category category);
    void updateProduct(Integer productID, ProductDto productDto, Category category);
    Product getProductById(Integer productId) throws ProductNotExistException;
}
