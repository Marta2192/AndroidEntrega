package com.liceolapaz.dam.mgg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLite extends SQLiteOpenHelper {



    String sqlCreate = "CREATE TABLE IF NOT EXISTS Usuarios" +
            "(mail TEXT PRIMARY KEY," +
            " password TEXT NOT NULL," +
            " idioma TEXT CHECK(idioma IN('ES','GL','EN')) ," +
            " edad INTEGER NOT NULL," +
            " nombre TEXT NOT NULL)";

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
