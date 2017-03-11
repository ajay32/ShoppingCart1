package com.hackingbuzz.shoppingcart1.application;

import android.app.Application;

import com.hackingbuzz.shoppingcart1.model.Cart;
import com.hackingbuzz.shoppingcart1.model.Products;

import java.util.ArrayList;

/**
 * Created by Avi Hacker on 3/11/2017.
 */

// we creating array list of our products here ...n also cart object ..so they are just created here once n..we dont need to created cart object again n again ..
    // in our project...n we can use it... by access this clas by its object (myApplication) ,n..what is here we can use it in any activity ..it could be accessible in whole project..

public class MyApplication extends Application {

    private ArrayList<Products> allProducts = new ArrayList<Products>();

    // we want that every product we created we put that in our arraylist using set method...n when we required it ..we can get it using get method..

    public Products getProducts(int position){
        return allProducts.get(position);
    }
    public void  setProducts(Products products){
        allProducts.add(products);
    }

    public int  getProductArraylistsize(){
        return allProducts.size();
    }


    // cart Object

    private Cart myCart = new Cart();

    public Cart getCart(){   // method created so that we can get our cart object where we call this method..so that we can access our cart class.. (methods )
        return myCart;
    }



}
