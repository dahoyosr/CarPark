package com.example.equipo.carpark.models;

/**
 * Created by EQUIPO on 21/03/2016.
 */

//SE CREAN LOS ATRIBUTOS PARA EL PARQUEADERO
public class parqueaderos {

    String nombre;
    String direccion;
    String imgUrl;

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    String precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
