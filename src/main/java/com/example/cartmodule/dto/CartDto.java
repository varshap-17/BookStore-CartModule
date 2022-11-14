package com.example.cartmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    public long bookId;
    public long userid;
    public int quantity;
    public int price;
}
