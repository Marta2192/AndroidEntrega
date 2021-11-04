package com.liceolapaz.dam.mgg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLite extends SQLiteOpenHelper {



    String sqlCreate = "CREATE TABLE IF NOT EXISTS Usuarios" +
            "(Email TEXT PRIMARY KEY," +
            " Contraseña TEXT NOT NULL," +
            " Idioma TEXT NOT NULL," +
            " Edad INTEGER NOT NULL," +
            " Nombre TEXT NOT NULL)";

    public UsuariosSQLite(Context contexto, String nombre,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior,
                          int versionNueva) {

        db.execSQL("DROP TABLE IF EXISTS Usuarios");


        db.execSQL(sqlCreate);
    }
}
