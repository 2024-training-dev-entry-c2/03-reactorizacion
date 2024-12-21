package lib;

import java.util.HashMap;
import java.util.Map;

public class AccommodationTypeUtil {
  private static final Map<Integer, AccommodationType> ACCOMMODATION_TYPE_MAP = new HashMap<>();

  static {
    ACCOMMODATION_TYPE_MAP.put(1, AccommodationType.HOTEL);
    ACCOMMODATION_TYPE_MAP.put(2, AccommodationType.APARTMENT);
    ACCOMMODATION_TYPE_MAP.put(3, AccommodationType.LAND);
    ACCOMMODATION_TYPE_MAP.put(4, AccommodationType.SUNNYDAY);
  }

  public static AccommodationType fromInt(int index) {
    return ACCOMMODATION_TYPE_MAP.getOrDefault(index, throwInvalidIndexException(index));
  }

  private static AccommodationType throwInvalidIndexException(int index) {
    throw new IllegalArgumentException("Invalid index for AccommodationType: " + index);
  }
}