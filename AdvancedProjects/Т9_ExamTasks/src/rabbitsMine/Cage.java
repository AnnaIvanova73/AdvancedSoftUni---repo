package rabbitsMine;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    private void setName(String name) {
        this.name = name;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Cage(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.getCapacity()) {
            this.data.add(rabbit);
        }
    }


    public boolean removeRabbit(String name) {
        Rabbit rabbitt = null;
        boolean isRemoved = false;
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbitt = rabbit;
                isRemoved = true;
                break;
            }
        }
        data.remove(rabbitt);
        return isRemoved;
    }

    public boolean removeSpecies(String species) {
        boolean hasSomethingToRemove = false;
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                removeRabbit(rabbit.getName());
                hasSomethingToRemove = true;
            }
        }
        return hasSomethingToRemove;
    }

    public Rabbit sellRabbit(String name) {
        Rabbit current = null;

        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return current;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitsFromCurrentSpecies = new ArrayList<>();

        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                sellRabbit(rabbit.getName());
                rabbitsFromCurrentSpecies.add(rabbit);
            }
        }
        return rabbitsFromCurrentSpecies;

        //return this.data.stream().filter(e -> e.getSpecies().equals(species)).collect(Collectors.toList());
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Rabbits available at ").append(this.getName()).append(":").append(System.lineSeparator());
        this.data.stream().filter(Rabbit::isAvailable).forEach(rab -> report.append(rab).append(System.lineSeparator()));
        return report.toString();
    }

}
