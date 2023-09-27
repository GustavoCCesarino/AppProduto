package com.cesarino.appproduto.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.cesarino.appproduto.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static void inserir(Context contexto, Produto prod){
        Banco conn = new Banco(contexto);
        SQLiteDatabase db = conn.getWritableDatabase();

        //Uma forma de fazer
        /*db.execSQL("INSERT INTO produtos(nome, preco) VALUES" +
                "('"+prod.nome+"',"+prod.preco+")");*/

        //outra forma
        ContentValues valores = new ContentValues();
        valores.put("nome", prod.nome);
        valores.put("preco", prod.preco);

        db.insert("produtos",null, valores);
    }
    public static void editar(Context contexto, Produto prod){
        Banco conn = new Banco(contexto);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", prod.nome);
        valores.put("preco", prod.preco);

        db.update("produtos", valores,"id =" + prod.id, null);
    }
    public static void excluir(Context contexto, int idProd){
        Banco conn = new Banco(contexto);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.delete("produtos","id =" + idProd, null);
    }

    public static List<Produto> getProdutos(Context contexto){
        Banco conn = new Banco(contexto);
        SQLiteDatabase db = conn.getReadableDatabase();

        List<Produto> lista = new ArrayList<>();

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM produtos ORDER BY nome", null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();

                do{
                    Produto prod = new Produto();
                    prod.id = cursor.getInt(0);
                    prod.nome = cursor.getString(1);
                    prod.preco = cursor.getDouble(2);
                    lista.add(prod);
                }while(cursor.moveToNext());
            }
        }catch(Exception e){

        }


        return lista;
    }
    public static Produto getProdutoById(Context contexto, int idProd){
        Banco conn = new Banco(contexto);
        SQLiteDatabase db = conn.getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery("SELECT * FROM produtos WHERE id ="+ idProd, null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();

                Produto prod = new Produto();
                prod.id = cursor.getInt(0);
                prod.nome = cursor.getString(1);
                prod.preco = cursor.getDouble(2);

               return prod;
            }
        }catch(Exception e){

        }


        return null;
    }
}
