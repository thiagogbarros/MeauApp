package com.example.meauapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage.FirebaseStorage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.function.Function;


public class Cadastro extends AppCompatActivity {
    private EditText Nome, Idade, Email, Estado, Cidade, Endereco, Telefone, Nome_Usuario, Senha, Confirmacao_Senha;
    private Button Fazer_Cadastro,Foto_perfil;
    private DatabaseReference reff;
    private FirebaseAuth mAuth;
    private Member member;
    private String email,senha,csenha,imageURL;
    private static final int GALLERY_REQUEST_CODE = 1;
    public  Uri image;
    //private FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        final EditText Nome=(EditText)findViewById(R.id.Nome);
        final EditText Idade=(EditText)findViewById(R.id.Idade);
        final EditText Email=(EditText)findViewById(R.id.Email);
        final EditText Estado=(EditText)findViewById(R.id.Estado);
        final EditText Cidade=(EditText)findViewById(R.id.Cidade);
        final EditText Endereco=(EditText)findViewById(R.id.Endereco);
        final EditText Telefone=(EditText)findViewById(R.id.Telefone);
        final EditText Nome_Usuario=(EditText)findViewById(R.id.Nome_Usuario);
        final EditText Senha=(EditText)findViewById(R.id.Senha);
        final EditText Confirmacao_Senha=(EditText)findViewById(R.id.Confirmacao_Senha);
        final Button Fazer_Cadastro =(Button)findViewById(R.id.FazerCadastro);
        final Button Foto_Perfil = (Button)findViewById(R.id.FotodePerfil);

        //Pegando foto de perfil
        Foto_Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickFromGallery();
            }
        });
        //Banco para armazenar Foto
        //storage = FirebaseStorage.getInstance();
        //final StorageReference reff2 = storage.getReference();*/

        //Data base para os dados


        reff = FirebaseDatabase.getInstance().getReference().child("Usuario");
        mAuth = FirebaseAuth.getInstance();
        member = new Member();
        Fazer_Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString().trim();
                String senha = Senha.getText().toString().trim();
                String csenha = Confirmacao_Senha.getText().toString().trim();
                int age= Integer.parseInt(Idade.getText().toString().trim());
                member.setNome(Nome.getText().toString().trim());
                member.setIdade(age);
                member.setEmail(Email.getText().toString().trim());
                member.setEstado(Estado.getText().toString().trim());
                member.setCidade(Cidade.getText().toString().trim());
                member.setEndereco(Endereco.getText().toString().trim());
                member.setTelefone(Telefone.getText().toString().trim());
                member.setNome_Usuario(Nome_Usuario.getText().toString().trim());
                member.setSenha(Senha.getText().toString().trim());
                member.setConfirmacao_Senha(Confirmacao_Senha.getText().toString().trim());


                //reff.push().setValue(member);


                /*Uri file = Uri.fromFile(new File(Foto));
                StorageReference riversRef = reff2.child("FotosPerfil/");
                UploadTask uploadTask = riversRef.putFile(file);
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
                });*/
                cadastro(email,senha);
                includesForUploadFiles(image);

                /*FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageRef = storage.getReference();
                StorageReference Ref = storageRef.child("Perfil/"+image.getLastPathSegment());
                storageRef.child("Perfil/"+image.getLastPathSegment()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        imageURL = uri.toString();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle any errors
                    }
                });

                member.setFotoPerfil(imageURL);*/
                reff.push().setValue(member);

                Context context = getApplicationContext();
                CharSequence text = "Cadastro feito com sucesso!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                finish();

            }
        });
    }
    public void includesForUploadFiles(Uri file){
        FirebaseStorage storage = FirebaseStorage.getInstance();

        // [START upload_create_reference]
        // Create a storage reference from our app
        StorageReference storageRef = storage.getReference();
        //Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
        StorageReference Ref = storageRef.child("Perfil/"+file.getLastPathSegment());
        UploadTask uploadTask = Ref.putFile(file);

        // Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

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
    public void cadastro(String email,String senha){
        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            Context context = getApplicationContext();
                            CharSequence text = "Cadastro falhou!";
                            int duration = Toast.LENGTH_LONG;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            return;
                        }

                    }
                });
    }

}
