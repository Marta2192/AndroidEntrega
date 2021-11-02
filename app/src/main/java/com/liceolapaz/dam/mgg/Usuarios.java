package com.liceolapaz.dam.mgg;

public class Usuarios {
    private String nombreUser;
    private String idiomaUser;
    private int edadUser;
    private String mailUser;
    private String passwordUser;

    public Usuarios(String nombreUser, String idiomaUser, int edadUser) {
        this.nombreUser = nombreUser;
        this.idiomaUser = idiomaUser;
        this.edadUser = edadUser;
    }

    public Usuarios(String nombreUser, String idiomaUser, int edadUser, String mailUser, String passwordUser) {
        this.nombreUser = nombreUser;
        this.idiomaUser = idiomaUser;
        this.edadUser = edadUser;
        this.mailUser = mailUser;
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

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
}




