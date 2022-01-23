package com.example.anishdandekartask4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ContentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);

        //  Taking name, code and price from xml id
        TextView displayName=findViewById(R.id.displayName);
        TextView displayCode=findViewById(R.id.displayCode);
        TextView displayPrice=findViewById(R.id.displayPrice);

        //  Declaring shared preference
        SharedPreferences sharedPreferences=getSharedPreferences("Product Info",MODE_PRIVATE);

        //  Assigning name,code and price
        String name=sharedPreferences.getString("Name","");
        String code=sharedPreferences.getString("Code","");
        Float price=sharedPreferences.getFloat("Price",0);

        //  Displaying data on Content screen
        displayName.setText(name);
        displayCode.setText(code);
        displayPrice.setText(new StringBuilder().append("$").append(price).toString());
    }
}