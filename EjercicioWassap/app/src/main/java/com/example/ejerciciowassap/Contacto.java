package com.example.ejerciciowassap;

import android.widget.ImageView;

public class Contacto {

    private String name, lastmsg, date;
    private ImageView img;

    public Contacto(String name, String lastmsg, String date, ImageView img) {
        this.name = name;
        this.lastmsg = lastmsg;
        this.date = date;
        this.img = img;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastmsg() {
        return lastmsg;
    }

    public void setLastmsg(String lastmsg) {
        this.lastmsg = lastmsg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
    

}
