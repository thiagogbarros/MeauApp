package com.example.meauapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class CadastroAnimal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_animal);

        ToggleButton toggle1,toggle2,toggle3;

        toggle1= (ToggleButton) findViewById(R.id.toggleAdocao);
        toggle2 = (ToggleButton) findViewById(R.id.toggleApadrinhar);
        toggle3 = (ToggleButton) findViewById(R.id.toggleAjudar);

        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundColor(Color.parseColor("#ffd358"));
                } else {
                    buttonView.setBackgroundColor(Color.parseColor("#bdbdbd"));
                }
            }
        });
        toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundColor(Color.parseColor("#ffd358"));
                } else {
                    buttonView.setBackgroundColor(Color.parseColor("#bdbdbd"));
                }
            }
        });
        toggle3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundColor(Color.parseColor("#ffd358"));
                } else {
                    buttonView.setBackgroundColor(Color.parseColor("#bdbdbd"));
                }
            }
        });

    }
}
