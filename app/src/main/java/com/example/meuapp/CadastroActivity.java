package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.meuapp.crud.Create;
import com.example.meuapp.crud.Update;
import com.example.meuapp.model.Pessoa;

import java.util.ArrayList;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edt_nomeCompleto;
    private EditText edt_cpf;
    private EditText edt_endereco;
    private EditText edt_dataNasc;
    private EditText edt_cidade;
    private EditText edt_estado;
    private EditText edt_email;
    private EditText edt_telefone;
    private EditText edt_usuario;
    private EditText edt_senha;
    private ListView lvPessoas;
    private ArrayList<Pessoa> listaPessoas;
    private ImageView btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        edt_nomeCompleto = findViewById(R.id.edt_nomeCompleto);
        edt_cpf = findViewById(R.id.edt_cpf);
        edt_endereco = findViewById(R.id.edt_endereco);
        edt_dataNasc = findViewById(R.id.edt_dataNasc);
        edt_telefone = findViewById(R.id.edt_telefone);
//        edt_cidade = (EditText) findViewById(R.id.edt_estado);
//        edt_estado = (EditText) findViewById(R.id.edt_cidade);
        edt_email = findViewById(R.id.edt_email);
        edt_usuario = findViewById(R.id.edt_usuario);
        edt_senha = findViewById(R.id.edt_senha);
        lvPessoas = findViewById(R.id.lvPessoas);
        btn_home = findViewById(R.id.btn_home);

        findViewById(R.id.btn_salvar).setOnClickListener(this);
//        findViewById(R.id.btn_limpar).setOnClickListener(this);
        findViewById(R.id.btn_home).setOnClickListener(this);
        new Create().createTable();
    }
    @Override
    public void onClick(View view){
        int id = view.getId();
        if(id == R.id.btn_salvar)
            addPessoa();
//        else if(id == R.id.btn_limpar)
//            limparCampos();
        else if(id == R.id.btn_home)
            _home();
    }

    public void addPessoa(){
        Pessoa p = new Pessoa();
        p.setNomeCompleto(edt_nomeCompleto.getText().toString());
        p.setCpf(edt_cpf.getText().toString());
        p.setEndereco(edt_endereco.getText().toString());
        p.setDataNasc(edt_dataNasc.getText().toString());
        p.setTelefone(edt_telefone.getText().toString());
//        p.setEstado(edt_estado.getText().toString());
//        p.setCidade(edt_cidade.getText().toString());
        p.setEmail(edt_email.getText().toString());
        p.setUsuario(edt_usuario.getText().toString());
        p.setSenha(edt_senha.getText().toString());
        if (new Update().addPessoa(p)) {
            Toast.makeText(this, edt_usuario.getText().toString()+" foi inserido(a) com sucesso!", Toast.LENGTH_SHORT).show();
            limparCampos();
        } else {
            Toast.makeText(this, "Erro ao inserir pessoa", Toast.LENGTH_SHORT).show();
        }
    }

    public void limparCampos(){
        edt_nomeCompleto.setText("");
        edt_cpf.setText("");
        edt_endereco.setText("");
        edt_dataNasc.setText("");
        edt_telefone.setText("");
//        edt_estado.setText("");
//        edt_cidade.setText("");
        edt_email.setText("");
        edt_usuario.setText("");
        edt_senha.setText("");
//        Toast.makeText(getApplicationContext(), "Limpou tela!", Toast.LENGTH_SHORT).show();
    }

    public void _home(){
        startActivity(new Intent(CadastroActivity.this, HomeActivity.class));
    }
}
