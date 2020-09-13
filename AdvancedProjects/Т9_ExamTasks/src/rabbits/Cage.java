package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean removeRabbit(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeSpecies(String species) {
        boolean hasSomethingToRemove = false;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getSpecies().equals(species)) {
                data.remove(i);
                hasSomethingToRemove = true;
                i--;
            }
        }
        return hasSomethingToRemove;
    }

    public void add(Rabbit rabbit) {
        if (data.size() < capacity) {
            data.add(rabbit);
        }
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = null;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                rabbit = data.get(i);
                rabbit.setAvailable(false);
                break;
            }
        }
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> ready = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getSpecies().equals(species)) {
                ready.add(data.get(i));
                data.remove(i);
                i--;
            }
        }
        return ready;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:", this.getName()));
        sb.append(System.lineSeparator());
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()) {
                sb.append(rabbit.toString());
                sb.append(System.lineSeparator());
            }

        }
        return sb.toString();
    }
}
