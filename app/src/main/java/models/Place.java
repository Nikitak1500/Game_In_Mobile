package models;

public class Place {
    private int idplace;
    private int placeValue;
    private User iduser;
    private Raiting idraiting;

    public Place(int idplace, int placeValue,
                 User iduser, Raiting idraiting) {
        this.idplace = idplace;
        this.placeValue = placeValue;
        this.iduser = iduser;
        this.idraiting = idraiting;
    }

    public int getIdplace() {
        return idplace;
    }

    public void setIdplace(int idplace) {
        this.idplace = idplace;
    }

    public int getPlaceValue() {
        return placeValue;
    }

    public void setPlaceValue(int placeValue) {
        this.placeValue = placeValue;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Raiting getIdraiting() {
        return idraiting;
    }

    public void setIdraiting(Raiting idraiting) {
        this.idraiting = idraiting;
    }
}
