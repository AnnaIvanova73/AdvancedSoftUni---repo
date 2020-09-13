package healthyHeaven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {
        Salad salad = this.data.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        return this.data.remove(salad);
    }

    public Salad getHealthiestSalad() {
       return this.data.stream().min(Comparator.comparingInt(Salad::getTotalCalories)).orElse(null);
    }


    public String generateMenu() {
        StringBuilder perPrint = new StringBuilder();
        perPrint.append(String.format("%s have %d salads:", this.name, this.data.size()));
        perPrint.append(System.lineSeparator());
        this.data.forEach(e -> perPrint.append(e.toString()).append(System.lineSeparator()));
        return perPrint.toString().trim();
    }
}
