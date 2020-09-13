package E4_RawData;

public class Tires {
    private double firstPressure;
    private int firstAge;
    private double secondPressure;
    private int secondAge;
    private double thirdPressure;
    private int thirdAge;
    private double fourthPressure;
    private int fourthAge;

    public Tires (double firstPr,int firstAge, double secondPr, int secondAge, double thirdPr, int thirdAge, double fourthPr, int fourthAge){
        this.firstPressure = firstPr;
        this.firstAge = firstAge;
        this.secondPressure = secondPr;
        this.secondAge = secondAge;
        this.thirdPressure = thirdPr;
        this.thirdAge = thirdAge;
        this.fourthPressure = fourthPr;
        this.fourthAge = fourthAge;
    }

    public double getFirstPressure() {
        return firstPressure;
    }

    public double getSecondPressure() {
        return secondPressure;
    }

    public double getThirdPressure() {
        return thirdPressure;
    }

    public double getFourthPressure() {
        return fourthPressure;
    }
}
