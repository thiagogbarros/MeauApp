package com.example.meauapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdotarCardAnimal extends Fragment{

    ImageView imagem_animal;
    TextView t;
    private DatabaseReference mDatabase;
    public String doencas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adotar_card, container, false);
        imagem_animal = (ImageView) v.findViewById(R.id.imgAnimal);
        /*imagem_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent PaginaAnimal = new Intent(getActivity(), PaginaAnimal.class);
                startActivity(PaginaAnimal);
            }
        });*/
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Animal");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    doencas = ds.child("doencas").getValue(String.class);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        mDatabase.addListenerForSingleValueEvent(valueEventListener);
        final TextView t = (TextView)v.findViewById(R.id.leftText);
        t.setText(doencas);
        return v;
    }






}
