package com.example.database_meusregistros;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper{

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1;

    //livros
    private static final String TABLE_NOME_livro = "meus_livros";
    private static final String COLUMN_ID_livro = "livro_id";
    private static final String COLUMN_TITULO_livro = "livro_titulo";
    private static final String COLUMN_AUTOR_livro = "livro_autor";
    private static final String COLUMN_PAGINAS_livro = "livro_paginas";

    //HQs
    private static final String TABLE_NOME_hq = "minhas_hqs";
    private static final String COLUMN_ID_hq = "hq_id";
    private static final String COLUMN_TITULO_hq = "hq_titulo";
    private static final String COLUMN_AUTOR_hq = "hq_autor";
    private static final String COLUMN_PAGINAS_hq = "hq_paginas";

    //mangás
    private static final String TABLE_NOME_manga = "meus_mangas";
    private static final String COLUMN_ID_manga = "manga_id";
    private static final String COLUMN_TITULO_manga = "manga_titulo";
    private static final String COLUMN_AUTOR_manga = "manga_autor";
    private static final String COLUMN_PAGINAS_manga = "manga_paginas";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //livros
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NOME_livro +
                " (" + COLUMN_ID_livro + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITULO_livro + " TEXT, " +
                COLUMN_AUTOR_livro + " TEXT, " +
                COLUMN_PAGINAS_livro + " INTEGER);";
        db.execSQL(query);

        String query2 = "CREATE TABLE " + TABLE_NOME_hq +
                " (" + COLUMN_ID_hq + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITULO_hq + " TEXT, " +
                COLUMN_AUTOR_hq + " TEXT, " +
                COLUMN_PAGINAS_hq + " INTEGER);";
        db.execSQL(query2);

        String query3 = "CREATE TABLE " + TABLE_NOME_manga +
                " (" + COLUMN_ID_manga + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITULO_manga + " TEXT, " +
                COLUMN_AUTOR_manga + " TEXT, " +
                COLUMN_PAGINAS_manga + " INTEGER);";
        db.execSQL(query3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOME_livro);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOME_hq);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOME_manga);
        onCreate(db);
    }

    void addLivro(String titulo, String autor, int paginas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITULO_livro, titulo);
        cv.put(COLUMN_AUTOR_livro, autor);
        cv.put(COLUMN_PAGINAS_livro, paginas);
        long result = db.insert(TABLE_NOME_livro,null, cv);
        if(result == -1){
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Adicionado com Sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllDataLivro(){
        String query = "SELECT * FROM " + TABLE_NOME_livro;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateDataLivro(String row_id, String titulo, String autor, String paginas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITULO_livro, titulo);
        cv.put(COLUMN_AUTOR_livro, autor);
        cv.put(COLUMN_PAGINAS_livro, paginas);

        long result = db.update(TABLE_NOME_livro, cv, "livro_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Editado com Sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRowLivro(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NOME_livro, "livro_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Deletado com sucesso.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllDataLivro(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NOME_livro);
    }

    //HQs

    public void addHQ(String titulo, String autor, int paginas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITULO_hq, titulo);
        cv.put(COLUMN_AUTOR_hq, autor);
        cv.put(COLUMN_PAGINAS_hq, paginas);
        long result = db.insert(TABLE_NOME_hq,null, cv);
        if(result == -1){
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Adicionado com Sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllDataHQ(){
        String query = "SELECT * FROM " + TABLE_NOME_hq;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateDataHQ(String row_id, String titulo, String autor, String paginas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITULO_hq, titulo);
        cv.put(COLUMN_AUTOR_hq, autor);
        cv.put(COLUMN_PAGINAS_hq, paginas);

        long result = db.update(TABLE_NOME_hq, cv, "hq_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Editado com Sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRowHQ(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NOME_hq, "hq_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Deletado com Sucesso.", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteAllDataHQ(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NOME_hq);
    }

    //Mangás

    public void addManga(String titulo, String autor, int paginas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITULO_manga, titulo);
        cv.put(COLUMN_AUTOR_manga, autor);
        cv.put(COLUMN_PAGINAS_manga, paginas);
        long result = db.insert(TABLE_NOME_manga,null, cv);
        if(result == -1){
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Adicionado com Sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllDataManga(){
        String query = "SELECT * FROM " + TABLE_NOME_manga;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateDataManga(String row_id, String titulo, String autor, String paginas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITULO_manga, titulo);
        cv.put(COLUMN_AUTOR_manga, autor);
        cv.put(COLUMN_PAGINAS_manga, paginas);

        long result = db.update(TABLE_NOME_manga, cv, "manga_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Erro", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Editado com Sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRowManga(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NOME_manga, "manga_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Erro ao deletar.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Deletado com sucesso.", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteAllDataManga(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NOME_manga);
    }

}
