package com.example.meauapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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


            Button buttonAdotar = (Button) findViewById(R.id.btn_adotar);
            buttonAdotar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(Introducao.this,Adotar.class);
                startActivity(intent);
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
