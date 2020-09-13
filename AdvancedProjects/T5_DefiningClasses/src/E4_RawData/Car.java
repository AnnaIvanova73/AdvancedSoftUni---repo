package E4_RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tires tires;


    public Car(String model, Engine engine, Cargo cargo, Tires tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return  this.model;
    }

    public Cargo getCargoClass() {
        return this.cargo;
    }

    public Engine getEngineClass() {
        return this.engine;
    }

    public Tires getTiresClass() {
        return this.tires;
    }
}
