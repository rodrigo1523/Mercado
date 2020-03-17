package com.senac.br.mercado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        listiView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final produto prod = (produto) parent.getItemAtPosition(position);

                    AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                    //adb.setView(Main.this);
                    adb.setTitle("Certeza que Deseja Excluir");
                    adb.setIcon(android.R.drawable.ic_dialog_alert);
                    adb.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            produtoDAO dao = new produtoDAO(MainActivity.this);
                            dao.excluir(prod);

                            Toast.makeText(MainActivity.this, "Item excluido com sucesso", Toast.LENGTH_SHORT).show();
                            Intent Cad = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(Cad);
                            Toast.makeText(getApplicationContext(), "Sim", Toast.LENGTH_LONG).show();
                        }
                    });

                    adb.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "Não", Toast.LENGTH_LONG).show();
                            //finish();
                        }
                    });

                    AlertDialog alertDialog = adb.create();
                    alertDialog.show();


                return true;
            }
        });

    }

    public void cadastrarProduto(View view){
        Intent Cad = new Intent(this, CadastroProdutoActivity.class);
        startActivity(Cad);
    }
}
