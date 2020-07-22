package com.example.bookwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Book extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<Product> productList;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        final Intent intent = getIntent();
        final int user_id = intent.getIntExtra("user_id" , 1);
        final String email = intent.getStringExtra("email");
        final String fname = intent.getStringExtra("fname");
        final String lname = intent.getStringExtra("lname");

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

                        Intent add = new Intent(Book.this , Add.class);

                        add.putExtra("user_id" , user_id);
                        add.putExtra("email" , email);
                        add.putExtra("fname" , fname);
                        add.putExtra("lname" , lname);

                        Log.d("here", "onNavigationItemSelected: Book Add");
                        startActivity(add);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Chat:
                        Log.d("here", "onNavigationItemSelected: Book Chat");

                        Intent chat = new Intent(Book.this , Chat.class);
                        chat.putExtra("user_id" , user_id);
                        chat.putExtra("email" , email);
                        chat.putExtra("fname" , fname);
                        chat.putExtra("lname" , lname);

                        startActivity(chat);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Profile:
                        Log.d("here", "onNavigationItemSelected: Book Profile");

                        Intent profile = new Intent(Book.this , Profile.class);
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