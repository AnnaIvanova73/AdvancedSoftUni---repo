package E8_PetClinics;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Pet> {
    private String name;
    private List<Pet> pets;
    private int capacity;
    private int middleRoom;


    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        checkIsRoomCountInOrder(capacity);
        this.capacity = capacity;
    }

    private void checkIsRoomCountInOrder(int capacity) {
        if (capacity % 2 != 0) {
            middleRoom = (capacity / 2);
        } else {
            String message = "Invalid Operation!";
            throw new InvalidDnDOperationException(message);
        }
    }

    public Clinic(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        pets = new ArrayList<>();
        putRooms(capacity);
    }

    private void putRooms(int capacity) {
        for (int i = 0; i < capacity; i++) {
            this.getPets().add(i, null);
        }
    }

    public boolean addPet(Pet currPet) {
            if(currPet == null){
                return false;
            }

        if (pets.get(middleRoom) == null) {
            pets.set(middleRoom, currPet);
            return true;
        }

        int right = middleRoom;
        int left = middleRoom;
        int iterations = middleRoom;
        while (iterations-- > 0) {

            if (pets.get(--left) == null) {
                pets.set(left, currPet);
                return true;
            }

            if (pets.get(++right) == null) {
                pets.set(right, currPet);
                return true;
            }

        }
        return false;
    }

    public boolean releasePet() {

        for (int i = this.middleRoom; i < this.getCapacity(); i++) {
            if (this.getPets().get(i) != null) {
                this.getPets().set(i,null);
                return true;
            }
        }

        for (int i = 0; i < this.middleRoom; i++) {
            if (this.getPets().get(i) != null) {
                this.getPets().set(i,null);
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet pet : pets) {
            if (pet == null) {
                return true;
            }
        }
        return false;
    }

    public void printCurrentPet(int index) {
        try {
            Pet pet = this.getPets().get(index);
            System.out.println(pet.toString());
        } catch (Exception e) {
            System.out.println("Room empty");
        }
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.size();
            }

            @Override
            public Pet next() {
                return pets.get(index++);
            }
        };
    }
}
