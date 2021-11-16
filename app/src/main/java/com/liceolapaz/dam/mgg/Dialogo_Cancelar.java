package com.liceolapaz.dam.mgg;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogo_Cancelar extends DialogFragment{

        private Scene3 scene3;

        public Dialogo_Cancelar(Scene3 scene3) {
            this.scene3 = scene3;
        }

        public Scene3 getDatos() {
            return scene3;
        }

        public void setScene3(Scene3 scene3) {
            this.scene3 = scene3;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(getActivity());

            builder.setMessage("Los datos no se guardarán. ¿Está seguro de cancelar?")
                    .setTitle("Cancelar")
                    .setPositiveButton("SÍ", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Log.i("Dialogos", "Confirmacion Aceptada.");
                            System.out.println(id);
                            Dialogo_Cancelar.this.getDatos().cancelar();
                            dialog.cancel();
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Log.i("Dialogos", "Confirmacion Denegada.");
                            System.out.println(id);
                            dialog.cancel();
                        }
                    });

            return builder.create();
        }

    }
