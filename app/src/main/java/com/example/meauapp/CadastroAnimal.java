package com.example.meauapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class CadastroAnimal extends AppCompatActivity {
    private Button FotodoAnimal, Colocar_para_Adocao;
    private ToggleButton toggle1,toggle2,toggle3;
    private EditText Nome_animal, Doencas_animal, SobreaAnimal;
    private RadioGroup Sexo, Especie, Idade, Porte;
    private RadioButton Sexoid, Especieid, Idadeid, Porteid;
    private CheckBox Bricalhao, timido, calmo, guarda, amoroso, preguiçoso, vacinado, vermifugado, castrado, doente;
    private CheckBox Termo_adocao,Fotocasa, Visita, Acompanhamento, ummes,tresmeses, seismeses;
    private DatabaseReference reff;
    private Animal animal;
    private ArrayList<String> Temperamento,Saude, Exigencias;
    // int Acao=0; //1-adocao, 2- apadrinhacao, 3 - ajuda
    private static final int GALLERY_REQUEST_CODE = 1;
    public  Uri image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_animal);

        //Adocao, apadrinhacao ou ajuda
        toggle1 = (ToggleButton) findViewById(R.id.toggleAdocao);
        toggle2 = (ToggleButton) findViewById(R.id.toggleApadrinhar);
        toggle3 = (ToggleButton) findViewById(R.id.toggleAjudar);
        //Caracteristicas do animal
        final EditText Nome_animal = (EditText) findViewById(R.id.NomeAnimal);
        final EditText Doencas_animal = (EditText) findViewById(R.id.DoencaAnimal);
        final EditText SobreaAnimal = (EditText) findViewById(R.id.Sobreoanimal);
        final RadioGroup Sexo = (RadioGroup) findViewById(R.id.Sexo1);
        final RadioGroup Especie = (RadioGroup) findViewById(R.id.Especie1);
        final RadioGroup Porte = (RadioGroup) findViewById(R.id.Porte1);
        final RadioGroup Idade = (RadioGroup) findViewById(R.id.Idade1);
        final Button Colocar_para_Adocao = (Button) findViewById(R.id.FazerCadastro);
        final CheckBox Brincalhao = (CheckBox) findViewById(R.id.Brincalhao);
        final CheckBox timido = (CheckBox) findViewById(R.id.Timido);
        final CheckBox calmo = (CheckBox) findViewById(R.id.Calmo);
        final CheckBox guarda = (CheckBox) findViewById(R.id.Guarda);
        final CheckBox amoroso = (CheckBox) findViewById(R.id.Amoroso);
        final CheckBox preguicoso = (CheckBox) findViewById(R.id.Preguicoso);
        final CheckBox vacinado = (CheckBox) findViewById(R.id.vacinado);
        final CheckBox vermifugado = (CheckBox) findViewById(R.id.Vermifugado);
        final CheckBox castrado = (CheckBox) findViewById(R.id.Castrado);
        final CheckBox doente = (CheckBox) findViewById(R.id.Doente);
        final CheckBox Termo_adocao = (CheckBox) findViewById(R.id.TermoAdocao);
        final CheckBox Fotocasa = (CheckBox) findViewById(R.id.FotoCasa);
        final CheckBox Visita = (CheckBox) findViewById(R.id.VisitaPrevia);
        final CheckBox Acompanhamento = (CheckBox) findViewById(R.id.Acompanhamentopos);
        final CheckBox ummes = (CheckBox) findViewById(R.id.ummes);
        final CheckBox tresmeses = (CheckBox) findViewById(R.id.tresmeses);
        final CheckBox seismeses= (CheckBox) findViewById(R.id.seismeses);
        final Button FotodoAnimal = (Button) findViewById(R.id.Fotodo
                Animal);

        reff = FirebaseDatabase.getInstance().getReference().child("Animal");
        animal = new Animal();
        Temperamento = new ArrayList<>(6);
        Saude = new ArrayList<>(4);
        Exigencias = new ArrayList<>(5);

        FotodoAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickFromGallery();
            }
        });

        toggle1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundColor(Color.parseColor("#ffd358"));
                    //Acao = 1;
                } else {
                    buttonView.setBackgroundColor(Color.parseColor("#bdbdbd"));
                }
            }
        });
        toggle2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundColor(Color.parseColor("#ffd358"));
                    //Acao = 2;
                } else {
                    buttonView.setBackgroundColor(Color.parseColor("#bdbdbd"));
                }
            }
        });
        toggle3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setBackgroundColor(Color.parseColor("#ffd358"));
                    //Acao = 3;
                } else {
                    buttonView.setBackgroundColor(Color.parseColor("#bdbdbd"));
                }
            }
        });


        Colocar_para_Adocao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animal.setNomeAnimal(Nome_animal.getText().toString().trim());
                //Espécie
                int selectedId = Especie.getCheckedRadioButtonId();
                Especieid = (RadioButton) findViewById(selectedId);
                animal.setEspecie(Especieid.getText().toString().trim());
                //Sexo
                int selectedId2 = Sexo.getCheckedRadioButtonId();
                Sexoid = (RadioButton) findViewById(selectedId2);
                animal.setSexo(Sexoid.getText().toString().trim());
                //Porte
                int selectedId3 = Porte.getCheckedRadioButtonId();
                Porteid = (RadioButton) findViewById(selectedId3);
                animal.setPorte(Porteid.getText().toString().trim());
                //Idade
                int selectedId4 = Idade.getCheckedRadioButtonId();
                Idadeid = (RadioButton) findViewById(selectedId4);
                animal.setIdade(Idadeid.getText().toString().trim());
                //Temperamento
                if(Brincalhao.isChecked()){
                    Temperamento.add("Brincalhão");
                }
                if(timido.isChecked()){
                    Temperamento.add("Tímido");
                }
                if(calmo.isChecked()){
                    Temperamento.add("Calmo");
                }
                if(guarda.isChecked()){
                    Temperamento.add("Guarda");
                }
                if(amoroso.isChecked()){
                    Temperamento.add("Amoroso");
                }
                if(preguicoso.isChecked()){
                    Temperamento.add("Preguiçoso");
                }
                if(vacinado.isChecked()){
                    Saude.add("Vacinado");
                }
                if(vermifugado.isChecked()){
                    Saude.add("Vermifugado");
                }
                if(castrado.isChecked()){
                    Saude.add("Castrado");
                }
                if(doente.isChecked()){
                    Saude.add("Doente");
                }
                if(Termo_adocao.isChecked()){
                    Exigencias.add("Termo de Adoção");
                }
                if(Fotocasa.isChecked()){
                    Exigencias.add("Fotos da Casa");
                }
                if(Acompanhamento.isChecked()){
                    Exigencias.add("Acompanhamento pós adoção");
                    if(ummes.isChecked()){
                        Exigencias.add("1 mês");
                    }
                    if(tresmeses.isChecked()){
                        Exigencias.add("3 meses");
                    }
                    if(seismeses.isChecked()){
                        Exigencias.add("6 meses");
                    }
                }
                animal.setExigencias(Exigencias);
                animal.setTemperamento(Temperamento);
                animal.setSaude(Saude);
                animal.setDoencas(Doencas_animal.getText().toString().trim());
                animal.setSobreAnimal(SobreaAnimal.getText().toString().trim());

                includesForUploadFiles(image);
                reff.push().setValue(animal);

                Context context = getApplicationContext();
                CharSequence text = "Animal cadastrado com sucesso!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                startActivity(new Intent(CadastroAnimal.this,Introducao.class));
            }
        });
    }
    public void includesForUploadFiles(Uri file){
        FirebaseStorage storage = FirebaseStorage.getInstance();

        // [START upload_create_reference]
        // Create a storage reference from our app
        StorageReference storageRef = storage.getReference();
        //Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
        StorageReference riversRef = storageRef.child("Animais/"+file.getLastPathSegment());
        UploadTask uploadTask = riversRef.putFile(file);

        // Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
            }
        });
    }
    private void pickFromGallery(){
        //Create an Intent with action as ACTION_PICK
        Intent intent=new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        // Launching the Intent
        startActivityForResult(intent,GALLERY_REQUEST_CODE);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case GALLERY_REQUEST_CODE:
                    //data.getData returns the content URI for the selected Image
                    Uri selectedImage = data.getData();
                    image = selectedImage;
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    break;
            }

    }

}
