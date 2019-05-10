package com.example.meauapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthSettings;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PlayGamesAuthProvider;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.UserProfileChangeRequest;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Introducao extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducao);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();

            Button buttonAdotar = (Button) findViewById(R.id.btn_adotar);
            buttonAdotar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                if(user != null){
                    Intent intent = new Intent(Introducao.this,Adotar.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(Introducao.this,Login.class);
                    startActivity(intent);
                }
            }
        });
        }
    public void AcLogin2 (View view){
        Intent Login2 = new Intent(this, Login2.class);
        startActivity(Login2);
    }
    public void AcCadastroAnimal (View view){
        Intent CadastroAnimal = new Intent(this, CadastroAnimal.class);
        startActivity(CadastroAnimal);
    }

}
