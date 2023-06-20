package com.example.database_meusregistros.Mangas_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.database_meusregistros.HQs_.AddActivity_hqs;
import com.example.database_meusregistros.MyDatabaseHelper;
import com.example.database_meusregistros.R;

public class AddActivity_mangas extends AppCompatActivity {

    EditText titulo_input, autor_input, paginas_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mangas);

        titulo_input = findViewById(R.id.titulo_input);
        autor_input = findViewById(R.id.autor_input);
        paginas_input = findViewById(R.id.paginas_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity_mangas.this);
                myDB.addManga(titulo_input.getText().toString().trim(),
                        autor_input.getText().toString().trim(),
                        Integer.valueOf(paginas_input.getText().toString().trim()));
            }
        });
    }
}