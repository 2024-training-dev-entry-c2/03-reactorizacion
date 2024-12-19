package org.example.a;

public abstract class Alojamiento {
    private String nombre;
    private String ciudad;
    private Float calificacion;

    public Alojamiento(String nombre, String ciudad, float calificacion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.calificacion = calificacion;
    }

    public abstract float calcularPrecioMasBajo(int diaInicio, int diaFinal);

    public float calcularPrecio(float precio, int cantidadPersonas, int diaInicio, int diaFinal) {
        double precioFinal = precio;

        if ((diaInicio <= 10 && diaFinal >= 5)) {
            precioFinal = precio - (precio * 0.08);
        }

        if ((diaInicio <= 15 && diaFinal >= 10)) {
            precioFinal = precio + (precio * 0.10);
        }

        if ((diaInicio <= 31 && diaFinal >= 26)) {
            precioFinal = precio + (precio * 0.15);
        }

        return (float) precioFinal * cantidadPersonas;
    }

    public abstract void verAlojamiento();

    // Getters and setters

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public float getCalificacion() {
        return calificacion;
    }
}
