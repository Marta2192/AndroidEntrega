package com.liceolapaz.dam.mgg;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;



    public class Login extends LinearLayout {
        private EditText txtUsuario;
        private EditText txtPassword;
        private Button btnLogin;
        private TextView lblMensaje;

        private OnLoginListener listener;

        public Login(Context context) {
            super(context);
            inicializar();
        }

        public Login(Context context, AttributeSet attrs) {
            super(context, attrs);
            inicializar();

            TypedArray a =
                    getContext().obtainStyledAttributes(attrs,
                            R.styleable.login_text);

            String textoBoton = a.getString(
                    R.styleable.login_text_login_text);

            btnLogin.setText(textoBoton);

            a.recycle();
        }


        private void inicializar() {

            String infService = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li =
                    (LayoutInflater) getContext().getSystemService(infService);
            li.inflate(R.layout.login, this, true);

            txtUsuario = (EditText) findViewById(R.id.txtUsuario);
            txtPassword = (EditText) findViewById(R.id.txtPassword);
            btnLogin = (Button) findViewById(R.id.btnAceptar);
            lblMensaje = (TextView) findViewById(R.id.lblMensaje);

            asignarEventos();
        }

        public void setOnLoginListener(OnLoginListener l) {
            listener = l;
        }

        private void asignarEventos() {
            btnLogin.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    listener.onLogin(txtUsuario.getText().toString(),
                            txtPassword.getText().toString());
                }
            });
        }

        public void setMensaje(String msg) {
            lblMensaje.setText(msg);
        }

}
