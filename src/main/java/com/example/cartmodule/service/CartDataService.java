package com.example.cartmodule.service;

import com.example.cartmodule.dto.*;
import com.example.cartmodule.model.CartData;
import com.example.cartmodule.repository.CartDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CartDataService{
    @Autowired
    CartDataRepository cartRepository;
    @Autowired
    RestTemplate restTemplate;
    public CartData addToCart(CartDto request){
        //rest call
        User userResponse=restTemplate.getForObject("http://localhost:8087/UserData/getById/"+request.getUserid(),User.class);
        System.out.println(userResponse);
        Book bookResponse=restTemplate.getForObject("http://localhost:8088/BookData/getById/"+request.getBookId(),Book.class);
        System.out.println(bookResponse);
        CartData cartData=new CartData(userResponse.getUserid(),bookResponse.getBookId(),request.quantity,request.price);
       return cartRepository.save(cartData);
    }
    public CartData editCart(Long cartId,CartDto cartDto){
        CartData cartData=cartRepository.findById(cartId).orElse(null);
        if(cartData!=null){
            cartData.setBookId(cartDto.bookId);
            cartData.setPrice(cartDto.price);
            cartData.setUserid(cartDto.userid);
            cartData.setQuantity(cartDto.quantity);
            return cartRepository.save(cartData);
        }else{
            return null;
        }
    }
    public List<CartData> getCarts(){
        return cartRepository.findAll();
    }
    public CartData findById(Long cartId){
        return cartRepository.findById(cartId).orElse(null);
    }
    public Optional<CartData> byId(Long cartId){
        return cartRepository.findById(cartId);
    }
    public CartData delete(Long cartId){
        cartRepository.deleteById(cartId);
        return null;
    }
}
