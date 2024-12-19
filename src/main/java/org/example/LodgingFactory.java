package org.example;

import java.time.LocalDate;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class LodgingFactory {
    public static Lodging createLodging(String city, String category, LocalDate entryDay, LocalDate endDay) {
        switch (category.toLowerCase()) {
            case "hotel":
                return new Hotel("Hotel Generico", "hotel", city, 4.5F, entryDay, endDay);
            case "apartamento":
                return new Apartment("Apartamento Generico", "apartment", city, 4.0F, "3", entryDay, endDay);
            case "finca":
                return new Farm("Finca Generica", city, "farm", 3.8F, entryDay, endDay);
            case "dia de sol":
                return new SunnyDay("Dia de sol", city, "sunnyday", 3.5F, entryDay, endDay);
            default:
                throw new IllegalArgumentException("Categoria desconocida: " + category);
        }
    }

    public static Hotel createHotelSunsol(){
        Hotel sunsol = new Hotel("Sunsol Caribe","hotel", "Margarita", 4.7F, LocalDate.parse("2024-12-01"), LocalDate.parse("2024-12-30"));
        sunsol.addRoom(new Room(1,"Simple", "1 cama sencilla, aire acondicionado, escritorio, TV", 80.00, 10,1,0));
        sunsol.addRoom(new Room(2,"Doble", "2 camas dobles, vista al mar, aire acondicionado, TV", 150.00, 8,2,2));
        sunsol.addRoom(new Room(3,"Suite", "1 cama King, jacuzzi, minibar, aire acondicionado, TV", 300.00, 5,2,0));
        sunsol.addRoom(new Room(4,"Familiar", "3 camas dobles, sala de estar, cocina equipada, aire acondicionado, TV", 250.00, 4,3,3));
        sunsol.addRoom(new Room(5,"Premium", "2 camas Queen, terraza privada, jacuzzi, minibar", 400.00, 2,2,2));

        return sunsol;
    }

    public static Hotel createHotelHesperia(){
        Hotel hesperia = new Hotel("Hotel Hesperia Isla Margarita", "hotel", "Margarita", 4.5F,LocalDate.parse("2024-12-01"), LocalDate.parse("2024-12-30"));
        hesperia.addRoom(new Room(1,"Estandar", "1 cama Queen, aire acondicionado, escritorio, TV", 100.00, 12,2,0));
        hesperia.addRoom(new Room(2,"Deluxe", "1 cama King, balcón con vista al mar, minibar, aire acondicionado", 180.00, 6,2,0));
        hesperia.addRoom(new Room(3,"Junior Suite", "1 cama King, sala pequeña, minibar, TV de pantalla plana", 250.00, 4,2,0));
        hesperia.addRoom(new Room(4,"Suite Ejecutiva", "1 cama King, sala de estar, jacuzzi, minibar, aire acondicionado", 350.00, 3,2,0));
        hesperia.addRoom(new Room(5,"Suite Presidencial", "1 cama King, terraza privada, piscina exclusiva, aire acondicionado", 500.00, 1,2,0));

        return hesperia;
    }

    public static Farm createFarmFincaMaribel(){
        Farm fincaMaribel = new Farm("Finca Maribel", "finca", "Margarita", 4.7F, LocalDate.parse("2024-12-01"), LocalDate.parse("2024-12-30"));
        fincaMaribel.addRoom(new Room(1,"Rústica Simple", "1 cama sencilla, ventilador, escritorio, baño privado", 50.00, 10,1,0));
        fincaMaribel.addRoom(new Room(2,"Rústica Familiar", "2 camas dobles, pequeña cocina, aire acondicionado, TV", 120.00, 5,2,2));
        fincaMaribel.addRoom(new Room(3,"Cabaña Rústica", "1 cama Queen, terraza con hamaca, minibar", 150.00, 3,2,0));
        fincaMaribel.addRoom(new Room(4,"Cabaña Deluxe", "1 cama King, terraza privada con vista al jardín, cocina equipada", 200.00, 2,2,0));
        fincaMaribel.addRoom(new Room(5,"Cabaña Premium", "1 cama King, sala de estar, jacuzzi exterior, minibar", 300.00, 1,2,0));
        return fincaMaribel;
    }

    public static SunnyDay createBahiaDorada(){
        SunnyDay bahiaDorada = new SunnyDay("Cabaña Vacacional Bahía Dorada","dia de sol", "Margarita", 4.7F, LocalDate.parse("2024-12-01"), LocalDate.parse("2024-12-30"));
        bahiaDorada.addRoom(new Room(1,"Cabaña Básica", "1 cama Queen, ventilador, baño privado, terraza", 80.00, 10,2,1));
        bahiaDorada.addRoom(new Room(2,"Cabaña Familiar", "2 camas dobles, sala pequeña, cocina equipada", 150.00, 6,2,2));
        bahiaDorada.addRoom(new Room(3,"Cabaña Deluxe", "1 cama King, jacuzzi privado, aire acondicionado, minibar", 200.00, 3,2,1));
        bahiaDorada.addRoom(new Room(4,"Cabaña Suite", "1 cama King, terraza privada con hamaca, minibar", 250.00, 2,2,0));
        bahiaDorada.addRoom(new Room(5,"Cabaña Presidencial", "1 cama King, terraza exclusiva, piscina privada, jacuzzi", 400.00, 1,2,0));
        SunnyDay.Activities snorkeling = new SunnyDay.Activities("Snorkeling", "Explora los arrecifes de coral con guía profesional");
        SunnyDay.Activities kayaking = new SunnyDay.Activities("Kayak", "Disfruta de un recorrido en kayak por la bahía");
        SunnyDay.Activities hiking = new SunnyDay.Activities("Senderismo", "Recorre los senderos naturales de la zona");
        bahiaDorada.addActivity(snorkeling);
        bahiaDorada.addActivity(kayaking);
        bahiaDorada.addActivity(hiking);

        return bahiaDorada;
    }

    public static Farm createPosadaBequeve(){
        Farm posadaBequeve = new Farm("Posada Bequeve", "finca", "Margarita", 4.7F, LocalDate.parse("2024-12-01"), LocalDate.parse("2024-12-30"));
        posadaBequeve.addRoom(new Room(1,"Habitación Básica", "1 cama Queen, ventilador, baño privado", 70.00, 8,2,0));
        posadaBequeve.addRoom(new Room(2,"Habitación Familiar", "2 camas matrimoniales, cocina equipada, aire acondicionado", 140.00, 5,2,2));
        posadaBequeve.addRoom(new Room(3,"Cabaña Rústica", "1 cama King, minibar, aire acondicionado", 180.00, 4,2,0));
        posadaBequeve.addRoom(new Room(4,"Cabaña Deluxe", "1 cama King, jacuzzi, terraza privada, cocina equipada", 250.00, 2,2,0));
        posadaBequeve.addRoom(new Room(5,"Cabaña Premium", "1 cama King, sala de estar, jacuzzi exterior, minibar", 320.00, 1,2,0));
        return  posadaBequeve;
    }

    public static Apartment createApartmentKasaKaribe(){
        Apartment kasaKaribe = new Apartment("Apartamento Kasa Karibe", "apartamento", "Margarita", 4.7F, "7", LocalDate.parse("2024-12-01"), LocalDate.parse("2024-12-30"));
        kasaKaribe.addRoom(new Room(1,"Estudio Básico", "1 cama Queen, cocina básica, TV", 90.00, 10,2,0));
        kasaKaribe.addRoom(new Room(2,"Loft Familiar", "2 camas matrimoniales, cocina equipada, aire acondicionado", 150.00, 6,2,2));
        kasaKaribe.addRoom(new Room(3,"Penthouse", "1 cama King, terraza con vista al mar, jacuzzi", 300.00, 2,2,0));
        kasaKaribe.addRoom(new Room(4,"Dúplex", "2 camas matrimoniales, sala y cocina completa", 180.00, 3,2,2));
        kasaKaribe.addRoom(new Room(5,"Estudio Premium", "1 cama King, minibar, aire acondicionado, TV", 120.00, 4,2,0));
        return kasaKaribe;
    }
    public static Apartment createApartmentCasaMaya(){
        Apartment casaMaya = new Apartment("Casa Maya Guesthouse", "apartamento", "Margarita", 4.7F, "7", LocalDate.parse("2024-12-01"), LocalDate.parse("2024-12-30"));
        casaMaya.addRoom(new Room(1,"Estudio", "1 cama Queen, cocina pequeña, aire acondicionado, TV", 90.00, 7,2,0));
        casaMaya.addRoom(new Room(2,"Loft", "1 cama King, sala de estar, cocina equipada", 130.00, 5,2,0));
        casaMaya.addRoom(new Room(3,"Penthouse", "1 cama King, terraza privada, jacuzzi, cocina equipada", 300.00, 2,2,0));
        casaMaya.addRoom(new Room(4,"Dúplex", "2 camas matrimoniales, cocina, sala de estar, aire acondicionado", 180.00, 3,2,2));
        casaMaya.addRoom(new Room(5,"Estudio Premium", "1 cama Queen, minibar, aire acondicionado", 120.00, 4,2,0));
        return casaMaya;
    }

    public static Hotel createHotelPalmBeach(){
        Hotel ldPalmBeach = new Hotel("LD Hotel Palm Beach", "hotel", "Margarita", 4.7F, LocalDate.parse("2024-12-01"), LocalDate.parse("2024-12-30"));
        ldPalmBeach.addRoom(new Room(1,"Económica", "1 cama matrimonial, aire acondicionado, TV", 60.00, 12,2,0));
        ldPalmBeach.addRoom(new Room(2,"Estándar", "1 cama Queen, balcón con vista parcial al mar, aire acondicionado", 100.00, 8,2,0));
        ldPalmBeach.addRoom(new Room(3,"Deluxe", "1 cama King, minibar, aire acondicionado, vista al mar", 150.00, 6,2,0));
        ldPalmBeach.addRoom(new Room(4,"Junior Suite", "1 cama King, sala pequeña, balcón con vista al mar, minibar", 200.00, 3,2,0));
        ldPalmBeach.addRoom(new Room(5,"Suite Ejecutiva", "1 cama King, sala de estar, jacuzzi, terraza privada con vista al mar", 300.00, 2,2,0));
        return ldPalmBeach;
    }
}
