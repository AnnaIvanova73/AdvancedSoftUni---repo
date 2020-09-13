package E9_CatLady;

public class Cats {
    private String name;
    private String type;
    private double characteristics;

    public Cats(String name,String type, double character) {
        this.name = name;
        this.type = type;
        this.characteristics = character;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public double getCharacteristics() {
        return this.characteristics;
    }


}
