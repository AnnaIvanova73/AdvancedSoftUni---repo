package rabbitsColegueRefactor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int count() {
        return data.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit) {
        if (capacity > data.size()) {
            data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        for (Rabbit rabbit : this.data) {
            String searchedName = rabbit.getName();
            if (searchedName.equals(name)) {
                return this.data.remove(rabbit);
            }
        }
        return false;
    }

    public Rabbit[] removeSpecies(String species) {
        Rabbit[] removed = data.stream().filter(rabbit -> species.equals(rabbit.getSpecies())).toArray(Rabbit[]::new);

        for (Rabbit rabbit : removed) {
            data.remove(rabbit);
        }
        return removed;
    }

    public Rabbit sellRabbit(String name) {
        int index = 0;
        for (Rabbit rabbit : data) {
            String searchedName = rabbit.getName();
            if (searchedName.equals(name)) {
                rabbit.setAvailable(false);
                index = data.indexOf(searchedName);
                return rabbit;
            }
        }
        return data.get(index);
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> removed = data.stream().filter(rabbit -> species.equals(rabbit.getSpecies())).collect(Collectors.toList());

        for (Rabbit rabbit : removed) {
            boolean remove = data.remove(rabbit.getName());
            rabbit.setAvailable(false);
        }
        return removed;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Rabbits available at %s:", this.getName()));
        sb.append(System.lineSeparator());
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()) {
                sb.append(rabbit.toString());
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
