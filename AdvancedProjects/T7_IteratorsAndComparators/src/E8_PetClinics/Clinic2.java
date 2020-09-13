package E8_PetClinics;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.Iterator;

public class Clinic2 implements Iterable<Pet> {
    private Pet[] pets;
    private int capacity;
    private int middleRoom;
    private int iterationIndex;

    public void setCapacity(int capacity) {
        checkIsRoomCountInOrder(capacity);
        this.capacity = capacity;
    }

    private void checkIsRoomCountInOrder(int capacity) {
        if (capacity % 2 == 0) {
            String message = "Invalid Operation!";
            throw new InvalidDnDOperationException(message);
        }
    }

    public Clinic2(int capacity) {
        this.setCapacity(capacity);
        this.middleRoom = (capacity / 2);
        pets = new Pet[capacity];
    }

    public boolean addPet(Pet currPet) {
        if (currPet == null) {
            return false;
        }

        if (this.pets[middleRoom] == null) {
            this.pets[middleRoom] = currPet;
            return true;
        }

        int right = middleRoom;
        int left = middleRoom;
        this.iterationIndex = middleRoom;
        while (iterationIndex-- > 0) {

            if (pets[--left] == null) {
                pets[left] = currPet;
                return true;
            }

            if (pets[++right] == null) {
                pets[right] = currPet;
                return true;
            }

        }
        return false;
    }

    public boolean releasePet() {
        this.iterationIndex = middleRoom;

        for (int i = iterationIndex; i < this.capacity; i++) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
                return true;
            }
        }

        for (int i = 0; i < iterationIndex; i++) {
            if (this.pets[i] != null) {
                this.pets[i] = null;
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
            Pet pet = pets[index];
            System.out.println(pet.toString());
        } catch (Exception e) {
            System.out.println("Room empty");
        }
    }


    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }
}
