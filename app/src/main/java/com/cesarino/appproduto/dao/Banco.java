package com.cesarino.appproduto.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB ="AppProd";

    public Banco(Context contexto){
        super(contexto, NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS produtos (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
                "nome TEXT ," +
                "preco DOUBLE);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
