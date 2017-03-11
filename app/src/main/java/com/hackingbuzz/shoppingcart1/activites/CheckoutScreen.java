package com.hackingbuzz.shoppingcart1.activites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hackingbuzz.shoppingcart1.R;
import com.hackingbuzz.shoppingcart1.application.MyApplication;

/**
 * Created by Avi Hacker on 3/11/2017.
 */

public class CheckoutScreen extends AppCompatActivity {

    TextView showCart;
    MyApplication myApplication;
    StringBuffer buffer;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_screen);

        initView();
        initObjects();

        // here we gonna get Products (Product details ) that in our cart n show it to user,...

      int cartSize =   myApplication.getCart().getCartsize();

        for(int i = 0 ; i<cartSize ; i++) {

            String pName =  myApplication.getCart().getProductsFromCart(i).getProductName();  // getting cartObject then ProductObject from it ..then name from ProjectObject
            String pDesc =  myApplication.getCart().getProductsFromCart(i).getProductDesc();
            int pPrice =  myApplication.getCart().getProductsFromCart(i).getProductPrice();


            //  you know that we cant just ..our products details to single list view ...bcoz its gonna override...so we have to create text view programitically
            // so we got another way to do it...the details we getting about the products..we appeding it to buffer..then adding buffer to textView..cool

            buffer.append("Name: "+pName +", "+ " Desc: "+pDesc+ ", "+"Price: "+pPrice+"\n\n");
        }

        showCart.setText(buffer);



    }

    private void initObjects() {

         myApplication = (MyApplication) getApplicationContext();
        buffer = new StringBuffer();
    }

    private void initView() {

         showCart = (TextView)findViewById(R.id.tv_show_cart);
    }
}
