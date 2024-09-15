package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CowModel {
    private List<Cow> cows;

    public CowModel() {
        this.cows = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        try (FileReader reader = new FileReader("data/cows.json")) {
            Gson gson = new Gson();
            Type cowListType = new TypeToken<ArrayList<Cow>>() {}.getType();
            List<Cow> loadedCows = gson.fromJson(reader, cowListType);
            if (loadedCows != null) {
                this.cows.addAll(loadedCows);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<Cow> getCowById(String id) {
        return cows.stream().filter(cow -> cow.getId().equals(id)).findFirst();
    }

    public boolean isCompleteCow(Cow cow) {
        return cow.getAgeYears() >= 0 && cow.getAgeMonths() >= 0 && (cow.getTeats() == 3 || cow.getTeats() == 4);
    }

    public boolean isBasicCow(String id) {
        Optional<Cow> cowOptional = getCowById(id);
        if (cowOptional.isPresent()) {
            Cow cow = cowOptional.get();
            return cow.getAgeYears() >= 0 && cow.getAgeMonths() >= 0 && (cow.getTeats() == 3 || cow.getTeats() == 4);
        }
        return false;
    }

    public void removeGoatById(String id) {
        cows.removeIf(cow -> cow.getId().equals(id));
        saveData();
    }

    private void saveData() {
        try (FileWriter writer = new FileWriter("data/cows.json")) {
            Gson gson = new Gson();
            gson.toJson(cows, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
