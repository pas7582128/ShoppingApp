package com.example.shoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    private String item_from_previous_page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        LinearLayout rootLayout=(LinearLayout)findViewById(R.id.linear_layout_root);
        ImageView  imageView_mobile_accessories;

        if(savedInstanceState==null){
            Bundle extras=getIntent().getExtras();
            item_from_previous_page=extras.getString("itemValue");
            Log.d("akash",item_from_previous_page);
        }


//        LinearLayout.LayoutParams imParams =
//                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        ImageView imSex = new ImageView(this);
//        imSex.setImageResource(R.drawable.dell_laptop);
//
//        rootLayout.addView(imSex,imParams);


    }
}
