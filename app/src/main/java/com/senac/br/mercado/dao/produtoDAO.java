package com.senac.br.mercado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.senac.br.mercado.Modolo.produto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class produtoDAO {

    private SqLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    public produtoDAO(Context context){this.sqLiteHelper = new SqLiteHelper(context);}


    public void salvar (produto produto){
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("NOME", produto.getNome());
        values.put("PRECO", produto.getPreco());
        values.put("QUANTIDADE", produto.getQuantidades());


        sqLiteDatabase.insert("PRODUTO", null, values);
        sqLiteDatabase.close();


    }

    public List<produto> listar(){
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        String sql = "SELECT * FROM PRODUTO;";
        Cursor c = sqLiteDatabase.rawQuery(sql,null);
        List<produto> produtos = new ArrayList<>();

        while ( c.moveToNext()){
            produto produto = new produto();
            produto.setId(c.getInt(c.getColumnIndex("ID")));
            produto.setNome(c.getString(c.getColumnIndex("NOME")));
            produto.setPreco(c.getString(c.getColumnIndex("PRECO")));
            produto.setQuantidades(c.getInt(c.getColumnIndex("QUANTIDADE")));

            produtos.add(produto);

        }

        return produtos;

    }

    public void excluir(produto prod) {

        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        sqLiteDatabase.delete("PRODUTO", "ID = ?", new String[]{String.valueOf(prod.getId())});
    }
}

