package com.example.bookwala;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {
    private EditText log_email , log_password ;
    private Button login_button;
    private TextView signUp;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();

        //Toast.makeText(this, "In login : after logout", Toast.LENGTH_SHORT).show();

        /*if (mAuth.getCurrentUser()!=null){
            Toast.makeText(this, "Was here", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Book.class));
        }*/

        mDialog=new ProgressDialog(this);

        log_email=findViewById(R.id.login_email);
        log_password=findViewById(R.id.login_pass);

        login_button=findViewById(R.id.login_button);
        signUp=findViewById(R.id.Register_link);

        /*

                BYPASS AUTHETICATION

         */

        //startActivity(new Intent(getApplicationContext(),Book.class));// Remove this to remove bypass





        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mEmail=log_email.getText().toString().trim();
                String mPass=log_password.getText().toString().trim();

                if (TextUtils.isEmpty(mEmail)){
                    log_email.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(mPass)){
                    log_password.setError("Required Field..");
                    return;
                }

                mDialog.setMessage("Processing..");
                mDialog.show();

                mAuth.signInWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //startActivity(new Intent(getApplicationContext(),Book.class));
                            //Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();

                            // TO extract user_id of that user using his e-mail


                            DocumentReference doc_ref = db.collection("Users").document(mEmail);

                            doc_ref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if(documentSnapshot.exists()) {
                                        int user_id = documentSnapshot.getLong("user_id").intValue();
                                        String email = documentSnapshot.getString("email");
                                        String fname = documentSnapshot.getString("fname");
                                        String lname = documentSnapshot.getString("lname");
                                        //Toast.makeText(Login.this, "User Id : " + user_id, Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Login.this, Book.class);
                                        intent.putExtra("user_id" , user_id);
                                        intent.putExtra("email" , email);
                                        intent.putExtra("fname" , fname);
                                        intent.putExtra("lname" , lname);

                                        startActivity(intent);

                                        mDialog.dismiss();
                                    }
                                    else {
                                        Toast.makeText(Login.this, "Document Does not exist", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();

                        }
                    }
                });
            }
        });
            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Log.d("here", "Login: ");
                        startActivity(new Intent(getApplicationContext(),Register.class));
                }
            });


    }
}