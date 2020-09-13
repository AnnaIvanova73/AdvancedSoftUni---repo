package L2_Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand) {
        this(brand, "unknown", -1);
//        this.brand = brand;
//        this.model = "unknown";
//        this.horsePower = -1;
    }

    public Car(String brand, String model) {
        this(brand, model, -1);
//        this.brand = brand;
//        this.model = model;
//        this.horsePower = -1;
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }


    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }

}

