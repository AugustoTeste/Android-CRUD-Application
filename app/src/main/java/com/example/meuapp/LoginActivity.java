package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meuapp.crud.Create;
import com.example.meuapp.crud.Read;
import com.example.meuapp.model.Pessoa;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private ArrayList<Pessoa> listaPessoas;
    private EditText edtLogin;
    private EditText edtSenha;
    private Button btnLogin;
    private Button btnLimpar;
    private Button btnSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogin);
        btnLimpar = findViewById(R.id.btnLimpar);

        new Create().createTable();

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificaPessoa();
            }
        });
    }
    public void verificaPessoa(){
        String nome = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();
        if(nome.equals("") || senha.equals("")) {
            System.out.println("Nome e(ou) senha vazio(s)!");
            Toast.makeText(this, "Insira usuário e senha!", Toast.LENGTH_SHORT).show();
        }else {
            if(nome.equals("dev.augusto") && senha.equals("1234"))
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            else
                Toast.makeText(this, "Usuário e/ou Senha inválido(a)!", Toast.LENGTH_SHORT).show();
//            listaPessoas = new ArrayList();
//            try {
//                Read read = new Read();
//                listaPessoas = read.getPessoas();
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            for (Pessoa p : listaPessoas) {
//                System.out.println("Usuário: " + p.getUsuario());
//                System.out.println("Senha: " + p.getSenha());
//                if (p.getUsuario().equals(nome) && p.getSenha().equals(senha)) {
//                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
//                }else
//                    Toast.makeText(this, "Usuário e/ou Senha inválido(a)!", Toast.LENGTH_SHORT).show();
//                }
            }
    }

    public void limpar(){
        edtLogin.setText("");
        edtSenha.setText("");
    }
}
