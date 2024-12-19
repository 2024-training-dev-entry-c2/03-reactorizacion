package org.example;

import java.util.List;

/**
 *
 * @author Manuel Aguilera / @aguileradev
*/public class LodgingData {

    private static final LodgingData INSTANCE = new LodgingData();

    private List<Lodging> lodgingList;

    private LodgingData() {
        this.lodgingList = LodgingInitializer.initializeLodgingList();
    }

    public static LodgingData getInstance() {
        return INSTANCE;
    }

    public List<Lodging> getLodgingList() {
        return lodgingList;
    }
}
