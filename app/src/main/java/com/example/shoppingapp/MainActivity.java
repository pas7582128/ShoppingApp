package com.example.shoppingapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] itemNames={"Mobile accessories","Laptops","Shoes","Fruits","Vegetables"};
    private TextView mTextView;
    private Button mButton;
    private Spinner mSpinner;
    private String item;
    static int flag=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner=(Spinner)findViewById(R.id.spinner_item_list);
        mButton=(Button)findViewById(R.id.submit);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,itemNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(arrayAdapter);

        if(savedInstanceState==null){
            Intent intent=getIntent();
            if(intent.hasExtra("AddToCart")){
                flag=0;
            }
        }

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item=mSpinner.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag=flag+1;
                Intent intent=new Intent(MainActivity.this,ItemActivity.class);
                intent.putExtra("itemValue",item);
                intent.putExtra("flag",flag);
                startActivity(intent);
            }
        });
    }


}


