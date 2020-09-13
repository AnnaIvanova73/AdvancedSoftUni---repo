package E5_ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person (String name, int age, String town){
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }


    public String getName (){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person other) {
        if(!this.getName().equals(other.getName())
                || this.getAge() != other.getAge()
                || !this.getTown().equals(other.getTown())){
            return -1;
        }
      return 0;
    }
}
