package com.bookinghotels;

import com.bookinghotels.gestion.GestorMenus;

import com.bookinghotels.modelos.*;

import com.bookinghotels.inicializacion.InicializadorDeDatos;

import java.util.*;


public class Main {
    private static List<Alojamiento> alojamientos = new ArrayList<>();

    public static void main(String[] args) {
        inicializarDatos();
        gestionarMenu();
    }

    public static void inicializarDatos(){
        alojamientos = InicializadorDeDatos.cargarDatosIniciales();
    }

    public static void gestionarMenu(){
        new GestorMenus().gestionarOpciones();
    }

    //Getters
    public static List<Alojamiento> getAlojamientos() {
        return new ArrayList<>(alojamientos);
    }

}
