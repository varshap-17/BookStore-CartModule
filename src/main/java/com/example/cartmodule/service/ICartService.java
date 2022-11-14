package com.example.cartmodule.service;

import com.example.cartmodule.dto.CartDto;
import com.example.cartmodule.model.CartData;

import java.util.List;

public interface ICartService {
    public CartData addToCart(CartDto cartDto);
    public CartData editCart(Long cartId,CartDto cartDto);
    public List<CartData> getCarts();
    public CartData findById(Long cartId);
    public CartData delete(Long cartId);
}
