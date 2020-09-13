package E5_CarSalesman;

public class Engine {

    private String model;
    private String power;
    private int displacement;
    private String efficiency;

    public Engine(String model, String power) {
        this(model, power, 0, "n/a");
    }

    public Engine(String model, String power, String efficiency) {
        this(model, power, 0, efficiency);
    }

    public Engine(String model, String power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, String power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel(){
        return this.model;
    }
    public String getPower(){
        return this.power;
    }
    public int getDisplacement(){
        return this.displacement;
    }
    public String getEfficiency (){
        return this.efficiency;
    }

    @Override
    public String toString(){
        int displ = getDisplacement();
        String result = "n/a";
        String print ;
        if(displ == 0){
            print = String.format("%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\n",
                    this.getModel(),this.getPower(),result,this.getEfficiency());
        }else{
            print = String.format("%s:\nPower: %s\nDisplacement: %d\nEfficiency: %s\n",
                    this.getModel(),this.getPower(),this.getDisplacement(),this.getEfficiency());
        }
        return print;
    }
}
