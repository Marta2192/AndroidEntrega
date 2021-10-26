package com.liceolapaz.dam.mgg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Login ctlLogin;

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