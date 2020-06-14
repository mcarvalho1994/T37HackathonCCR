package com.example.truckerapp.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.truckerapp.model.TruckerappDBCore;
import com.example.truckerapp.model.Usuario;

public class TruckerappBDController extends TruckerappDBCore{

    public TruckerappBDController (Context context) {
        super(context);
    }

    public String cadastrarUsuario(Usuario usuario) {
        ContentValues valores;
        long resultado;

        valores = new ContentValues();
        valores.put("usuario", usuario.getUsuario());
        valores.put("senha", usuario.getPassword());
        valores.put("nome", usuario.getNome());
        valores.put("celular", usuario.getCelular());
        valores.put("data_nascimento", usuario.getData_nascimento());
        valores.put("marca_caminhao", usuario.getMarcaCaminhao());
        valores.put("modelo_caminhao", usuario.getModeloCaminhao());
        valores.put("placa_caminhao", usuario.getPlacaCaminhao());


        resultado = getDatabase().insertOrThrow("usuarios", null, valores);
        getDatabase().close();


        if(resultado == -1) {
            return "Erro ao cadastrar usuário";
        } else {
            return "Usuário cadastrado com sucesso";
        }
    }

    public Boolean logarUsuario(Usuario usuario) {
//        String sql = "SELECT id, usuario, senha, nome, idade, marca_caminhao, modelo_caminhao, placa_caminhao " +
//                "FROM usuarios WHERE usuario = ? AND senha = ?";

//        Cursor cursor = getDatabase().rawQuery(sql, new String[] {usuario.getUsuario(), usuario.getPassword()});

        String selection = "usuario = ? and senha = ?";
        String columns = "id, usuario, senha, nome, celular, data_nascimento, marca_caminhao, modelo_caminhao, placa_caminhao";
        String[] selectionArgs = {usuario.getUsuario(), usuario.getPassword()};

        Cursor cursor = getDatabase().query("usuarios", new String[]{columns}, selection, selectionArgs, null, null, null);
        if(cursor.moveToFirst()){
            usuario.setId(cursor.getLong(0));
            usuario.setNome(cursor.getString(3));
            usuario.setCelular(cursor.getString(4));
            usuario.setData_nascimento(cursor.getString(5));
            usuario.setMarcaCaminhao(cursor.getString(6));
            usuario.setModeloCaminhao(cursor.getString(7));
            usuario.setPlacaCaminhao(cursor.getString(8));
            return true;
        } else {
            return false;
        }
    }
}
