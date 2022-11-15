package com.love.lovesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<SMSListModel> list;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listId);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView_main);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        CostomArray();
        OnClickListener();
    }



    private void OnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){
                    startActivity(new Intent(MainActivity.this,ValobasaSms.class));
                }
                else if (position==1){
                    startActivity(new Intent(MainActivity.this,RomansSms.class));
                }
                else if (position==2){
                    startActivity(new Intent(MainActivity.this,BokaSms.class));
                }  else if (position==3){
                    startActivity(new Intent(MainActivity.this,KostoSms.class));
                } else if (position==4){
                    startActivity(new Intent(MainActivity.this,MonyPorarSms.class));
                } else if (position==5){
                    startActivity(new Intent(MainActivity.this,BirthdaySms.class));
                }else if (position==6){
                    startActivity(new Intent(MainActivity.this,BanglaFriendshipSms.class));
                }else if (position==7){
                    startActivity(new Intent(MainActivity.this,BanglishLoveSms.class));
                }

            }
        });

    }


    private void CostomArray() {
        list = new ArrayList<>();
        list.add(new SMSListModel("ভালোবাসার এসএমএস "));
        list.add(new SMSListModel("রাতের রোমান্টিক এসএমএস "));
        list.add(new SMSListModel("বোকা বানানোর এসএমএস "));
        list.add(new SMSListModel("কষ্টের  এসএমএস "));
        list.add(new SMSListModel("মনে পরার   এসএমএস "));
        list.add(new SMSListModel("জন্মদিনের  এসএমএস "));
        list.add(new SMSListModel("Bangla Friendship Sms "));
        list.add(new SMSListModel("Banglish love sms  "));


        SMSListCostomAdapter listAdapter = new SMSListCostomAdapter(this, list);
        listView.setAdapter(listAdapter);
    }
}