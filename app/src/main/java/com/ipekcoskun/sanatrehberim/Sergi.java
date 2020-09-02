package com.ipekcoskun.sanatrehberim;

public class Sergi {
    int id;
    String sergiadi;
    String sanatci;

    public Sergi() {
    }

    public  Sergi(String sergiadi, String sanatci){
        this.sergiadi=sergiadi;
        this.sanatci=sanatci;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSergiadi() {
        return sergiadi;
    }

    public void setSergiadi(String sergiadi) {
        this.sergiadi = sergiadi;
    }

    public String getSanatci() {
        return sanatci;
    }

    public void setSanatci(String sanatci) {
        this.sanatci = sanatci;
    }
}
