package com.example.meauapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;


public class Cadastro extends AppCompatActivity {
    private EditText Nome, Idade, Email, Estado, Cidade, Endereco, Telefone, Nome_Usuario, Senha, Confirmacao_Senha;
    private Button Fazer_Cadastro,Foto_perfil;
    private DatabaseReference reff;
    private Member member;
    private static final int GALLERY_REQUEST_CODE = 1;
    private FirebaseStorage storage;

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
        /*Foto_Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickFromGallery();
            }
        });
        //Banco para armazenar Foto
        storage = FirebaseStorage.getInstance();
        final StorageReference reff2 = storage.getReference();*/

        //Data base para os dados
        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        member = new Member();
        Fazer_Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                reff.push().setValue(member);
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

                //Toast.makeText(datainsert.this, text="Dados inseridos com sucesso", Toast:L);
            }
        });
    }
    /*private void pickFromGallery(){
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
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case GALLERY_REQUEST_CODE:
                    //data.getData returns the content URI for the selected Image
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };

                    Cursor cursor = getContentResolver().query(selectedImage,
                            filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    Foto = picturePath;
                    break;
            }

    }*/


}
