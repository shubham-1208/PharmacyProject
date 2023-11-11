package com.pharmacy.app;

import java.io.*;
import java.util.*;

public class Pharmacy {
    private List<Medicine> medicines = new ArrayList<>();
    private String dataFile = "medicines.ser";

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
        saveMedicines();
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }
    
    public void sortByName() {
        Collections.sort(medicines);
    }

    public void sortByType() {
        Collections.sort(medicines, new MedicineTypeComparator());
    }

    public void sortByAvailability() {
        Collections.sort(medicines, new MedicineAvailabilityComparator());
    }

    public void printMedicines() {
        for (Medicine medicine : medicines) {
            System.out.println(medicine);
        }
    }

    public void saveMedicines() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            out.writeObject(medicines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadMedicines() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(dataFile))) {
            medicines = (List<Medicine>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class MedicineTypeComparator implements Comparator<Medicine> {
        @Override
        public int compare(Medicine medicine1, Medicine medicine2) {
            return medicine1.getType().compareTo(medicine2.getType());
        }
    }

    private static class MedicineAvailabilityComparator implements Comparator<Medicine> {
        @Override
        public int compare(Medicine medicine1, Medicine medicine2) {
            return Integer.compare(medicine1.getAvailable(), medicine2.getAvailable());
        }
    }
}
