package org.example.models;

import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private String nacionalidad;
    private String telefono;
    private LocalDate fechaNacimiento;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String email, String nacionalidad, String telefono, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }

    @Override
    public String toString(){
        return String.format("Cliente: %s %s, Email: %s, Nacionalidad: %s, Teléfono: %s, Fecha de nacimiento: %s",
                nombre, apellido, email, nacionalidad, telefono, fechaNacimiento);
    }
}
