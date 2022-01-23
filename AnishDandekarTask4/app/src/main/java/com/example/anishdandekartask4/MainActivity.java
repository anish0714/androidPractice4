package com.example.anishdandekartask4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Declaring edit text
        EditText name=findViewById(R.id.editName);
        EditText code=findViewById(R.id.editCode);
        EditText price=findViewById(R.id.editPrice);
        //  getting submit button from xml
        Button submit=findViewById(R.id.bSubmit);

        submit.setOnClickListener(view -> {
            //  concerting edit text to string
            String nameStr=name.getText().toString();
            String codeStr=code.getText().toString();
            //  converting price to float
            float priceFloat=Float.parseFloat(price.getText().toString());
            // validating text boxes
            if(nameStr.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Product's name field cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(codeStr.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Product's code field cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(priceFloat<0 || priceFloat==0)
            {
                Toast.makeText(getApplicationContext(), "invalid price", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences sharedPreferences=getSharedPreferences("Product Info", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("Name",nameStr);
            editor.putString("Code",codeStr);
            editor.putFloat("Price",priceFloat);
            editor.commit();

            Intent intent=new Intent(getApplicationContext(),ContentsActivity.class);
            startActivity(intent);
        });

    }
}