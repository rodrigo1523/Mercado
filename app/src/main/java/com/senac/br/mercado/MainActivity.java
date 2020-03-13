package com.senac.br.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.senac.br.mercado.Modolo.produto;
import com.senac.br.mercado.dao.produtoDAO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produtoDAO dao = new produtoDAO(this);
        List<produto> produtos = dao.listar();



        ListView listiView = findViewById(R.id.listViewProdutos);

        ListAdapter listAdapter = new ArrayAdapter<produto>(this, android.R.layout.simple_list_item_1, produtos);

        listiView.setAdapter(listAdapter);

        listiView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent Cad = new Intent(MainActivity.this, CadastroProdutoActivity.class);
                startActivity(Cad);
            }
        });


    }

    public void cadastrarProduto(View view){
        Intent Cad = new Intent(this, CadastroProdutoActivity.class);
        startActivity(Cad);
    }
}
