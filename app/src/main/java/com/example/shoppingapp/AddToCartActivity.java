package com.example.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddToCartActivity extends AppCompatActivity {

    ArrayList<String> hmap1=new ArrayList<>();
    ArrayList <String> hmap2=new ArrayList<>();
    ArrayList <String> hmap3=new ArrayList<>();
    ArrayList <String> hmap4=new ArrayList<>();
    ArrayList <String> hmap5=new ArrayList<>();

    ArrayList <Integer> hmap12=new ArrayList<>();
    ArrayList <Integer> hmap22=new ArrayList<>();
    ArrayList <Integer> hmap32=new ArrayList<>();
    ArrayList <Integer> hmap42=new ArrayList<>();
    ArrayList <Integer> hmap52=new ArrayList<>();

    ArrayList <Integer> hmap13=new ArrayList<>();
    ArrayList <Integer> hmap23=new ArrayList<>();
    ArrayList <Integer> hmap33=new ArrayList<>();
    ArrayList <Integer> hmap43=new ArrayList<>();
    ArrayList <Integer> hmap53=new ArrayList<>();

    HashMap <HashMap <String,Integer>,Integer> m;
    HashMap <String,item> tmp=new HashMap<>();
    HashMap <String,item> tmp1=new HashMap<>();
    HashMap <String,item> tmp2=new HashMap<>();
    HashMap <String,item> tmp3=new HashMap<>();
    HashMap <String,item> tmp4=new HashMap<>();
    
    Button ButtonClearCart;


    long total=0;

    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        Bundle extras=getIntent().getExtras();
        hmap1=extras.getStringArrayList("hmap1");
        hmap12=extras.getIntegerArrayList("hmap12");
        hmap13=extras.getIntegerArrayList("hmap13");

        hmap2=extras.getStringArrayList("hmap2");
        hmap22=extras.getIntegerArrayList("hmap22");
        hmap23=extras.getIntegerArrayList("hmap23");

        hmap3=extras.getStringArrayList("hmap3");
        hmap32=extras.getIntegerArrayList("hmap32");
        hmap33=extras.getIntegerArrayList("hmap33");

        hmap4=extras.getStringArrayList("hmap4");
        hmap42=extras.getIntegerArrayList("hmap42");
        hmap43=extras.getIntegerArrayList("hmap43");

        hmap5=extras.getStringArrayList("hmap5");
        hmap52=extras.getIntegerArrayList("hmap52");
        hmap53=extras.getIntegerArrayList("hmap53");

        l1=(LinearLayout)findViewById(R.id.add_to_cart_xml_2);

        ButtonClearCart=(Button)findViewById(R.id.clear_cart);

        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

//        for(int i=1;i<=10;i++) {
//            TextView tv=new TextView(this);
//            tv.setLayoutParams(lparams);
//            tv.setText("test");
//            this.l1.addView(tv);
//        }

        int size1=hmap1.size();
        int size2=hmap2.size();
        int size3=hmap3.size();
        int size4=hmap4.size();
        int size5=hmap5.size();


        for(int i=0;i<size1;i++){
            String name = hmap1.get(i);
            int value = hmap13.get(i);
            int c = hmap12.get(i);
            if(tmp.containsKey(name)){
                tmp.put(name,new item(name,tmp.get(name).count+c,value));
            }else{
                tmp.put(name,new item(name,c,value));
            }
        }




        for(int i=0;i<size2;i++){
            String name = hmap2.get(i);
            int value = hmap23.get(i);
            int c = hmap22.get(i);
            if(tmp1.containsKey(name)){
                tmp1.put(name,new item(name,tmp1.get(name).count+c,value));
            }else{
                tmp1.put(name,new item(name,c,value));
            }
        }

        for(int i=0;i<size3;i++){
            String name = hmap3.get(i);
            int value = hmap33.get(i);
            int c = hmap32.get(i);
            if(tmp2.containsKey(name)){
                tmp2.put(name,new item(name,tmp2.get(name).count+c,value));
            }else{
                tmp2.put(name,new item(name,c,value));
            }
        }

        for(int i=0;i<size4;i++){
            String name = hmap4.get(i);
            int value = hmap43.get(i);
            int c = hmap42.get(i);
            if(tmp3.containsKey(name)){
                tmp3.put(name,new item(name,tmp3.get(name).count+c,value));
            }else{
                tmp3.put(name,new item(name,c,value));
            }
        }

        for(int i=0;i<size5;i++){
            String name = hmap5.get(i);
            int value = hmap53.get(i);
            int c = hmap52.get(i);
            if(tmp4.containsKey(name)){
                tmp4.put(name,new item(name,tmp4.get(name).count+c,value));
            }else{
                tmp4.put(name,new item(name,c,value));
            }
        }
//
//        for(int i=0;i<size1;i++){
//            if(tmp!=null) {
//                tmp.clear();
//
//                tmp.put(hmap1.get(i), hmap12.get(i));
//                if (m.containsKey(tmp)) {
//                    m.put(tmp, m.get(tmp) + hmap13.get(i));
//                }
//            }
//            else{
//                tmp.put(hmap1.get(i), hmap12.get(i));
//                m.put(tmp,hmap13.get(i));
//            }
//        }
//
//
//        for (HashMap.Entry<HashMap <String,Integer>,Integer>  entry : m.entrySet()){
//            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//            Log.d("akash",entry.getKey()+" "+entry.getValue());
//        }



        for(Map.Entry<String,item>  k : tmp.entrySet()){
            String name= k.getKey();
            int c = k.getValue().count;
            int v = k.getValue().value;
            TextView tv=new TextView(this);
            tv.setLayoutParams(lparams);
            tv.setText(name +" X " +c +" == "+(c*v));
            total+=c*v;
            tv.setTextSize(20);
            this.l1.addView(tv);
        }



        for(Map.Entry<String,item>  k : tmp1.entrySet()){
            String name= k.getKey();
            int c = k.getValue().count;
            int v = k.getValue().value;
            TextView tv=new TextView(this);
            tv.setLayoutParams(lparams);
            tv.setText(name +" X " +c +" == "+(c*v));
            total+=c*v;
            tv.setTextSize(20);
            this.l1.addView(tv);
        }

        for(Map.Entry<String,item>  k : tmp2.entrySet()){
            String name= k.getKey();
            int c = k.getValue().count;
            int v = k.getValue().value;
            TextView tv=new TextView(this);
            tv.setLayoutParams(lparams);
            tv.setText(name +" X " +c +" == "+(c*v));
            total+=c*v;
            tv.setTextSize(20);
            this.l1.addView(tv);
        }

        for(Map.Entry<String,item>  k : tmp3.entrySet()){
            String name= k.getKey();
            int c = k.getValue().count;
            int v = k.getValue().value;
            TextView tv=new TextView(this);
            tv.setLayoutParams(lparams);
            tv.setText(name +" X " +c +" == "+(c*v));
            total+=c*v;
            tv.setTextSize(20);
            this.l1.addView(tv);
        }

        for(Map.Entry<String,item>  k : tmp4.entrySet()){
            String name= k.getKey();
            int c = k.getValue().count;
            int v = k.getValue().value;
            TextView tv=new TextView(this);
            tv.setLayoutParams(lparams);
            tv.setText(name +" X " +c +" == "+(c*v));
            total+=c*v;
            tv.setTextSize(20);
            this.l1.addView(tv);
        }
//
//        for(int i=0;i<size2;i++){
//            TextView tv=new TextView(this);
//            tv.setLayoutParams(lparams);
//            tv.setText(hmap2.get(i) +" X " +hmap22.get(i) +" == "+hmap22.get(i)*hmap23.get(i));
//            total+=hmap22.get(i)*hmap23.get(i);
//            tv.setTextSize(20);
//            this.l1.addView(tv);
//        }
//
//        for(int i=0;i<size3;i++){
//            TextView tv=new TextView(this);
//            tv.setLayoutParams(lparams);
//            tv.setText(hmap3.get(i) +" X " +hmap32.get(i) +" == "+hmap32.get(i)*hmap33.get(i));
//            total+=hmap32.get(i)*hmap33.get(i);
//            this.l1.addView(tv);
//            tv.setTextSize(20);
//        }
//
//        for(int i=0;i<size4;i++){
//            TextView tv=new TextView(this);
//            tv.setLayoutParams(lparams);
//            tv.setText(hmap4.get(i) +" X " +hmap42.get(i) +" == "+hmap42.get(i)*hmap43.get(i));
//            total+=hmap42.get(i)*hmap43.get(i);
//            this.l1.addView(tv);
//            tv.setTextSize(20);
//        }
//
//        for(int i=0;i<size5;i++){
//            TextView tv=new TextView(this);
//            tv.setLayoutParams(lparams);
//            tv.setText(hmap5.get(i) +" X " +hmap52.get(i) +" == "+hmap52.get(i)*hmap53.get(i));
//            total+=hmap52.get(i)*hmap53.get(i);
//            this.l1.addView(tv);
//            tv.setTextSize(20);
//        }

        TextView tv=new TextView(this);
        tv.setLayoutParams(lparams);
        tv.setText("---------------------------------------------------------------");
        this.l1.addView(tv);
        tv.setTextSize(20);

        tv=new TextView(this);
        tv.setLayoutParams(lparams);
        tv.setText("Total = "+total);
        this.l1.addView(tv);
        tv.setTextSize(20);

        ButtonClearCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddToCartActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("AddToCart",0);
                startActivity(intent);
                finish();
            }
        });

//        for (int number : hmap12) {
//            //System.out.print(number);
//            Log.d("akash",number+"");
//        }


    }

    class  item{

        String mString;
        int count;
        int value;
        public item(String s,int c,int v){
            this.mString = s;
            this.count = c;
            this.value = v;
        }

    }
}
