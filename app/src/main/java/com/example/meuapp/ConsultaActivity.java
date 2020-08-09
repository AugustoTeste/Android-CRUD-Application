package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.meuapp.crud.Create;
import com.example.meuapp.crud.Read;
import com.example.meuapp.model.Pessoa;
import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;

public class ConsultaActivity extends AppCompatActivity {
    private ArrayList<Pessoa> listaPessoas;
    private ListView lvPessoas;
    private ImageView btn_home;
    private EditText edt_searchPerson;
    private BottomAppBar btn_search, bottomAppBarHome;
    private int j = 0;
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        btn_search = findViewById(R.id.topAppBar);
        edt_searchPerson = findViewById(R.id.edt_searchPerson);
        bottomAppBarHome = findViewById(R.id.bottomAppBar);

        lvPessoas = findViewById(R.id.lvPessoas);
        new Create().createTable();
        listaPessoas();

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_searchPerson.setVisibility(View.VISIBLE);
            }
        });



        bottomAppBarHome.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.btn_home:
                        startActivity(new Intent(ConsultaActivity.this, HomeActivity.class));
                        return true;
                }
                return true;
            }
        });

        edt_searchPerson.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String personSearch = edt_searchPerson.getText().toString().trim();
            if(!personSearch.isEmpty()) {
                String[] usuarios = new String[listaPessoas.size()];
                for (j = 0; j < listaPessoas.size(); j++) {
                    if (listaPessoas.get(j).getUsuario().contains(personSearch)) {
                        usuarios[cont] = listaPessoas.get(j).getUsuario();
                        cont++;
                    }
                }
//              Criei outro vetor para não pegar valores null do vetor anterior
                String[] usuariosNova = new String[cont];
                for (j = 0; j < usuariosNova.length; j++) {
                    usuariosNova[j] = usuarios[j];
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        usuariosNova
                );
                lvPessoas.setAdapter(adapter);
                cont = 0;
            }else
                listaPessoas();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void listaPessoas(){
        int i = 0;
        listaPessoas = new ArrayList();
        Read read = new Read();
        listaPessoas =  read.getPessoas();
        String[] pessoas = new String[listaPessoas.size()];
        for (Pessoa p: listaPessoas) {
            System.out.println("Usuário: "+p.getUsuario());
            pessoas[i] = p.getUsuario();
            System.out.println("Setando "+p.getUsuario()+" no array");
            i++;
        }
        i = 0;
        for(String s : pessoas){
            System.out.println("Verificando objeto: "+s);
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                pessoas
        );
        lvPessoas.setAdapter(adapter);

        lvPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Nome "+i+" selecionado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
