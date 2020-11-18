package com.example.caseraapp.model;

public class animal {
    private int _id;
    private String nombre;
    private String descripcion;
    private int edad;

    @Override
    public String toString() {
        return "nota{" +
                "_id=" + _id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }

    public animal() {
    }

    public animal(String nombre, int edad ,String descripcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    public animal(int _id, String nombre, int edad ,String descripcion) {
        this._id = _id;
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
