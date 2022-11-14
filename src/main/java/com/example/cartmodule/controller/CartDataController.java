package com.example.cartmodule.controller;

import com.example.cartmodule.dto.CartDto;
import com.example.cartmodule.dto.ResponseDto;
import com.example.cartmodule.model.CartData;
import com.example.cartmodule.service.CartDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartData")
public class CartDataController {
    @Autowired
    CartDataService cartDataService;
    @PostMapping("/addCart")
    public CartData createCart(@RequestBody CartDto request){
        return cartDataService.addToCart(request);
    }
    @PutMapping("/updateCart/{cartId}")
    public ResponseEntity<ResponseDto> updateCart(@PathVariable long cartId,@RequestBody CartDto cartDto){
        CartData cartData=cartDataService.editCart(cartId,cartDto);
        ResponseDto responseDto=new ResponseDto("updated data successfully",cartData);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/getCart")
    public List<CartData> retrieveCart(){
        return cartDataService.getCarts();
    }
    @GetMapping("/getById/{cartId}")
    public ResponseEntity<ResponseDto> getByCartId(@PathVariable long cartId){
        Optional<CartData> cartData=cartDataService.byId(cartId);
        ResponseDto responseDto=new ResponseDto("data got by cartId: "+cartId,cartData);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @DeleteMapping("/deleteCart/{cartId}")
    public ResponseEntity<ResponseDto> deleteCart(@PathVariable long cartId){
        CartData cartData=cartDataService.delete(cartId);
        ResponseDto responseDto=new ResponseDto("deleted cartId: "+cartId,cartData);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
