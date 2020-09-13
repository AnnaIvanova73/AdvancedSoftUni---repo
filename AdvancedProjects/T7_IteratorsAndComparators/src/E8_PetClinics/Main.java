package E8_PetClinics;

import java.awt.dnd.InvalidDnDOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countInput = Integer.parseInt(reader.readLine());

        Map<String, Clinic2> clinicsData = new HashMap<>();
        Set<Pet> enterPets = new HashSet<>();

        for (int i = 0; i < countInput; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    if (tokens[1].equals("Pet")) {
                        Pet pet = new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
                        enterPets.add(pet);
                    } else {
                        try {
                            Clinic2 clinic = new Clinic2(Integer.parseInt(tokens[3]));
                            clinicsData.putIfAbsent(tokens[2], clinic); // is there a possibility for input with clinic that is already in the Map?

                        } catch (InvalidDnDOperationException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String namePet = tokens[1];
                    Pet pet = getPet(enterPets, namePet);
                    String currentClinic = tokens[2];
                    if (clinicsData.containsKey(currentClinic)) {
                        System.out.println(clinicsData.get(currentClinic).addPet(pet));
                    }
                    break;
                case "Release":
                    if (clinicsData.containsKey(tokens[1])) {
                        System.out.println(clinicsData.get(tokens[1]).releasePet());
                    }
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinicsData.get(tokens[1]).hasEmptyRooms());
                    break;
                case "Print":
                    String clinicPerPrint = tokens[1];
                    try {
                        int printCurrentRoom = Integer.parseInt(tokens[2]) - 1;
                        clinicsData.get(clinicPerPrint).printCurrentPet(printCurrentRoom);

                    } catch (IndexOutOfBoundsException e) {
                        Clinic2 clinic = clinicsData.get(clinicPerPrint);
                      //  Clinic clinic = clinicsData.get(clinicPerPrint);
                        for (Pet pet1 : clinic) {
                            if(pet1 == null){
                                System.out.println("Room empty");
                            }else{
                                System.out.println(pet1.toString());
                            }
                        }
                    }
                    break;
            }

        }
    }

    private static Pet getPet(Set<Pet> enterPets, String namePet) {
        Pet pet = null;
        for (Pet enterPet : enterPets) {
            if (namePet.equals(enterPet.getPetName())) {
                pet = enterPet;
                enterPets.remove(pet);
                break;
            }
        }
        return pet;
    }
}
