package com.love.lovesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas);
        getSupportActionBar().hide();
        Thread thread=new Thread(){
            public void run(){
                try {
                    sleep(4000);
                }catch (Exception e){

                }finally {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            }
        };thread.start();
    }
}