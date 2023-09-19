package com.cesarino.appproduto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNome, etPreco;
    private Button botaoSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = (EditText) findViewById(R.id.etNome); //(EditText) era preciso nas APIs antigas
        etPreco = findViewById(R.id.etPreco);
        botaoSalvar = findViewById(R.id.btSalvar);// o id é o mesmo que está no activity_main.xml

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }

    private void salvar(){
        String nome = etNome.getText().toString();
        String sPreco = etPreco.getText().toString();
        if(sPreco.isEmpty()){

            Toast.makeText(this,"Preço inválido!", Toast.LENGTH_LONG).show();

        }else if (nome.isEmpty()) {

            Toast.makeText(this,"Campo Nome é obrigatório!", Toast.LENGTH_LONG).show();

        }else{

            double preco = Double.parseDouble(sPreco);
            String mensagem = "Produto: "+ nome + "\n Preço: " + preco + "\n\n Cadastrado com sucesso!";

            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        }

    }
}