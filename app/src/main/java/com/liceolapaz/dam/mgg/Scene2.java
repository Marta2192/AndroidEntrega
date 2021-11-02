package com.liceolapaz.dam.mgg;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Scene2 extends AppCompatActivity {

    private RecyclerView recView;

    private ArrayList<Usuarios> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        datos = new ArrayList<Usuarios>();
        for (int i = 1; i < 9; i++) {
            datos.add(new Usuarios("Nombre: ", "Idioma: ", "Edad: " + i));

        }

        recView = (RecyclerView) findViewById(R.id.recView);
        recView.setHasFixedSize(true);

        final Recycler_Adaptador adaptador= new Recycler_Adaptador(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("RecyclerView", "Pulsado " + recView.getChildAdapterPosition(v));
            }
        });

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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}