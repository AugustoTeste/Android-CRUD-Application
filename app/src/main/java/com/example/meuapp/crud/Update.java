package com.example.meuapp.crud;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.meuapp.model.Pessoa;

public class Update {
    public boolean addPessoa(Pessoa pessoa){
        SQLiteDatabase db = MainDB.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();
        System.out.println("Criando content values...");

        cv.put("NOME_COMPLETO", pessoa.getNomeCompleto());
        cv.put("CPF", pessoa.getCpf());
        cv.put("ENDERECO", pessoa.getEndereco());
        cv.put("DATA_NASC", pessoa.getDataNasc());
        cv.put("TELEFONE", pessoa.getTelefone());
        cv.put("EMAIL", pessoa.getEmail());
//        cv.put("ESTADO", pessoa.getEstado());
//        cv.put("CIDADE", pessoa.getCidade());
        cv.put("USUARIO", pessoa.getUsuario());
        cv.put("SENHA", pessoa.getSenha());
        System.out.println("Adicionando "+ pessoa.getUsuario() +" a tabela...");

        return db.insert(MainDB.TABELA_PESSOA, null, cv) != -1;
    }
}
