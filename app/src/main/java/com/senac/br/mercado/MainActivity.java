package com.senac.br.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> produtos = new ArrayList<>();

        produtos.add("Café");
        produtos.add("Coca-Cola");
        produtos.add("Bolachas");
        produtos.add("Fanta");
        produtos.add("Fandangos");

        ListView listiView = findViewById(R.id.listViewProdutos);

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, produtos);

        listiView.setAdapter(listAdapter);





    }

    public void cadastrarProduto(View view){
        Intent Cad = new Intent(this, CadastroProdutoActivity.class);
        startActivity(Cad);
    }
}
