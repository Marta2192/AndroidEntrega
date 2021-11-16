package com.liceolapaz.dam.mgg;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogo_Eliminar extends DialogFragment {

    private Scene3 scene3;

    public Dialogo_Eliminar(Scene3 scene3) {
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

        builder.setMessage("Los datos se borrarán de la base de datos. ¿Está seguro?")
                .setTitle("Eliminar")
                .setPositiveButton("SÍ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Dialogos", "Confirmacion Aceptada.");
                        System.out.println(id);
                        Dialogo_Eliminar.this.getDatos().eliminarUsuario();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Dialogos", "Confirmacion Denegada.");
                        System.out.println(id);
                        dialog.cancel();
                    }
                })
                .setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Dialogos", "Confirmacion Cancelada.");
                        System.out.println(id);
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

}