package lib;

public enum AccommodationType {
    HOTEL("Hotel"),
    APARTMENT("Apartamento"),
    LAND("Finca"),
    SUNNYDAY("Día de Sol");

    private final String type;

  AccommodationType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}