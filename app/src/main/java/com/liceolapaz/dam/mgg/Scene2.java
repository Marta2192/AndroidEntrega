package com.liceolapaz.dam.mgg;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Scene2 extends AppCompatActivity {

    private RecyclerView recView;
    private ArrayList<Usuario> datos;
    private SQLiteDatabase db;
    private TextView numUsuario;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        datos = new ArrayList<Usuario>();

        UsuariosSQLite usersDB =
                new UsuariosSQLite(this, "DBUsuarios", null, 1);

        db = usersDB.getWritableDatabase();



        datos = new ArrayList<Usuario>();
        recView = (RecyclerView) findViewById(R.id.recView);
        recView.setHasFixedSize(true);
        numUsuario = (TextView) findViewById(R.id.txtNumUsuario);

        final Recycler_Adaptador adaptador= new Recycler_Adaptador(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecyclerView", "Pulsado " + recView.getChildAdapterPosition(v));

                Intent intent = new Intent(Scene2.this, Scene3.class);
                Bundle bundle = new Bundle();
                bundle.putString("MAIL", datos.get(recView.getChildAdapterPosition(v)).getMailUser());
                bundle.putString("PASS", datos.get(recView.getChildAdapterPosition(v)).getPasswordUser());
                bundle.putString("NOMBRE", datos.get(recView.getChildAdapterPosition(v)).getNombreUser());
                bundle.putString("IDIOMA", datos.get(recView.getChildAdapterPosition(v)).getIdiomaUser());
                bundle.putInt("EDAD", datos.get(recView.getChildAdapterPosition(v)).getEdadUser());

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

       cargarUsers();

        recView.setAdapter(adaptador);

        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        recView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recView.setItemAnimator(new DefaultItemAnimator());
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nuevo:
                Log.i("Appbar", "Nuevo!");
                Intent intent =
                        new Intent(Scene2.this, Scene3.class);

                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void cargarUsers() {

        String sql = "SELECT mail, password, nombre, idioma, edad FROM Usuarios";

        Cursor c = db.rawQuery(sql,null);

        if (c.moveToFirst()){
            do{
                String mail = c.getString(0);
                String pass = c.getString(1);
                String nombre = c.getString(2);
                String idioma = c.getString(3);
                int edad = Integer.parseInt(c.getString(4));
                Usuario us = new Usuario(mail, nombre, idioma, edad,pass);
                datos.add(us);

            }while (c.moveToNext());
        }

        numUsuario.setText(String.valueOf(datos.size()));

        db.close();




    }




}