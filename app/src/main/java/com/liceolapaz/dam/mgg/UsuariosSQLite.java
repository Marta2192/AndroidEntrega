package com.liceolapaz.dam.mgg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLite extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Usuarios (Email TEXT, Contraseña TEXT, Idioma TEXT, Edad INTEGER, Nombre TEXT)";

    public UsuariosSQLite(Context contexto, String nombre,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior,
                          int versionNueva) {

        db.execSQL("DROP TABLE IF EXISTS Usuarios");


        db.execSQL(sqlCreate);
    }
}
