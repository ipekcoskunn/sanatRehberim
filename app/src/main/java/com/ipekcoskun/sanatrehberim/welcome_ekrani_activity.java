package com.ipekcoskun.sanatrehberim;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class welcome_ekrani_activity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    EditText emailText, passwordText;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_ekrani);


        firebaseAuth = FirebaseAuth.getInstance();
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);

        FirebaseUser firebaseUser =firebaseAuth.getCurrentUser();

        if(firebaseUser != null){

        }
            Intent intent = new Intent(welcome_ekrani_activity.this,MainActivity.class);
            startActivity(intent);


    }

    public void signInClicked (View view){
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent = new Intent(welcome_ekrani_activity.this,MainActivity.class);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(welcome_ekrani_activity.this,"E-mail adresi veya Parola Yanlış",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void signUpClicked (View view){
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();


        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(welcome_ekrani_activity.this,"Hesap Oluşturuldu",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(welcome_ekrani_activity.this,MainActivity.class);
                startActivity(intent);
                //eski aktiviteye geri dönme şansı hiç yok

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(welcome_ekrani_activity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

}
