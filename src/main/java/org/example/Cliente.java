package org.example;

import java.time.LocalDate;

public class Cliente {
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Float telefono;
    private String email;
    private LocalDate fechaNacimiento;

    public Cliente(String nombre, String apellido, String nacionalidad, Float telefono, String email, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() {
    }

}
