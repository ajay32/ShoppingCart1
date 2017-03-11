package com.hackingbuzz.shoppingcart1.model;

import java.util.ArrayList;

/**
 * Created by Avi Hacker on 3/10/2017.
 */


// our cart i snot a product (object) it just a list that we adding our products to ..so not taking constrouct (no birth)..just creating array list ..n adding products to it..

public class Cart {
    private ArrayList<Products> cartItems = new ArrayList<Products>();

    public Products getProductsFromCart(int position) {
        return cartItems.get(position);
    }

    public void setProductToCart(Products Products) {
        cartItems.add(Products);
    }

    public int getCartsize() {

        return cartItems.size();
    }

    public boolean checkProductInCart(Products product) {
        return cartItems.contains(product);   // return true if list contain specified item
    }
}