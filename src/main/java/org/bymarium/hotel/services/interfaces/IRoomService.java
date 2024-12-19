package org.bymarium.hotel.services.interfaces;

import org.bymarium.hotel.models.Accommodation;
import org.bymarium.hotel.models.DetailsStay;
import org.bymarium.hotel.models.Room;

import java.util.List;

public interface IRoomService {
  List<Room> selectRooms(Accommodation accommodation, DetailsStay detailsStay);
}
