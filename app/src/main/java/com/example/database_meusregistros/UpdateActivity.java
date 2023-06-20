package com.example.database_meusregistros;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity{
    EditText titulo_input, autor_input, paginas_input;
    Button update_button, delete_button;

    String id, titulo, autor, paginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        titulo_input = findViewById(R.id.titulo_input2);
        autor_input = findViewById(R.id.autor_input2);
        paginas_input = findViewById(R.id.paginas_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //Primeiro
        getAndSetIntentData();

        //Set actionbar titulo depois do getAndSetIntentData
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(titulo);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                titulo = titulo_input.getText().toString().trim();
                autor = autor_input.getText().toString().trim();
                paginas = paginas_input.getText().toString().trim();
                myDB.updateDataLivro(id, titulo, autor, paginas);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("titulo") &&
                getIntent().hasExtra("autor") && getIntent().hasExtra("paginas")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            titulo = getIntent().getStringExtra("titulo");
            autor = getIntent().getStringExtra("autor");
            paginas = getIntent().getStringExtra("paginas");

            //Setting Intent Data
            titulo_input.setText(titulo);
            autor_input.setText(autor);
            paginas_input.setText(paginas);
            Log.d("stev", titulo+" "+autor+" "+paginas);
        }else{
            Toast.makeText(this, "Vazio.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Deletar " + titulo + " ?");
        builder.setMessage("Você tem certeza que deseja deletar " + titulo + " ?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRowLivro(id);
                finish();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

}