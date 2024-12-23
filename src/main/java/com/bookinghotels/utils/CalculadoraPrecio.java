package com.bookinghotels.utils;

import com.bookinghotels.model.alojamiento.Alojamiento;

import java.time.LocalDate;

public class CalculadoraPrecio {
  public static Float calcularPrecioTotal(Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin) {
    long diasEstadia = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    Float precioBase = alojamiento.getPrecio() * diasEstadia;

    Float ajuste = calcularAjuste(precioBase, fechaInicio, fechaFin);
    return precioBase + ajuste;
  }

  public static Float calcularAjuste(Float precioBase, LocalDate fechaInicio, LocalDate fechaFin) {
    Float porcentajeAjuste = obtenerPorcentajeAjuste(fechaInicio, fechaFin);
    return precioBase * porcentajeAjuste;
  }

  private static Float obtenerPorcentajeAjuste(LocalDate fechaInicio, LocalDate fechaFin) {
    float porcentaje = 0f;

    porcentaje += obtenerAjuste(fechaFin.getDayOfMonth(), 26, 31, 0.15f);
    porcentaje += obtenerAjuste(fechaInicio.getDayOfMonth(), 10, 15, 0.10f);
    porcentaje += obtenerAjuste(fechaInicio.getDayOfMonth(), 5, 9, -0.08f);

    return porcentaje;
  }

  private static float obtenerAjuste(int dia, int rangoInicio, int rangoFin, float ajuste) {
    return estaEnRango(dia,rangoInicio,rangoFin) ? ajuste : 0f;
  }

  private static boolean estaEnRango(int dia, int rangoInicio, int rangoFin){
    return  dia >= rangoInicio && dia <= rangoFin;
  }


  public static void calcularPrecios(Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin) {
    long diasEstadia = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    Float precioBase = alojamiento.getPrecio() * diasEstadia;
    Float ajuste = calcularAjuste(precioBase, fechaInicio, fechaFin);
    Float precioTotal = precioBase + ajuste;
    mostrarPrecios(precioBase,precioTotal,obtenerPorcentajeAjuste(fechaInicio,fechaFin)*100);
  }

  private static void mostrarPrecios(Float precioBase, Float precioTotal, Float porcentAjuste){
    System.out.println("Precio base: " + precioBase);
    System.out.println("Precio total: " + precioTotal + "(" + porcentAjuste + "%)");
  }
}
