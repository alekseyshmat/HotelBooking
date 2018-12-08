package entity.types;

public enum PlaceType {
    SINGLE("single"),
    DOUBLETWIN("doubleTwin"),
    TWIN("twin"),
    TRIPLE("tripple"),
    QUADRIPLE("quadriple");

    String placeType;

    PlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }
}
