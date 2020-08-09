package com.example.meuapp.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.meuapp.MyApp;

public class MainDB extends SQLiteOpenHelper {
    private static String NOMEDB = "AUGUSTODEVDB";
    private static int VERSAO = 3;
    public static String TABELA_PESSOA = "TABELA_PESSOA";

    private static MainDB instancia;

    public static MainDB getInstancia(){
        if(instancia == null)
            instancia = new MainDB();
        System.out.println("Conectado com sucesso!");
        return instancia;
    }
    private MainDB() {
        super(MyApp.getContext(), NOMEDB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
