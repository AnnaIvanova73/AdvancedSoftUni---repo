package E8_PetClinics;

public class Pet {
    private String petName;
    private int petAge;
    private String kind;

    public void setPetName(String petName) {
        this.petName = petName;
    }
    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }
    public void setPetKind (String kind) {
        this.kind = kind;
    }


    public Pet(String petName, int petAge, String kind) {
      this.setPetName(petName);
      this.setPetAge(petAge);
      this.setPetKind(kind);

    }

    public String getPetName() {
        return this.petName;
    }

    public int getPetAge() {
        return this.petAge;
    }

    public String getKind() {
        return this.kind;
    }

    @Override
    public String toString(){
        return String.format("%s %d %s",this.getPetName(),this.getPetAge(),this.getKind());
    }

}
