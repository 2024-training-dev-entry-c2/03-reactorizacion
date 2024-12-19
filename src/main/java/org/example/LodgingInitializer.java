package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Aguilera / @aguileradev
 */
public class LodgingInitializer {

    public static List<Lodging> initializeLodgingList() {
        List<Lodging> lodgingList = new ArrayList<>();
        lodgingList.add(LodgingFactory.createHotelSunsol());
        lodgingList.add(LodgingFactory.createHotelHesperia());
        lodgingList.add(LodgingFactory.createFarmFincaMaribel());
        lodgingList.add(LodgingFactory.createBahiaDorada());
        lodgingList.add(LodgingFactory.createPosadaBequeve());
        lodgingList.add(LodgingFactory.createApartmentKasaKaribe());
        lodgingList.add(LodgingFactory.createApartmentCasaMaya());
        lodgingList.add(LodgingFactory.createHotelPalmBeach());

        return lodgingList;
    }
}
