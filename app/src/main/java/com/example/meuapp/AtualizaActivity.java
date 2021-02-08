package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class AtualizaActivity extends AppCompatActivity {
    private ListView lvTest;
    private ArrayList<String> lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualiza);

        lvTest = (ListView) findViewById(R.id.idListsTest);
        lista = carregaLista();
        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                lista);
        lvTest.setAdapter(adapter);
    }

    public ArrayList carregaLista(){
        lista = new ArrayList<String>();
        for(int i = 0; i < 15; i++) {
            lista.add("Augusto " + i);
        }
        return lista;
    }
}
