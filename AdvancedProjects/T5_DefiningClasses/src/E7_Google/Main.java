package E7_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> personsData = new LinkedHashSet<>();

        String line;
        while (!(line = reader.readLine()).equals("End")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String argument = tokens[1];

            boolean isAlreadyExist = personsData.stream().anyMatch(a -> a.getName().equals(name));

            Person person;

            if (!isAlreadyExist) {
                person = new Person(name);
                personsData.add(person);
            } else {
                person = findPerson(name, personsData);
            }

            switch (argument) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    assert person != null;
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    assert person != null;
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthDay = tokens[3];
                    Parents parents = new Parents(parentName, parentBirthDay);

                    assert person != null;
                    person.addParent(parents);

                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthDay = tokens[3];
                    Children children = new Children(childName, childBirthDay);
                    assert person != null;
                    person.addChild(children);

                    break;
                case "car":
                    String carModel = tokens[2];
                    double carSpeed = Double.parseDouble(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    assert person != null;
                    person.setCar(car);
                    break;
            }

        }
        String personNeeded = reader.readLine();

        personsData.forEach(a -> {
            String name = a.getName();
            if (name.equals(personNeeded)) {
                System.out.println(a.getName());
                System.out.println("Company:");
                if (a.getCompany() != null) {
                    System.out.println(String.format("%s %s %.2f",
                            a.getCompany().getCompanyName(), a.getCompany().getDepartment(), a.getCompany().getSalary()));
                }
                System.out.println("Car:");
                if (a.getCar() != null) {
                    System.out.println(String.format("%s %.0f", a.getCar().getCarModel(), a.getCar().getCarSpeed()));
                }
                System.out.println("Pokemon:");
                a.getPokemonList().forEach(p -> System.out.println(p.getPokemonName() + " " + p.getPokemonType()));
                System.out.println("Parents:");
                a.getParentsList().forEach(parent -> System.out.println(parent.getParentName() + " " + parent.getParentBirth()));
                System.out.println("Children:");
                a.getChildrenList().forEach(c -> System.out.println(c.getChildName() + " " + c.getChildBirth()));
            }
        });
    }

    private static Person findPerson(String name, Set<Person> personsData) {
        for (Person personsDatum : personsData) {
            if (personsDatum.getName().equals(name)) {
                return personsDatum;
            }
        }
        return null;
    }
}
