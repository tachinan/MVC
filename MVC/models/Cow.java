package models;

public class Cow {
    private String id;
    private int ageYears;
    private int ageMonths;
    private int teats;

    public Cow(String id, int ageYears, int ageMonths, int teats) {
        this.id = id;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.teats = teats;
    }

    public String getId() {
        return id;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public int getTeats() {
        return teats;
    }

    public void setTeats(int teats) {
        this.teats = teats;
    }
}
