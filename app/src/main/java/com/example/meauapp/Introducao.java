package com.example.meauapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Introducao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducao);

            Button buttonAdotar = (Button) findViewById(R.id.btn_adotar);
            buttonAdotar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(Introducao.this,Adotar.class);
                startActivity(intent);
            }
        });
        TextView buttonLogin = (TextView) findViewById(R.id.login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent login = new Intent(Introducao.this,Login2.class);
                startActivity(login);
            }
        });
        }


}
