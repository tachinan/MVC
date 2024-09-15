package models;

public class GoatModel {
    public boolean isGoat(String id, CowModel cowModel) {
        // If cow model doesn't have this ID or it's not a valid cow, then it's a goat
        return !cowModel.isBasicCow(id);
    }
}
