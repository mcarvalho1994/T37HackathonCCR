package com.example.truckerapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class TruckerappDBCore extends SQLiteOpenHelper {
    private static final String TRUCKERAPPDB = "truckerapp.db";
    private static final int VERSAO = 2;
    protected SQLiteDatabase database;

    public TruckerappDBCore(@Nullable Context context) {
        super(context, TRUCKERAPPDB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE usuarios (id integer primary key autoincrement," +
                     "usuario character(50), " +
                     "senha character(50), " +
                     "nome character(50), " +
                     "celular character(50), " +
                     "data_nascimento character(50), " +
                     "marca_caminhao character(50), " +
                     "modelo_caminhao character(50), " +
                     "placa_caminhao character(7)); ";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS usuarios";
        db.execSQL(sql);
        onCreate(db);
    }

    public SQLiteDatabase getDatabase() {
        if (database == null) {
            database = getWritableDatabase();
        }
        return database;
    }
}
