package com.example.meuapp.crud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.meuapp.model.Pessoa;

import java.util.ArrayList;

public class Read {
    public ArrayList<Pessoa> getPessoas() {

        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TABELA_PESSOA + " ORDER BY USUARIO";
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {

            do {
                Pessoa pessoa = new Pessoa();
                pessoa.setNomeCompleto(c.getString(1));
                pessoa.setCpf(c.getString(2));
                pessoa.setEndereco(c.getString(3));
                pessoa.setDataNasc(c.getString(4));
                pessoa.setTelefone(c.getString(5));
//                pessoa.setEstado(c.getString(6));
//                pessoa.setCidade(c.getString(7));
                pessoa.setEmail(c.getString(8));
                pessoa.setUsuario(c.getString(9));
                pessoa.setSenha(c.getString(10));
                pessoas.add(pessoa);
            } while (c.moveToNext());
        }

        c.close();
        return pessoas;
    }

    public Pessoa getPessoaById(String usuario) {
        SQLiteDatabase db = MainDB.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + MainDB.TABELA_PESSOA + " WHERE USUARIO ='" + usuario+"'";
//        ArrayList<String> pessoas = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);
        Pessoa pessoa = new Pessoa();

        if(c.moveToFirst()) {
            do {
                pessoa.setNomeCompleto(c.getString(1));
                pessoa.setCpf(c.getString(2));
                pessoa.setEndereco(c.getString(3));
                pessoa.setDataNasc(c.getString(4));
                pessoa.setTelefone(c.getString(5));
                pessoa.setEmail(c.getString(8));
                pessoa.setUsuario(c.getString(9));
                pessoa.setSenha(c.getString(10));
            }while(c.moveToNext());
        }
        return pessoa;
    }

}
