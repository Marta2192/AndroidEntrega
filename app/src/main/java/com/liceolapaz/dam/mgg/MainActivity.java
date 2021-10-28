package com.liceolapaz.dam.mgg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Login ctlLogin;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctlLogin = (Login) findViewById(R.id.CtlLogin);

        ctlLogin.setOnLoginListener(new OnLoginListener() {
            int contador = 0;
            @Override
            public void onLogin(String usuario, String password) {




                    if (usuario.equals("admin") && password.equals("liceo"))
                        ctlLogin.setMensaje("Login correcto!");
                            Intent intent =
                                    new Intent(MainActivity.this, Scene2.class);

                            //Creamos la información a pasar entre actividades
                            Bundle b = new Bundle();


                            //Añadimos la información al intent
                            intent.putExtras(b);

                            //Iniciamos la nueva actividad
                            startActivity(intent);

                            finish();

                    if(!usuario.equals("admin") || !password.equals("liceo")) {
                        ctlLogin.setMensaje("Usuario y/o contraseña incorrectos.");
                        ++contador;
                    }

                
                if((!usuario.equals("admin") || !password.equals("liceo")) && contador >=3)
                    System.exit(0);






            }




        });
        /*btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(MainActivity.this, AppBar.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();


                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });*/



    }
}