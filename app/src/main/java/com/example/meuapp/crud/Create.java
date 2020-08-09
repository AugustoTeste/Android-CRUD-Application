package com.example.meuapp.crud;

import android.database.sqlite.SQLiteDatabase;

public class Create {
    public void createTable(){
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        String colunas = "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "NOME_COMPLETO TEXT, CPF TEXT, ENDERECO TEXT, DATA_NASC TEXT, " +
                "TELEFONE TEXT, ESTADO TEXT, CIDADE TEXT, EMAIL TEXT, USUARIO TEXT, SENHA TEXT)";
        String query = "CREATE TABLE IF NOT EXISTS "+MainDB.TABELA_PESSOA+colunas;

        db.execSQL(query);
    }
}
