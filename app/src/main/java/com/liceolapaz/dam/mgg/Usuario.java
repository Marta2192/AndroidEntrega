package com.liceolapaz.dam.mgg;

public class Usuario {
    private String mailUser;
    private String nombreUser;
    private String idiomaUser;
    private int edadUser;
    private String passwordUser;

    public Usuario(String mailUser, String nombreUser, String idiomaUser, int edadUser, String passwordUser) {
        this.mailUser = mailUser;
        this.nombreUser = nombreUser;
        this.idiomaUser = idiomaUser;
        this.edadUser = edadUser;
        this.passwordUser = passwordUser;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public String getIdiomaUser() {
        return idiomaUser;
    }

    public int getEdadUser() {
        return edadUser;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public void setIdiomaUser(String idiomaUser) {
        this.idiomaUser = idiomaUser;
    }

    public void setEdadUser(int edadUser) {
        this.edadUser = edadUser;
    }

    public String getMailUser() {
        return mailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }
}




