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




                if (usuario.equals("admin") && password.equals("liceo")) {
                    ctlLogin.setMensaje("Login correcto!");


                    Intent intent =
                            new Intent(MainActivity.this, Scene2.class);

                    Bundle b = new Bundle();

                    intent.putExtras(b);

                    startActivity(intent);

                    finish();
                }
                if(!usuario.equals("admin") || !password.equals("liceo")) {
                    ctlLogin.setMensaje("Usuario y/o contraseña incorrectos.");
                    ++contador;
                }


                if((!usuario.equals("admin") || !password.equals("liceo")) && contador >=3)
                    System.exit(0);



            }




        });


    }
}