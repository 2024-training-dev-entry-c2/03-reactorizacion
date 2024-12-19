package org.example.a;

import java.util.LinkedList;

public class AlojamientoControladoraImplementacion implements IAlojamientoControladora {
    public static LinkedList<Hotel> listaHotel = new LinkedList<>();
    private static LinkedList<Finca> listaFinca = new LinkedList<>();
    private static LinkedList<Apartamento> listaApartamento = new LinkedList<>();

    private static LinkedList<Alojamiento> alojamientosDisponibles;

    public AlojamientoControladoraImplementacion() {
    }

    public Boolean buscarCiudadNombre(String nombreCiudad) {
        boolean existeNombreHotel = BuscarAlojamiento(nombreCiudad, listaHotel);
        boolean existeNombreFinca = BuscarAlojamiento(nombreCiudad, listaFinca);
        boolean existeNombreApartamento = BuscarAlojamiento(nombreCiudad, listaApartamento);

        return existeNombreHotel || existeNombreFinca || existeNombreApartamento;
    }

    public <T extends Alojamiento> Boolean BuscarAlojamiento(String nombreAlojamiento, LinkedList<T> miLista) {
        for (Alojamiento unAlojamiento : miLista) {
            if (unAlojamiento.getCiudad().equalsIgnoreCase(nombreAlojamiento)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarTodosAlojamientos(String tipoHotel) {
        switch (tipoHotel) {
            case "Hotel" -> mostrarAlojamientos(listaHotel);
            case "Finca" -> mostrarAlojamientos(listaFinca);
            case "Apartamento" -> mostrarAlojamientos(listaApartamento);
        }
    }


    public <T extends Alojamiento> void mostrarAlojamientos(LinkedList<T> miLista) {
        for (int i = 0; i < miLista.size(); i++) {
            System.out.println("------------------------------------------");
            System.out.println("Id: " + i);
            miLista.get(i).verAlojamiento();
            System.out.println("------------------------------------------");
        }

    }

    public Alojamiento econtrarAlojamientos(String miLista, int indexIngresado) {
        try {
            switch (miLista) {
                case "Hotel" -> {
                    return listaHotel.get(indexIngresado);
                }
                case "Finca" -> {
                    return listaFinca.get(indexIngresado);
                }
                case "Apartamento" -> {
                    return listaApartamento.get(indexIngresado);
                }
            }
        } catch (Exception _) {
        }
        return null;
    }

    @Override
    public void cargarDatos() {

        //CREACION DE HOTELES

        LinkedList<Habitacion> habitacionHotel1 = new LinkedList<>();
        habitacionHotel1.add(new Habitacion("Habitación sencilla", "La habitación sencilla tiene una cama matrimonial, vista al jardín, aire acondicionado, minibar, TV de pantalla plana, y baño privado", 40, 50));
        habitacionHotel1.add(new Habitacion("Habitación doble", "La habitación doble tiene 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio", 50, 50));
        habitacionHotel1.add(new Habitacion("Habitación familiar", "La habitación familiar tiene 2 camas dobles, baño privado, aire acondicionado, TV de pantalla plana, escritorio, y vistas al mar", 90, 50));
        habitacionHotel1.add(new Habitacion("Habitación superior", "Habitación con cama queen size, escritorio, baño con ducha y tina, aire acondicionado, TV de pantalla plana, y minibar", 120, 50));
        habitacionHotel1.add(new Habitacion("Nuevo Tipo de Habitación", "Titulo", 12, 50));
        Hotel hotel1 = new Hotel("Hotel Las Dunas", "Cabo Polonio", 4.5f, habitacionHotel1);

        LinkedList<Habitacion> habitacionHotel3 = new LinkedList<>();
        habitacionHotel3.add(new Habitacion("Habitación sencilla", "La habitación sencilla tiene una cama matrimonial, vista al jardín, aire acondicionado, minibar, TV de pantalla plana, y baño privado", 40, 50));
        habitacionHotel3.add(new Habitacion("Habitación doble", "La habitación doble tiene 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio", 50, 50));
        habitacionHotel3.add(new Habitacion("Habitación familiar", "La habitación familiar tiene 2 camas dobles, baño privado, aire acondicionado, TV de pantalla plana, escritorio, y vistas al mar", 90, 50));
        habitacionHotel3.add(new Habitacion("Habitación superior", "Habitación con cama queen size, escritorio, baño con ducha y tina, aire acondicionado, TV de pantalla plana, y minibar", 120, 50));
        habitacionHotel3.add(new Habitacion("Habitación Extrema", "La mejor de todas", 5, 50));
        Hotel hotel3 = new Hotel("Hotel Costa Dorada", "La Paloma", 3.5f, habitacionHotel3);

        LinkedList<Habitacion> habitacionHotel2 = new LinkedList<>();
        habitacionHotel2.add(new Habitacion("Habitación sencilla", "La habitación sencilla tiene una cama matrimonial, vista al jardín, aire acondicionado, minibar, TV de pantalla plana, y baño privado", 40, 50));
        habitacionHotel2.add(new Habitacion("Habitación doble", "La habitación doble tiene 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio", 50, 50));
        habitacionHotel2.add(new Habitacion("Habitación familiar", "La habitación familiar tiene 2 camas dobles, baño privado, aire acondicionado, TV de pantalla plana, escritorio, y vistas al mar", 90, 50));
        habitacionHotel2.add(new Habitacion("Habitación superior", "Habitación con cama queen size, escritorio, baño con ducha y tina, aire acondicionado, TV de pantalla plana, y minibar", 120, 50));
        habitacionHotel2.add(new Habitacion("Habitación Extrema", "La mejor de todas", 5, 50));
        Hotel hotel2 = new Hotel("Hotel Costa Dorada", "La Paloma", 4.5f, habitacionHotel2);

        listaHotel.add(hotel1);
        listaHotel.add(hotel2);
        listaHotel.add(hotel3);

        //CREACION DE FINCAS

        LinkedList<String> listaActividades = new LinkedList<>();
        listaActividades.add("Senderismo");
        listaActividades.add("Natacion");
        listaActividades.add("Fogata");
        DiaSol diaSol = new DiaSol(listaActividades, true);
        Finca finca1 = new Finca("Finca La Paloma", "La Paloma", 3.8f, diaSol, 150, 3, "Hermosa vista a las mar y ambiente tranquilo");

        LinkedList<String> listaActividades2 = new LinkedList<>();
        listaActividades2.add("Ciclismo");
        listaActividades2.add("Pesca");
        listaActividades2.add("Observación de aves");
        DiaSol diaSol2 = new DiaSol(listaActividades2, false);
        Finca finca2 = new Finca("Finca El Refugio", "Cabo Polonio", 5.2f, diaSol2, 180, 5, "Entorno natural, ideal para relajarse y disfrutar de la flora y fauna local");

        listaFinca.add(finca1);
        listaFinca.add(finca2);

        //CREACION DE APARTAMENTO

        Apartamento apartamento1 = new Apartamento("Apartamento Mar del Sol", "La Paloma", 4.2f, 120, 2, "Apartamento espacioso con vistas a la ciudad");
        Apartamento apartamento2 = new Apartamento("Apartamento Vista Azul", "Cabo Polonio", 3.5f, 100, 4, "Acogedor apartamento con vistas al océano y cerca de la playa");

        listaApartamento.add(apartamento1);
        listaApartamento.add(apartamento2);

    }

    @Override
    public void filtrarPorParametros(String ciudad, Alojamiento alojamientoElegido, int cantHabitacionesCliente, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios) {
        if (alojamientoElegido instanceof Hotel) {
            buscarAlojamientosDisponibles(ciudad, (Hotel) alojamientoElegido, cantHabitacionesCliente, diaInicioHospedaje, diaFinalHospedaje, cantAdultos, cantNinios);
        }
        if (alojamientoElegido instanceof Finca) {
            buscarAlojamientosDisponibles(ciudad, (Finca) alojamientoElegido, cantHabitacionesCliente, diaInicioHospedaje, diaFinalHospedaje, cantAdultos, cantNinios);
        }
        if (alojamientoElegido instanceof Apartamento) {
            buscarAlojamientosDisponibles(ciudad, (Apartamento) alojamientoElegido, cantHabitacionesCliente, diaInicioHospedaje, diaFinalHospedaje, cantAdultos, cantNinios);
        }
    }

    public void buscarAlojamientosDisponibles(String ciudad, Hotel hotelElegido, int cantHabitacionesCliente, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios) {
        LinkedList<Alojamiento> listaApartamentoFiltrada = new LinkedList<>();
        for (Alojamiento unAlojamiento : listaHotel) {
            if (!filtrarPorCiudad(unAlojamiento, ciudad)) continue;
            if (!filtrarPorHabitaciones(unAlojamiento, cantAdultos + cantNinios, hotelElegido)) continue;
            listaApartamentoFiltrada.add(unAlojamiento);
        }
        imprimirAlojamientosFiltrados(listaApartamentoFiltrada, diaInicioHospedaje, diaFinalHospedaje);
        alojamientosDisponibles = listaApartamentoFiltrada;
    }

    public void buscarAlojamientosDisponibles(String ciudad, Finca fincaElegido, int cantHabitacionesCliente, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios) {
        LinkedList<Alojamiento> listaFincaFiltrada = new LinkedList<>();
        for (Alojamiento unAlojamiento : listaHotel) {
            if (!filtrarPorCiudad(unAlojamiento, ciudad)) continue;
            if (!filtrarPorHabitaciones(unAlojamiento, cantHabitacionesCliente, fincaElegido)) continue;
            listaFincaFiltrada.add(unAlojamiento);
        }
        imprimirAlojamientosFiltrados(listaFincaFiltrada, diaInicioHospedaje, diaFinalHospedaje);
    }

    public void buscarAlojamientosDisponibles(String ciudad, Apartamento apartamentoElegido, int cantHabitacionesCliente, int diaInicioHospedaje, int diaFinalHospedaje, int cantAdultos, int cantNinios) {
        LinkedList<Alojamiento> listaFincaFiltrada = new LinkedList<>();
        for (Alojamiento unAlojamiento : listaHotel) {
            if (!filtrarPorCiudad(unAlojamiento, ciudad)) continue;
            if (!filtrarPorHabitaciones(unAlojamiento, cantHabitacionesCliente, apartamentoElegido)) continue;
            listaFincaFiltrada.add(unAlojamiento);
        }
        imprimirAlojamientosFiltrados(listaFincaFiltrada, diaInicioHospedaje, diaFinalHospedaje);
    }

    private boolean filtrarPorHabitaciones(Alojamiento alojamiento, int cantHabitacionesCliente, Hotel hotelElegido) {
        if (alojamiento instanceof Hotel) {
            Hotel unHotel = (Hotel) alojamiento;
            if (!unHotel.getNombre().equalsIgnoreCase(hotelElegido.getNombre())) return false;
            LinkedList<Habitacion> habitacionesFiltradas = unHotel.verificarCantidadDeHabitaciones(cantHabitacionesCliente);
            return !habitacionesFiltradas.isEmpty();
        }
        return false;
    }

    private boolean filtrarPorHabitaciones(Alojamiento alojamiento, int cantHabitacionesCliente, Finca fincaElegida) {
        if (alojamiento instanceof Finca) {
            Finca unFinca = (Finca) alojamiento;
            if (unFinca.getNombre().equalsIgnoreCase(fincaElegida.getNombre())) return false;
            if (unFinca.getCantidadHabitaciones() < cantHabitacionesCliente) return false;
            return true;
        }
        return false;
    }

    private boolean filtrarPorHabitaciones(Alojamiento alojamiento, int cantHabitacionesCliente, Apartamento apartamentoElegido) {
        if (alojamiento instanceof Apartamento) {
            Apartamento unApartamento = (Apartamento) alojamiento;
            if (!unApartamento.getNombre().equalsIgnoreCase(apartamentoElegido.getNombre())) return false;
            if (unApartamento.getCantidadHabitaciones() < cantHabitacionesCliente) return false;
            return true;
        }
        return false;
    }

    private boolean filtrarPorCiudad(Alojamiento alojamiento, String ciudad) {
        return alojamiento.getCiudad().equalsIgnoreCase(ciudad);
    }

    public <T extends Alojamiento> void imprimirAlojamientosFiltrados(LinkedList<T> miLista, int diaInicioHospedaje, int diaFinalHospedaje) {
        int index = 0;
        for (Alojamiento unAlojamiento : miLista) {
            System.out.println("------------------------------------------");
            System.out.println("Id: " + index);
            unAlojamiento.verAlojamiento();
            System.out.println("El precio más bajo es: $ " + unAlojamiento.calcularPrecioMasBajo(diaInicioHospedaje, diaFinalHospedaje));
            System.out.println("------------------------------------------");
            index++;
        }
    }

}
