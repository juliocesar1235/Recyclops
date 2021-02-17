package com.example.recyclops_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity3 extends AppCompatActivity {
    Intent intent = getIntent();
    String jsonString = intent.getStringExtra("ProductData");
    final TextView name = (TextView)findViewById(R.id.productName);
    final TextView instruct = (TextView)findViewById(R.id.instructions);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        JSONObject productData = null;
        try {
            productData = new JSONObject(jsonString);
            name.setText(productData.get("name").toString());
            instruct.setText(productData.get("instructions").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}