package E5_CarSalesman;

public class Car {
    private String car;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String car, Engine engine) {
        this(car, engine, 0, "n/a");
    }

    public Car(String car, Engine engine, int weight) {
        this(car, engine, weight, "n/a");
    }

    public Car(String car, Engine engine, String color) {
        this(car, engine, 0, color);
    }


    public Car(String car, Engine engine, int weight, String color) {
        this.car = car;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getCar() {
        return this.car;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        int weight = getWeight();
        String result = "n/a";
        String print;
        if (weight == 0) {
            print = String.format("%s:%n%sWeight: %s%nColor: %s",this.getCar(),this.getEngine(),result,this.getColor());
        } else {
            print = String.format("%s:%n%sWeight: %d%nColor: %s",this.getCar(),this.getEngine(),this.getWeight(),this.getColor());
        }
        return print;
    }
}
