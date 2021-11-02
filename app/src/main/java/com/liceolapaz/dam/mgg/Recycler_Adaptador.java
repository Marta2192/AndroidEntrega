package com.liceolapaz.dam.mgg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler_Adaptador extends RecyclerView.Adapter<Recycler_Adaptador.UsuariosViewHolder>
        implements View.OnClickListener{

    private View.OnClickListener listener;
    private ArrayList<Usuarios> datos;

    public static class UsuariosViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtNombreUser;
        private TextView txtIdiomaUser;
        private TextView txtEdadUser;


        public UsuariosViewHolder(View itemView) {
            super(itemView);

            txtNombreUser = (TextView) itemView.findViewById(R.id.txtNombreUser);
            txtIdiomaUser = (TextView) itemView.findViewById(R.id.txtIdiomaUser);
            txtEdadUser = (TextView) itemView.findViewById(R.id.txtEdadUser);

        }

        public void bindUsuario(Usuarios t) {
            txtNombreUser.setText(t.getNombreUser());
            txtIdiomaUser.setText(t.getIdiomaUser());
            txtEdadUser.setText("Edad: " +t.getEdadUser());

        }
    }

    public Recycler_Adaptador(ArrayList<Usuarios> datos) {
        this.datos = datos;
    }

    @Override
    public UsuariosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view, viewGroup, false);
        itemView.setOnClickListener(this);
        UsuariosViewHolder tvh = new UsuariosViewHolder(itemView);
        return tvh;
    }

    @Override
    public void onBindViewHolder(UsuariosViewHolder viewHolder, int pos) {
        Usuarios item = datos.get(pos);
        viewHolder.bindUsuario(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }
}
