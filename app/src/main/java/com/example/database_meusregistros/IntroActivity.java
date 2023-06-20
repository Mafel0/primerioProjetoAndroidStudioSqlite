package com.example.database_meusregistros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.database_meusregistros.HQs_.MainActivity_hqs;
import com.example.database_meusregistros.Mangas_.MainActivity_mangas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class IntroActivity extends AppCompatActivity {

    Button livro_button;
    Button hq_button;
    Button manga_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        livro_button = findViewById(R.id.livro_button);
        livro_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        hq_button = findViewById(R.id.hq_button);
        hq_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity_hqs.class);
                startActivity(intent);
            }
        });

        manga_button = findViewById(R.id.manga_button);
        manga_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity_mangas.class);
                startActivity(intent);
            }
        });
    }


}