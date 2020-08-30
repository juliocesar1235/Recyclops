package com.example.recyclops_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity2 extends AppCompatActivity {
    ImageView imageView;
    float x1, x2, y1, y2;
    Intent intent = getIntent();
    String jsonString = intent.getStringExtra("ProductData");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        imageView = findViewById(R.id.imageView);
        final TextView textView = (TextView)findViewById(R.id.textAct2);
        final TextView desc = (TextView)findViewById(R.id.desc);
        final TextView compositionTitle = (TextView)findViewById(R.id.compositionTitle);
        final TextView material1 = (TextView)findViewById(R.id.material1);
        final TextView material2 = (TextView)findViewById(R.id.material2);
        final TextView timeTo1 = (TextView)findViewById(R.id.timeTo1);
        final TextView timeTo2 = (TextView)findViewById(R.id.timeTo2);
        final TextView instructions = (TextView)findViewById(R.id.instructions);

        JSONArray imageUrl;
        JSONArray wasteComp;

        try {
            JSONObject productData = new JSONObject(jsonString);
            imageUrl = (JSONArray) productData.get("imagePaths");
            wasteComp = (JSONArray) productData.get("wasteComposition");
            if (productData != null){
                Glide.with(this).load(imageUrl.get(0)).into(imageView);
                textView.setText(productData.get("name").toString());
                desc.setText(productData.get("description").toString());
                compositionTitle.setText("Residue composition");
                material1.setText((String) wasteComp.getJSONObject(0).get("name"));
                material2.setText((String) wasteComp.getJSONObject(1).get("name"));
                timeTo1.setText((String) wasteComp.getJSONObject(0).get("timeToLive"));
                timeTo2.setText((String) wasteComp.getJSONObject(1).get("timeToLive"));
                instructions.setText(productData.get("instructions").toString());
            } else{

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                    Intent intent = new Intent(Activity2.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(x1 > x2){
                    Intent intent = new Intent(Activity2.this, MainActivity3.class);
                    intent.putExtra("productData", jsonString);
                    startActivity(intent);
                }
                break;
        }
        return false;
    }

}