package com.example.bookwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //Initialization and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.Chat);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private MenuItem item;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Book:
                        Log.d("here", "onNavigationItemSelected: Chat Book");
                        startActivity(new Intent(getApplicationContext()
                                ,Book.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Add:
                        Log.d("here", "onNavigationItemSelected: Chat Add");
                        startActivity(new Intent(getApplicationContext()
                                ,Add.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Chat:
                        Log.d("here", "onNavigationItemSelected: Chat Chat");
                        return true;
                    case R.id.Profile:
                        Log.d("here", "onNavigationItemSelected: Chat Profile");
                        startActivity(new Intent(getApplicationContext()
                                ,Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}