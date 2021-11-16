package com.liceolapaz.dam.mgg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Scene3 extends AppCompatActivity {

    private SQLiteDatabase db;
    private Button aceptar;
    private Button cancelar;
    private Button eliminar;
    private EditText txtMail;
    private EditText txtPass;
    private Spinner spIdioma;
    private EditText txtEdad;
    private EditText txtNombreUsuario;
    private String stringIdioma;
    private String[] info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3);

        UsuariosSQLite usersDB =
                new UsuariosSQLite(this, "DBUsuarios", null, 1);

        db = usersDB.getWritableDatabase();
        aceptar = (Button) findViewById(R.id.btAceptar);
        cancelar = (Button) findViewById(R.id.btCancelar);
        eliminar = (Button) findViewById(R.id.btEliminar);
        txtMail = (EditText) findViewById(R.id.txtMail);
        txtPass = (EditText) findViewById(R.id.txtPass);
        spIdioma = (Spinner) findViewById(R.id.spIdioma);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        txtNombreUsuario = (EditText) findViewById(R.id.txtNombreUsuario);

        info = new String[]{"Selecciona idioma:", "Español(ES)", "Gallego(GL)", "Inglés(EN)"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, info);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spIdioma.setAdapter(adaptador);

        Bundle bundle = this.getIntent().getExtras();



        if(bundle != null) {
            txtMail.setText(bundle.getString("MAIL"));
            txtPass.setText(bundle.getString("PASS"));
            spIdioma.setSelection(obtenerPosicionSpinner(spIdioma, bundle.getString("IDIOMA")), true);
            txtEdad.setText(String.valueOf(bundle.getInt("EDAD")));
            txtNombreUsuario.setText(bundle.getString("NOMBRE"));

            }else{
            eliminar.setVisibility(View.GONE);

        }


        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                Dialogo dialogo = new Dialogo(Scene3.this);
                dialogo.show(fragmentManager, "tagConfirmacion");


            }
        });



                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        Dialogo_Cancelar dialogo_cancelar = new Dialogo_Cancelar(Scene3.this);
                        dialogo_cancelar.show(fragmentManager, "tagCancelacion");

                    }
                });



                eliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        Dialogo_Eliminar dialogo_eliminar = new Dialogo_Eliminar(Scene3.this);
                        dialogo_eliminar.show(fragmentManager, "tagBorrar");

                    }

                });

                spIdioma.setOnItemSelectedListener(
                        new AdapterView.OnItemSelectedListener() {
                            public void onItemSelected(AdapterView<?> parent,
                                                       View v, int position, long id) {
                                if (parent.getItemAtPosition(position).toString() == "Español(ES)") {
                                    stringIdioma = "ES";
                                }
                                if (parent.getItemAtPosition(position).toString() == "Gallego(GL)") {
                                    stringIdioma = "GL";
                                }
                                if (parent.getItemAtPosition(position).toString() == "Inglés(EN)") {
                                    stringIdioma = "EN";
                                }
                            }

                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });


            }

    private int obtenerPosicionSpinner(Spinner spIdioma, String idioma) {
        info = new String[]{"Selecciona idioma:", "Español(ES)", "Gallego(GL)", "Inglés(EN)"};

        int posicion = 0;

        if(idioma.equals("ES")){
            posicion = 1;
        }
        if(idioma.equals("GL")){
            posicion = 2;
        }
        if(idioma.equals("EN")){
            posicion = 3;
        }

        return posicion;
    }


    public void eliminarUsuario() {
                db.delete("Usuarios", "mail=" + "'" + txtMail.getText().toString() + "'", null);
                db.close();
                  Intent intent = new Intent(Scene3.this, Scene2.class);
                 startActivity(intent);
    }

            public void cancelar() {

                Intent intent = new Intent(Scene3.this, Scene2.class);
                startActivity(intent);

            }

            public void addUsuario() {
                ContentValues valoresRegistro = new ContentValues();
                valoresRegistro.put("mail", txtMail.getText().toString());
                valoresRegistro.put("password", txtPass.getText().toString());
                valoresRegistro.put("idioma", stringIdioma);
                valoresRegistro.put("edad", Integer.parseInt(txtEdad.getText().toString()));
                valoresRegistro.put("nombre", txtNombreUsuario.getText().toString());
                db.insert("Usuarios", null, valoresRegistro);
                db.close();
                Intent intent = new Intent(Scene3.this, Scene2.class);
                startActivity(intent);
            }
        }