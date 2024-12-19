package org.example.a;

import java.util.LinkedList;

public interface IAlojamientoControladora {
    void cargarDatos();
    void filtrarPorParametros(String ciudad, Alojamiento alojamientoElegido, int cantHabitacionesCliente, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios);
    Boolean buscarCiudadNombre(String nombreCiudad);
    <T extends Alojamiento> Boolean BuscarAlojamiento(String nombreAlojamiento, LinkedList<T> miLista);
    void mostrarTodosAlojamientos(String tipoHotel);
    <T extends Alojamiento> void mostrarAlojamientos(LinkedList<T> miLista);
    Alojamiento econtrarAlojamientos(String miLista, int indexIngresado);
    void buscarAlojamientosDisponibles(String ciudad, Hotel hotelElegido, int cantHabitacionesCliente, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios);
    void buscarAlojamientosDisponibles(String ciudad, Finca fincaElegido, int cantHabitacionesCliente, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios);

}
