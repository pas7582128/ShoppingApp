package com.example.shoppingapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import java.util.ArrayList;
import java.util.HashMap;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class ItemActivity extends AppCompatActivity {

    int m1=0,m2=0,m3=0,m4=0,m5=0;
    private String item_from_previous_page;
    private ImageView img1,img2,img3,img4,img5;
    private TextView itemName1,itemName2,itemName3,itemName4,itemName5;
    private TextView itemPrice1,itemPrice2,itemPrice3,itemPrice4,itemPrice5;
    private Button button_inc_1,button_dec_1,button_add_to_cart_1;
    private Button button_inc_2,button_dec_2,button_add_to_cart_2;
    private Button button_inc_3,button_dec_3,button_add_to_cart_3;
    private Button button_inc_4,button_dec_4,button_add_to_cart_4;
    private Button button_inc_5,button_dec_5,button_add_to_cart_5;
    private Button view_cart;
    
    private ImageView image_view_qr1;
    private ImageView image_view_qr2;
    private ImageView image_view_qr3;
    private ImageView image_view_qr4;
    private ImageView image_view_qr5;
    
    
    
    private TextView text_view_number_of_items_1,text_view_number_of_items_2,text_view_number_of_items_3,text_view_number_of_items_4,text_view_number_of_items_5;
//    HashMap <String,Integer> hmap1=new HashMap<String,Integer>();
//    HashMap <String,Integer> hmap2=new HashMap<String,Integer>();
//    HashMap <String,Integer> hmap3=new HashMap<String,Integer>();
//    HashMap <String,Integer> hmap4=new HashMap<String,Integer>();
//    HashMap <String,Integer> hmap5=new HashMap<String,Integer>();

    public static ArrayList <String> hmap1=new ArrayList<>();
    public static ArrayList <String> hmap2=new ArrayList<>();
    public static ArrayList <String> hmap3=new ArrayList<>();
    public static ArrayList <String> hmap4=new ArrayList<>();
    public static ArrayList <String> hmap5=new ArrayList<>();

    public static ArrayList <Integer> hmap12=new ArrayList<>();
    public static ArrayList <Integer> hmap22=new ArrayList<>();
    public static ArrayList <Integer> hmap32=new ArrayList<>();
    public static ArrayList <Integer> hmap42=new ArrayList<>();
    public static ArrayList <Integer> hmap52=new ArrayList<>();

    public static ArrayList <Integer> hmap13=new ArrayList<>();
    public static ArrayList <Integer> hmap23=new ArrayList<>();
    public static ArrayList <Integer> hmap33=new ArrayList<>();
    public static ArrayList <Integer> hmap43=new ArrayList<>();
    public static ArrayList <Integer> hmap53=new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        //LinearLayout rootLayout=(LinearLayout)findViewById(R.id.linear_layout_root);
        //ImageView  imageView_mobile_accessories;
        img1=(ImageView)findViewById(R.id.image1);
        img2=(ImageView)findViewById(R.id.image2);
        img3=(ImageView)findViewById(R.id.image3);
        img4=(ImageView)findViewById(R.id.image4);
        img5=(ImageView)findViewById(R.id.image5);

        itemName1=(TextView)findViewById(R.id.item_name_1);
        itemName2=(TextView)findViewById(R.id.item_name_2);
        itemName3=(TextView)findViewById(R.id.item_name_3);
        itemName4=(TextView)findViewById(R.id.item_name_4);
        itemName5=(TextView)findViewById(R.id.item_name_5);

        itemPrice1=(TextView)findViewById(R.id.item_price_1);
        itemPrice2=(TextView)findViewById(R.id.item_price_2);
        itemPrice3=(TextView)findViewById(R.id.item_price_3);
        itemPrice4=(TextView)findViewById(R.id.item_price_4);
        itemPrice5=(TextView)findViewById(R.id.item_price_5);

        button_add_to_cart_1=(Button)findViewById(R.id.button_add_to_cart_1);
        button_add_to_cart_2=(Button)findViewById(R.id.button_add_to_cart_2);
        button_add_to_cart_3=(Button)findViewById(R.id.button_add_to_cart_3);
        button_add_to_cart_4=(Button)findViewById(R.id.button_add_to_cart_4);
        button_add_to_cart_5=(Button)findViewById(R.id.button_add_to_cart_5);

        view_cart=(Button)findViewById(R.id.view_cart);

        image_view_qr1=(ImageView)findViewById(R.id.qr_image1);
        image_view_qr2=(ImageView)findViewById(R.id.qr_image2);
        image_view_qr3=(ImageView)findViewById(R.id.qr_image3);
        image_view_qr4=(ImageView)findViewById(R.id.qr_image4);
        image_view_qr5=(ImageView)findViewById(R.id.qr_image5);

        if(savedInstanceState==null){
            Bundle extras=getIntent().getExtras();
            item_from_previous_page=extras.getString("itemValue");
            Log.d("akash",item_from_previous_page);
        }
        if(item_from_previous_page.equals("Mobile accessories")){
            img1.setImageResource(R.drawable.charger);
            img2.setImageResource(R.drawable.datacable);
            img3.setImageResource(R.drawable.headphone);
            img4.setImageResource(R.drawable.powerbank);
            img5.setImageResource(R.drawable.screenguard);
            itemName1.setText("Charger");
            itemPrice1.setText("250");
            itemName2.setText("Data cable");
            itemPrice2.setText("150");
            itemName3.setText("Headphone");
            itemPrice3.setText("650");
            itemName4.setText("Powerbank");
            itemPrice4.setText("1400");
            itemName5.setText("Screenguard");
            itemPrice5.setText("200");
            

            

        }
        else if(item_from_previous_page.equals("Laptops")){
            img1.setImageResource(R.drawable.acer_laptop);
            img2.setImageResource(R.drawable.apple_macbook_air);
            img3.setImageResource(R.drawable.dell_laptop);
            img4.setImageResource(R.drawable.hp_laptop);
            img5.setImageResource(R.drawable.lenovo_laptop);
            itemName1.setText("Acer laptop");
            itemPrice1.setText("38000");
            itemName2.setText("Apple macbook");
            itemPrice2.setText("70000");
            itemName3.setText("Dell laptop");
            itemPrice3.setText("45000");
            itemName4.setText("Hp laptop");
            itemPrice4.setText("35000");
            itemName5.setText("Lenovo laptop");
            itemPrice5.setText("30000");
        }
        else if(item_from_previous_page.equals("Shoes")){
            img1.setImageResource(R.drawable.shoes1);
            img2.setImageResource(R.drawable.shoes2);
            img3.setImageResource(R.drawable.shoes3);
            img4.setImageResource(R.drawable.shoes4);
            img5.setImageResource(R.drawable.shoes5);
            itemName1.setText("Sparx");
            itemPrice1.setText("850");
            itemName2.setText("Asian fashion-13");
            itemPrice2.setText("500");
            itemName3.setText("Puma");
            itemPrice3.setText("1700");
            itemName4.setText("Sparx SL-123");
            itemPrice4.setText("900");
            itemName5.setText("Asian Riya-51");
            itemPrice5.setText("500");
        }
        else if(item_from_previous_page.equals("Fruits")){
            img1.setImageResource(R.drawable.apple);
            img2.setImageResource(R.drawable.banana);
            img3.setImageResource(R.drawable.grapes);
            img4.setImageResource(R.drawable.orange);
            img5.setImageResource(R.drawable.pomegranate);
            itemName1.setText("Apple");
            itemPrice1.setText("140");
            itemName2.setText("Asian fashion-13");
            itemPrice2.setText("40");
            itemName3.setText("Grapes");
            itemPrice3.setText("60");
            itemName4.setText("Orange");
            itemPrice4.setText("50");
            itemName5.setText("Pomegranate");
            itemPrice5.setText("120");
        }
        else {
            img1.setImageResource(R.drawable.carrot);
            img2.setImageResource(R.drawable.ladies_finger);
            img3.setImageResource(R.drawable.onion);
            img4.setImageResource(R.drawable.potato);
            img5.setImageResource(R.drawable.tomato_hybrid);
            itemName1.setText("Carrot");
            itemPrice1.setText("100");
            itemName2.setText("Ladies finger");
            itemPrice2.setText("70");
            itemName3.setText("Onion");
            itemPrice3.setText("60");
            itemName4.setText("Potato");
            itemPrice4.setText("30");
            itemName5.setText("Tomato");
            itemPrice5.setText("40");
        }


        QRGEncoder qrgEncoder = new QRGEncoder(itemName1.getText().toString()+"---"+itemPrice1.getText().toString(), null, QRGContents.Type.TEXT, (int) ( 500));
        Log.d("akash",itemName1.getText().toString()+" "+itemPrice1.getText().toString());
        try {
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            // Setting Bitmap to ImageView
            image_view_qr1.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v("QRERROR", e.toString());
        }

        qrgEncoder = new QRGEncoder(itemName2.getText().toString()+"---"+itemPrice2.getText().toString(), null, QRGContents.Type.TEXT, (int) ( 500));
        Log.d("akash",itemName2.getText().toString()+" "+itemPrice2.getText().toString());
        try {
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            // Setting Bitmap to ImageView
            image_view_qr2.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v("QRERROR", e.toString());
        }

        qrgEncoder = new QRGEncoder(itemName3.getText().toString()+"---"+itemPrice3.getText().toString(), null, QRGContents.Type.TEXT, (int) ( 500));
        Log.d("akash",itemName3.getText().toString()+" "+itemPrice3.getText().toString());
        try {
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            // Setting Bitmap to ImageView
            image_view_qr3.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v("QRERROR", e.toString());
        }

        qrgEncoder = new QRGEncoder(itemName4.getText().toString()+"---"+itemPrice4.getText().toString(), null, QRGContents.Type.TEXT, (int) ( 500));
        Log.d("akash",itemName4.getText().toString()+" "+itemPrice4.getText().toString());
        try {
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            // Setting Bitmap to ImageView
            image_view_qr4.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v("QRERROR", e.toString());
        }

        qrgEncoder = new QRGEncoder(itemName5.getText().toString()+"---"+itemPrice5.getText().toString(), null, QRGContents.Type.TEXT, (int) ( 500));
        Log.d("akash",itemName5.getText().toString()+" "+itemPrice5.getText().toString());
        try {
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            // Setting Bitmap to ImageView
            image_view_qr5.setImageBitmap(bitmap);
        } catch (WriterException e) {
            Log.v("QRERROR", e.toString());
        }
//        LinearLayout.LayoutParams imParams =
//                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        ImageView imSex = new ImageView(this);
//        imSex.setImageResource(R.drawable.dell_laptop);
//
//        rootLayout.addView(imSex,imParams);
        button_add_to_cart_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m1>0) {
                    hmap1.add(itemName1.getText().toString());
                    hmap12.add(m1);
                    hmap13.add(Integer.parseInt(itemPrice1.getText().toString()));
                    Toast.makeText(ItemActivity.this, "Added to cart successfully", Toast.LENGTH_SHORT).show();
                    Log.d("akash", "addtocart1");
                    m1=0;
                    display1(m1);
                }
                else{
                    Toast.makeText(ItemActivity.this, "Add atleast 1 item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_add_to_cart_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m2>0) {
                    hmap2.add(itemName2.getText().toString());
                    hmap22.add(m2);
                    hmap23.add(Integer.parseInt(itemPrice2.getText().toString()));
                    //hmap2.put(itemName2.getText().toString(),Integer.parseInt(itemPrice2.getText().toString()));
                    Toast.makeText(ItemActivity.this, "Added to cart succesfully", Toast.LENGTH_SHORT).show();
                    Log.d("akash", "addtocart2");
                    m2=0;
                    display2(m2);
                }
                else{
                    Toast.makeText(ItemActivity.this, "Add atleast 1 item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_add_to_cart_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m3 > 0) {
                    hmap3.add(itemName3.getText().toString());
                    hmap32.add(m3);
                    hmap33.add(Integer.parseInt(itemPrice3.getText().toString()));
                    //hmap32.add(Integer.parseInt(itemPrice3.getText().toString()));
                    //hmap3.put(itemName3.getText().toString(),Integer.parseInt(itemPrice3.getText().toString()));
                    Toast.makeText(ItemActivity.this, "Added to cart succesfully", Toast.LENGTH_SHORT).show();
                    Log.d("akash", "addtocart3");
                    m3=0;
                    display3(m3);
                }
                else{
                    Toast.makeText(ItemActivity.this, "Add atleast 1 item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_add_to_cart_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m4>0) {
                    hmap4.add(itemName4.getText().toString());
                    hmap42.add(m4);
                    hmap43.add(Integer.parseInt(itemPrice4.getText().toString()));
                    //hmap42.add(Integer.parseInt(itemPrice4.getText().toString()));
                    //hmap4.put(itemName4.getText().toString(),Integer.parseInt(itemPrice4.getText().toString()));
                    Toast.makeText(ItemActivity.this, "Added to cart succesfully", Toast.LENGTH_SHORT).show();
                    Log.d("akash", "addtocart4");
                    m4=0;
                    display4(m4);
                }
                else{
                    Toast.makeText(ItemActivity.this, "Add atleast 1 item", Toast.LENGTH_SHORT).show();
                }
            }

        });

        button_add_to_cart_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m5>0) {
                    hmap5.add(itemName5.getText().toString());
                    hmap52.add(m5);
                    hmap53.add(Integer.parseInt(itemPrice5.getText().toString()));
                    //hmap52.add(Integer.parseInt(itemPrice5.getText().toString()));
                    //hmap5.put(itemName5.getText().toString(),Integer.parseInt(itemPrice5.getText().toString()));
                    Toast.makeText(ItemActivity.this, "Added to cart succesfully", Toast.LENGTH_SHORT).show();
                    Log.d("akash", "addtocart5");
                    m5=0;
                    display5(m5);
                }
                else{
                    Toast.makeText(ItemActivity.this, "Add atleast 1 item", Toast.LENGTH_SHORT).show();
                }
            }
        });



        view_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ItemActivity.this,AddToCartActivity.class);

                intent.putExtra("hmap1",hmap1);
                intent.putExtra("hmap12",hmap12);
                intent.putExtra("hmap13",hmap13);

                intent.putExtra("hmap2",hmap2);
                intent.putExtra("hmap22",hmap22);
                intent.putExtra("hmap23",hmap23);

                intent.putExtra("hmap3",hmap3);
                intent.putExtra("hmap32",hmap32);
                intent.putExtra("hmap33",hmap33);

                intent.putExtra("hmap4",hmap4);
                intent.putExtra("hmap42",hmap42);
                intent.putExtra("hmap43",hmap43);

                intent.putExtra("hmap5",hmap5);
                intent.putExtra("hmap52",hmap52);
                intent.putExtra("hmap53",hmap53);

                startActivity(intent);
            }
        });


    }

    public void increaseInteger_1(View view) {
        m1 = m1 + 1;
        display1(m1);

    }
    public void decreaseInteger_1(View view) {
        if(m1!=0)
        m1 = m1 - 1;
        display1(m1);
    }

    private void display1(int number){
        TextView displayInteger = (TextView) findViewById(R.id.integer_number_1);
        displayInteger.setText("" + number);
    }

    public void increaseInteger_2(View view) {
        m2 = m2 + 1;
        display2(m2);

    }
    public void decreaseInteger_2(View view) {
        if(m2!=0)
            m2 = m2 - 1;
        display2(m2);
    }

    private void display2(int number){
        TextView displayInteger = (TextView) findViewById(R.id.integer_number_2);
        displayInteger.setText("" + number);
    }

    public void increaseInteger_3(View view) {
        m3 = m3 + 1;
        display3(m3);

    }
    public void decreaseInteger_3(View view) {
        if(m3!=0)
            m3 = m3 - 1;
        display3(m3);
    }

    private void display3(int number){
        TextView displayInteger = (TextView) findViewById(R.id.integer_number_3);
        displayInteger.setText("" + number);
    }

    public void increaseInteger_4(View view) {
        m4 = m4 + 1;
        display4(m4);

    }
    public void decreaseInteger_4(View view) {
        if(m4!=0)
            m4 = m4 - 1;
        display4(m4);
    }

    private void display4(int number){
        TextView displayInteger = (TextView) findViewById(R.id.integer_number_4);
        displayInteger.setText("" + number);
    }

    public void increaseInteger_5(View view) {
        m5 = m5 + 1;
        display5(m5);

    }
    public void decreaseInteger_5(View view) {
        if(m5!=0)
            m5 = m5 - 1;
        display5(m5);
    }

    private void display5(int number){
        TextView displayInteger = (TextView) findViewById(R.id.integer_number_5);
        displayInteger.setText("" + number);
    }




}
