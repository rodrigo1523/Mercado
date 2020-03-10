package com.senac.br.mercado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.senac.br.mercado.Modolo.produto;
import com.senac.br.mercado.dao.produtoDAO;

public class CadastroProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);
    }

    public void telaInicial(View view){

        EditText nome = findViewById(R.id.nomeEditText);
        EditText quantidade = findViewById(R.id.quantidadeEditText);
        EditText preco = findViewById(R.id.precoEditText);

        produto produto = new produto(nome.getText().toString(),
            Integer.parseInt(quantidade.getText().toString()),
            preco.getText().toString());

       produtoDAO dao = new produtoDAO();
       dao.salvar(produto);

        Intent Cad = new Intent(this, MainActivity.class);
        startActivity(Cad);

    }
}
