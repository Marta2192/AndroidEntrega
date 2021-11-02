package com.liceolapaz.dam.mgg;

public class Usuarios {
    private String nombreUser;
    private String idiomaUser;
    private String edadUser;

    public Usuarios(String nombreUser, String idiomaUser, String edadUser) {
        this.nombreUser = nombreUser;
        this.idiomaUser = idiomaUser;
        this.edadUser = edadUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public String getIdiomaUser() {
        return idiomaUser;
    }

    public String getEdadUser() {
        return edadUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public void setIdiomaUser(String idiomaUser) {
        this.idiomaUser = idiomaUser;
    }

    public void setEdad(String edadUser) {
        this.edadUser = edadUser;
    }
}




