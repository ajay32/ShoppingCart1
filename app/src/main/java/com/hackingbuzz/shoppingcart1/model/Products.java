package com.hackingbuzz.shoppingcart1.model;

/**
 * Created by Avi Hacker on 3/10/2017.
 */

public class Products {
    private String productName;
    private String productDesc;
    private int productPrice;
    public Products(String productName,String productDesc,int productPrice){  // giving birth to our products
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }


    // we created it becoz we need them to print name description and price on the sceen..using text view..so getting detials of all our prodcuts we gave birth to..
    public String getProductName(){
        return productName;
    }

    public String getProductDesc(){
        return productDesc;
    }

    public int getProductPrice(){
        return productPrice;
    }
}