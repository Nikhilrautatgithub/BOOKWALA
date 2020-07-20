package com.example.bookwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Book extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        productList = new ArrayList<>();

        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Microprocessor",
                        "Techmax",
                        2015,
                        600,
                        R.drawable.book));

        productList.add(
                new Product(
                        1,
                        "maths",
                        "nirali",
                        2015,
                        700,
                        R.drawable.book));

        productList.add(
                new Product(
                        1,
                        "ADS",
                        "techmax",
                        2015,
                        300,
                        R.drawable.book));

        productList.add(
                new Product(
                        1,
                        "subodh",
                        "nirali",
                        2015,
                        700,
                        R.drawable.book));

        productList.add(
                new Product(
                        1,
                        "nikhil",
                        "techmax",
                        2015,
                        300,
                        R.drawable.book));
        productList.add(
                new Product(
                        1,
                        "ADS",
                        "techmax",
                        2015,
                        300,
                        R.drawable.book));
        productList.add(
                new Product(
                        1,
                        "subodh",
                        "nirali",
                        2015,
                        700,
                        R.drawable.book));

        productList.add(
                new Product(
                        1,
                        "nikhil",
                        "techmax",
                        2015,
                        300,
                        R.drawable.book));

        adapter = new ProductAdapter(this,productList);
        recyclerView.setAdapter(adapter);

        //Initialization and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.Book);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private MenuItem item;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Book:
                        Log.d("here", "onNavigationItemSelected: Book Book");
                        return true;
                    case R.id.Add:
                        Log.d("here", "onNavigationItemSelected: Book Add");
                        startActivity(new Intent(getApplicationContext()
                                ,Add.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Chat:
                        Log.d("here", "onNavigationItemSelected: Book Chat");
                        startActivity(new Intent(getApplicationContext()
                                ,Chat.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Profile:
                        Log.d("here", "onNavigationItemSelected: Book Profile");
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