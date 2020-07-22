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

        Intent intent = getIntent();
        final int user_id = intent.getIntExtra("user_id" , 1);
        final String email = intent.getStringExtra("email");
        final String fname = intent.getStringExtra("fname");
        final String lname = intent.getStringExtra("lname");

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

                        Intent book = new Intent(Chat.this , Book.class);
                        book.putExtra("user_id" , user_id);
                        book.putExtra("email" , email);
                        book.putExtra("fname" , fname);
                        book.putExtra("lname" , lname);

                        startActivity(book);

                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Add:
                        Log.d("here", "onNavigationItemSelected: Chat Add");

                        Intent add = new Intent(Chat.this , Add.class);
                        add.putExtra("user_id" , user_id);
                        add.putExtra("email" , email);
                        add.putExtra("fname" , fname);
                        add.putExtra("lname" , lname);

                        startActivity(add);

                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Chat:
                        Log.d("here", "onNavigationItemSelected: Chat Chat");
                        return true;
                    case R.id.Profile:
                        Log.d("here", "onNavigationItemSelected: Chat Profile");

                        Intent profile = new Intent(Chat.this , Profile.class);
                        profile.putExtra("user_id" , user_id);
                        profile.putExtra("email" , email);
                        profile.putExtra("fname" , fname);
                        profile.putExtra("lname" , lname);

                        startActivity(profile);

                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}