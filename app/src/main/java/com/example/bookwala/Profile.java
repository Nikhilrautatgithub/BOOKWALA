package com.example.bookwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Profile extends AppCompatActivity {

    TextView tv_name , tv_email , tv_user_name;
    Button btn_logout;
    private String name;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        final int user_id = intent.getIntExtra("user_id" , 1);
        final String email = intent.getStringExtra("email");
        final String fname = intent.getStringExtra("fname");
        final String lname = intent.getStringExtra("lname");


        FirebaseFirestore db = FirebaseFirestore.getInstance();

        tv_name = findViewById(R.id.tv_profile_name);
        tv_email = findViewById(R.id.tv_profile_email);
        tv_user_name = findViewById(R.id.tv_user_name);

        btn_logout = findViewById(R.id.btn_logout);

        name = fname + " " + lname;

        tv_user_name.setText(name);
        tv_name.setText(name);
        tv_email.setText(email);

        //Initialization and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.Profile);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            private MenuItem item;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Book:
                        Log.d("here", "onNavigationItemSelected: Profile Book");

                        Intent book = new Intent(Profile.this , Book.class);
                        book.putExtra("user_id" , user_id);
                        book.putExtra("email" , email);
                        book.putExtra("fname" , fname);
                        book.putExtra("lname" , lname);

                        startActivity(book);

                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Add:
                        Log.d("here", "onNavigationItemSelected: Profile Add");

                        Intent add = new Intent(Profile.this , Add.class);
                        add.putExtra("user_id" , user_id);
                        add.putExtra("email" , email);
                        add.putExtra("fname" , fname);
                        add.putExtra("lname" , lname);

                        startActivity(add);

                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Chat:
                        Log.d("here", "onNavigationItemSelected: Profile Chat");

                        Intent chat = new Intent(Profile.this , Chat.class);
                        chat.putExtra("user_id" , user_id);
                        chat.putExtra("email" , email);
                        chat.putExtra("fname" , fname);
                        chat.putExtra("lname" , lname);

                        startActivity(chat);

                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Profile:
                        Log.d("here", "onNavigationItemSelected: Profile Profile");
                        return true;
                }
                return false;
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("here", "onClick: Profile logout");

                Intent logout = new Intent(Profile.this , Login.class);
                startActivity(logout);

            }
        });
    }
}