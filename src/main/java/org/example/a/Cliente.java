package org.example.a;

import java.util.Date;

public class Cliente {
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String telefono;
    private String email;
    private Date fechaNacimiento;

    public Cliente(String nombre, String apellido, String nacionalidad, String telefono, String email, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido : " + getApellido());
        System.out.println("Nacionalidad: " + getNacionalidad());
        System.out.println("Telefono: " + getTelefono());
        System.out.println("Email: " + getEmail());
        System.out.println("Fecha de nacimiento: " + getFechaNacimiento());
    }

    // Getters and setters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

}
