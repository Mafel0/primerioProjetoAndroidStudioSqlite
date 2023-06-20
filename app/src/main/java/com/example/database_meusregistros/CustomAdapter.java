package com.example.database_meusregistros;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList livro_id, livro_titulo, livro_autor, livro_paginas;

    public CustomAdapter(Activity activity, Context context, ArrayList livro_id, ArrayList livro_titulo, ArrayList livro_autor,
                         ArrayList livro_paginas){
        this.activity = activity;
        this.context = context;
        this.livro_id = livro_id;
        this.livro_titulo = livro_titulo;
        this.livro_autor = livro_autor;
        this.livro_paginas = livro_paginas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.livro_id_txt.setText(String.valueOf(livro_id.get(position)));
        holder.livro_titulo_txt.setText(String.valueOf(livro_titulo.get(position)));
        holder.livro_autor_txt.setText(String.valueOf(livro_autor.get(position)));
        holder.livro_paginas_txt.setText(String.valueOf(livro_paginas.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(livro_id.get(position)));
                intent.putExtra("titulo", String.valueOf(livro_titulo.get(position)));
                intent.putExtra("autor", String.valueOf(livro_autor.get(position)));
                intent.putExtra("paginas", String.valueOf(livro_paginas.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        //return 0;
        return livro_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView livro_id_txt, livro_titulo_txt, livro_autor_txt, livro_paginas_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            livro_id_txt = itemView.findViewById(R.id.livro_id_txt);
            livro_titulo_txt = itemView.findViewById(R.id.livro_titulo_txt);
            livro_autor_txt = itemView.findViewById(R.id.livro_autor_txt);
            livro_paginas_txt = itemView.findViewById(R.id.livro_paginas_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            /*
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);

             */
        }

    }
}
