package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlojamientoVisualizacion {
    private final List<Alojamientos> alojamientos = new ArrayList<>();

    public void inicializarDatos() {
        alojamientos.add(new Hotel("Hotel Paraíso", "Cartagena", "Hotel", 5.0, Arrays.asList(
                new Habitacion("Sencilla", "1 cama sencilla, TV, baño privado", 150000, 10, 4),
                new Habitacion("Duo", "2 camas sencillas, TV, baño privado", 200000, 5, 6)
        )));

        alojamientos.add(new Hotel("Hotel Paraíso", "Cartagena", "Hotel", 5.0,
                Arrays.asList(new Habitacion("Sencilla", "1 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Duo", "2 camas sencillas, TV, baño privado", 200000, 5, 6),
                        new Habitacion("Triple", "4 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Lujo", "2 cama sencilla, TV, baño privado, servicio al cuarto", 150000, 10, 4),
                        new Habitacion("Presidencial", "2 cama sencilla, TV, baño privado, Jacuzzi", 150000, 10, 4))));

        alojamientos.add(new Hotel("Hotel Real", "Bogotá", "Hotel", 5.0,
                Arrays.asList(new Habitacion("Sencilla", "1 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Duo", "3 camas sencillas, TV, baño privado", 200000, 5, 6),
                        new Habitacion("Triple", "4 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Lujo", "2 cama sencilla, TV, baño privado, servicio al cuarto", 150000, 10, 4),
                        new Habitacion("Presidencial", "2 cama sencilla, TV, baño privado, Jacuzzi", 150000, 10, 4)
                )));
        alojamientos.add(new Hotel("Hotel Real", "Medellín", "Hotel", 5.0,
                Arrays.asList(new Habitacion("Sencilla", "1 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Duo", "3 camas sencillas, TV, baño privado", 200000, 5, 6),
                        new Habitacion("Triple", "4 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Lujo", "2 cama sencilla, TV, baño privado, servicio al cuarto", 150000, 10, 4),
                        new Habitacion("Presidencial", "2 cama sencilla, TV, baño privado, Jacuzzi", 150000, 10, 4)
                )));
        alojamientos.add(new Apartamento("Apartamento Luna", "Bogotá", "Apartamento", 4.4,
                Arrays.asList(new Habitacion("Suite", "1 cama king, cocina equipada, balcón", 300000, 5, 3),
                        new Habitacion("Familiar", "2 camas dobles, sala comedor, cocina", 250000, 2, 5))));
        alojamientos.add(new Apartamento("Apartamento sol", "Medellín", "Apartamento", 4.4,
                Arrays.asList(new Habitacion("Suite", "1 cama king, cocina equipada, balcón", 300000, 5, 3),
                        new Habitacion("Familiar", "2 camas dobles, sala comedor, cocina", 250000, 2, 5))));

        alojamientos.add(new Finca("Finca El Encanto", "Medellín", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));

        alojamientos.add(new Finca("Finca El Capo", "Medellín", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));
        alojamientos.add(new Finca("Finca El Encanto Carta", "Cartagena", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));

        alojamientos.add(new Finca("Finca La mojarra", "Cartagena", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));

        alojamientos.add(new Hotel("Resort Brisa Marina", "Cartagena", "Día de Sol", 3.9,
                Arrays.asList(new Habitacion("Piscina", "Acceso a piscina y deportes acuáticos", 120000, 10, 10),
                        new Habitacion("Picnic", "Piscina/Toboganes y zona de picnic", 90000, 10, 10)), new DiaSol(20000, "Piscina, Picninc, actividades varias")));
        alojamientos.add(new Hotel("Resort ", "Cartagena", "Día de Sol", 3.9,
                Arrays.asList(new Habitacion("Piscina", "Acceso a piscina y deportes acuáticos", 120000, 10, 10),
                        new Habitacion("Picnic", "Piscina/Toboganes y zona de picnic", 90000, 10, 10)), new DiaSol(20000, "Piscina, Picninc, actividades varias")));

    }

    public List<Alojamientos> filtrar(String ciudad, String tipo) {
        List<Alojamientos> filtrados = new ArrayList<>();
        for (Alojamientos alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudad) &&
                    alojamiento.getTipo().equalsIgnoreCase(tipo)) {
                filtrados.add(alojamiento);
            }
        }
        return filtrados;
    }

    public List<String> obtenerCiudades() {
        List<String> ciudades = new ArrayList<>();
        for (Alojamientos alojamiento : alojamientos) {
            if (!ciudades.contains(alojamiento.getCiudad())) {
                ciudades.add(alojamiento.getCiudad());
            }
        }
        return ciudades;
    }

    public List<String> obtenerTipos() {
        List<String> tipos = new ArrayList<>();
        for (Alojamientos alojamiento : alojamientos) {
            if (!tipos.contains(alojamiento.getTipo())) {
                tipos.add(alojamiento.getTipo());
            }
        }
        return tipos;
    }

}
