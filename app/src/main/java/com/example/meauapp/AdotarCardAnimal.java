package com.example.meauapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AdotarCardAnimal extends Fragment{

    ImageView imagem_animal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adotar_card, container, false);
        imagem_animal = (ImageView) v.findViewById(R.id.imgAnimal);
        return v;
    }

    public void ImageClick(View v){
        Intent Login2 = new Intent(AdotarCardAnimal.this, Login2.class);
        startActivity(Login2);
    }


}
