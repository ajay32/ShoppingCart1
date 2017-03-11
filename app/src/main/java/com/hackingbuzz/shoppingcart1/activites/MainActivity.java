package com.hackingbuzz.shoppingcart1.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hackingbuzz.shoppingcart1.R;
import com.hackingbuzz.shoppingcart1.activites.CheckoutScreen;
import com.hackingbuzz.shoppingcart1.application.MyApplication;
import com.hackingbuzz.shoppingcart1.model.Products;

public class MainActivity extends AppCompatActivity {
    Products product;
    LinearLayout mainLayout;
    LinearLayout.LayoutParams params;
    Button checkout;


    MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initObjects();


        // giving birth to 6  products just by creating one product (object)..so could distinct them by giving them numbers through i

        for (int i = 1; i <= 6; i++) {

            int PRICE = 15 + i;

            product = new Products("Product " + i, "Description", PRICE);

            myApplication.setProducts(product);  // after creating every product putting it to arraylist


        }


        // now get Products one by one n Print using textview on screen... u can do this by getting arraylist size..n then get products from index 1 by 1 n print em

        int productsSize = myApplication.getProductArraylistsize();

        for (int j = 0; j < productsSize; j++) {   // our array list start with 0 index...n go less then our size

// getting products by index from array list that is in our MyApplication class... with getProducts(positon)..n we gonna get detials of that product
            String productName = myApplication.getProducts(j).getProductName();

            String productDescription = myApplication.getProducts(j).getProductDesc();

            int productPrice = myApplication.getProducts(j).getProductPrice();


            // read this its  important..
            // if you thinking to add these detials to our xml created textView ,,,then you are wrong..coz our all  products one by one override our text view..n we would be able to see only last product detail..so what we can do is.. read below the program..

     /*       textView1.setText(productName);
            textView2.setText(productName);
            textView3.setText(productName);*/

            LinearLayout ourLayout = new LinearLayout(this);
            ourLayout.setOrientation(LinearLayout.HORIZONTAL);   // hwo our layout gonna set the detials of our every single product ..horizontally


            // TextViews from product Detail

            TextView tv1 = new TextView(this);
            tv1.setTextSize(15);
            tv1.setText(" " + productName + " ");
            ourLayout.addView(tv1);   // adding child to our layout..

            TextView tv2 = new TextView(this);
            tv2.setTextSize(15);
            tv2.setText(" " + productDescription + " ");
            ourLayout.addView(tv2);

            TextView tv3 = new TextView(this);
            tv3.setTextSize(15);
            tv3.setText("$" + productPrice + " ");
            ourLayout.addView(tv3);


            // creating button add to cart ...n adding listener to it...
            // by default our created view set to wrap content ...but we set them to wrap content manully ...by Creating LinearLayout Praram object..n set to button ,layout etc

            final Button addToCart = new Button(this);
            addToCart.setId(j+1);
            addToCart.setText("Add to Cart");
            addToCart.setLayoutParams(params);  // not required if you setting to warp_content

            final int index = j;   // we got total indexes of our proudcutSize loop
            // adding listener to our button..
            // 1 we have to check ,,if that particular item is in our cart..if no then add that prouduct to cart


            addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("Index",index+"");

                    Products product = myApplication.getProducts(index);  // getting our products one by one n checking  if it not exits in cart arraylist then add it to cart arraylist..

                   if(!myApplication.getCart().checkProductInCart(product)) {

                       addToCart.setText("Item added");  // changing button text

                       myApplication.getCart().setProductToCart(product);  // adding product to cart
                       Toast.makeText(getApplicationContext(), "New CartSize:" + myApplication.getCart().getCartsize(), Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(getApplicationContext(), "Product " + (index + 1) + " Already Added", Toast.LENGTH_LONG).show();


                   }
                }
            });


            ourLayout.addView(addToCart);
            mainLayout.addView(ourLayout);  // adding details of every single proudct in loop n sending it to screen..
        }


    }





    private void initObjects() {

        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    private void initView() {

        mainLayout = (LinearLayout) findViewById(R.id.ll_main_layout);


        myApplication = (MyApplication) getApplicationContext();


        checkout = (Button) findViewById(R.id.btn_checkout);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getBaseContext(), CheckoutScreen.class);
                startActivity(in);
            }
        });


    }
}

// so we cant set to our xml created text view ..so we can do ..is to create a linear layout in xml initilize it...n created our own linear layout...n text views for our details n ..set textview (created programitically) to our java created
// linear layout ...n then ,,,attach this layout to our xml created layout... by addView method,..n the work is down ...our text views for all proudcts will be creatd dynimically...yo yo
