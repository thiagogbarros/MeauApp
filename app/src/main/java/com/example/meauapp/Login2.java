package com.example.meauapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login2 extends AppCompatActivity {
    private EditText email, senha;
    private String Email,Senha;
    private Button login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        final EditText email = (EditText)findViewById(R.id.Email);
        final EditText senha = (EditText)findViewById(R.id.Senha);
        Button login = (Button)findViewById(R.id.entrar);
        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email = email.getText().toString().trim();
                Senha = senha.getText().toString().trim();
                entrar(Email,Senha);
            }
        });

    }
    public void AcCadastro(View view){
        startActivity(new Intent(Login2.this,Cadastro.class));
    }
    public void entrar(String email, String senha){
                mAuth.signInWithEmailAndPassword(Email,Senha)
                        .addOnCompleteListener(Login2.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task){
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    startActivity(new Intent(Login2.this,Introducao.class));
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Context context = getApplicationContext();
                                    CharSequence text = "Login feito com sucesso!";
                                    int duration = Toast.LENGTH_LONG;

                                    Toast toast = Toast.makeText(context, text, duration);
                                    toast.show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Context context = getApplicationContext();
                                    CharSequence text = "Login falhou ou Usuário não existe!";
                                    int duration = Toast.LENGTH_LONG;

                                    Toast toast = Toast.makeText(context, text, duration);
                                    toast.show();
                                    return;
                                }

                                // ...
                            }
                        });
            }

    }

