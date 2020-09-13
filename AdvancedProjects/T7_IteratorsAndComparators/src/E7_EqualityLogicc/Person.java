package E7_EqualityLogicc;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }


    @Override
    public boolean equals(Object other) {
        /*
        Метода по default;

             if (this == other) { // стрингове по референция, паметта им еднаква ли е. текущ обект с дадения;
            return true;
        }
        if (other == null || getClass() != other.getClass()) { //ако подадения е със стойност нул или текущия обект
         е различен от подадения връщаме false, по реф. на  класовете
            //може и other.getClass.getSimpleName().equals(Person.class.getSimpleName()) по имена, по стрингове
            return false;
        }
        Person person = (Person) other; // сигурни сме, че other Object е от Person след проверките - кастване, за да достъпим клас членовете
        return age == person.age &&  // ако годините и имената са равни връщаме true;
                Objects.equals(name, person.name);

         */

        if (this.hashCode() == other.hashCode()) {
            return true;
        }
        if (other.getClass().getSimpleName().equals(Person.class.getSimpleName())) {
            Person current = (Person) other;
            return this.name.equals(current.getName()) && this.age == current.getAge();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + age;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        return hash;

        //return Objects.hash(name, age); default method

        //   @Override
        //    public int hashCode() {
        //        return this.getName().hashCode() + Integer.hashCode(this.getAge()) * 31;
        //    }
    }

    @Override
    public int compareTo(Person other) {
        return Comparator.comparing(Person::getName).thenComparing(Person::getAge).compare(this, other);
    }
}
