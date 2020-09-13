package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.getCapacity()) {
            data.add(present);
        }
    }

    public Present heaviestPresent() {
        Present current = null;
        double max = data.get(0).getWeight();
        for (Present present : data) {
            if (max < present.getWeight()) {
                max = present.getWeight();
                current = present;
            }
        }
        return current;
    }

    public Present getPresent(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public boolean remove(String name) {

        Present current = null;
        for (Present present : data) {
            if (present.getName().equals(name)) {
                current = present;
                break;
            }
        }
        return data.remove(current);
    }


    public String report() {
        StringBuilder perPrint = new StringBuilder();
        perPrint.append(this.getColor()).append(" bag contains:").append(System.lineSeparator());
        for (Present present : data) {
            perPrint.append(present.toString().trim()).append(System.lineSeparator());
        }
        return perPrint.toString().trim();
    }

    //•	getColor()
//•	getCapacity()
//•	count() method– returns the number of presents
//•	add(Present present) method – adds an entity to the data if there is room for it
//•	remove(String name) method – removes an present by given name, if such exists,
//and returns boolean
//•	heaviestPresent() method – returns the heaviest present
//•	getPresent(String name) method – returns the present with the given name
//•	report() method – returns a string in the following format (print the presents in order of appearance):
//o	"{color of Bag} bag contains:
//{Present1}
//{Present2}
//(…)"

}
