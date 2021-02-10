package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.meuapp.crud.Create;
import com.example.meuapp.crud.Read;
import com.example.meuapp.model.Pessoa;

import java.util.ArrayList;


public class AtualizaActivity extends AppCompatActivity {
    private ListView lvEditPessoas;
    private String[] pessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualiza);

        lvEditPessoas = findViewById(R.id.lvEditPessoas);
        new Create().createTable();
        listaPessoas();

        lvEditPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Read read = new Read();
                Pessoa pessoa = new Pessoa();
                pessoa = read.getPessoaById(lvEditPessoas.getItemAtPosition(i).toString());

                Intent intent = new Intent(AtualizaActivity.this, EditaPessoaActivity.class);
                intent.putExtra("nome_completo" , pessoa.getNomeCompleto());
                intent.putExtra("cpf" , pessoa.getCpf());
                intent.putExtra("endereco", pessoa.getEndereco());
                intent.putExtra("data_nasc" , pessoa.getDataNasc());
                intent.putExtra("telefone" , pessoa.getTelefone());
                intent.putExtra("estado", pessoa.getEstado());
                intent.putExtra("cidade" , pessoa.getCidade());
                intent.putExtra("email" , pessoa.getEmail());
                intent.putExtra("usuario", pessoa.getUsuario());
                intent.putExtra("senha", pessoa.getSenha());
                startActivity(intent);
            }
        });
    }

    public void listaPessoas(){
        ArrayList<Pessoa> listaPessoas = new ArrayList();
        Read read = new Read();
        listaPessoas = read.getPessoas();
        pessoas = new String[listaPessoas.size()];
        for(int i = 0; i < listaPessoas.size(); i++){
            pessoas[i] = listaPessoas.get(i).getUsuario();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                pessoas
        );

        lvEditPessoas.setAdapter(adapter);
    }
}
