package com.example.cartmodule.model;

import com.example.cartmodule.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;
    private long userid;
    private long bookId;
    private Integer quantity;
    private Integer price;

    public CartData(CartDto cartDto){
        this.bookId= cartDto.bookId;
        this.quantity=cartDto.quantity;
        this.userid=cartDto.userid;
        this.price=cartDto.price;
    }

    public CartData(long userid, Long bookId, int quantity, int price) {
        this.userid=userid;
        this.bookId=bookId;
        this.quantity=quantity;
        this.price=price;
    }
}
