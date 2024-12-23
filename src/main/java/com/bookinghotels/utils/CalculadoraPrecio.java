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
    if (esUltimoDelMes(fechaFin)) {
      return 0.15f;
    }
    if (esDiezAlQuince(fechaInicio)) {
      return 0.10f;
    }
    if (esCincoAlDiez(fechaInicio)) {
      return -0.08f;
    }
    return 0f;
  }

  private static boolean esUltimoDelMes(LocalDate fechaFin) {
    return fechaFin.getDayOfMonth() >= 26 && fechaFin.getDayOfMonth() <= 31;
  }

  private static boolean esDiezAlQuince(LocalDate fechaInicio) {
    return fechaInicio.getDayOfMonth() >= 10 && fechaInicio.getDayOfMonth() <= 15;
  }

  private static boolean esCincoAlDiez(LocalDate fechaInicio) {
    return fechaInicio.getDayOfMonth() >= 5 && fechaInicio.getDayOfMonth() <= 9;
  }

  public static void calcularPrecios(Alojamiento alojamiento, LocalDate fechaInicio, LocalDate fechaFin) {
    long diasEstadia = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    Float precioBase = alojamiento.getPrecio() * diasEstadia;
    Float ajuste = calcularAjuste(precioBase, fechaInicio, fechaFin);
    Float precioTotal = precioBase + ajuste;
    mostrarDatos(alojamiento,precioBase,precioTotal,obtenerPorcentajeAjuste(fechaInicio,fechaFin)*100);

  }

  private static void mostrarDatos(Alojamiento alojamiento, Float precioBase, Float precioTotal, Float porcentAjuste){
    System.out.println("\n+--------------------------------------------+");
    alojamiento.getDetalles();
    System.out.println("Precio base: " + precioBase);

    System.out.println("Precio total: " + precioTotal + "(" + porcentAjuste + "%)");
    System.out.println("+--------------------------------------------+");
  }
}
