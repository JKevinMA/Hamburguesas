package com.example.kevin.hamburguesas.Beans;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/**
 * Created by kevin on 19/11/2017.
 */

public class Elemento {
    int id;
    String nombre;
    String descripcion;
    Bitmap imagen;
    String data;
    double precio;
    String tipo;

    public Elemento(){

    }

    public Elemento(int id, String nombre, String descripcion, double precio, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData(String data) {
        //convertir la imagen de texto a bitmap
        try{
            byte[] bytedata= Base64.decode(data,Base64.DEFAULT);
            this.imagen= BitmapFactory.decodeByteArray(bytedata,0,bytedata.length);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public Bitmap getImagen() {
        return imagen;
    }
}
