package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

/**
 * @author helena81
 * @version 1.0
 * @since 12.05.22
 */
public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        System.out.println("//Imperative approach:");
        //Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person female : people) {
            if (FEMALE.equals(female.gender)) {
                females.add(female);
            }
        }

        for (Person female : females) {
            System.out.println(female.toString());
        }

        System.out.println("//Declarative approach:");
        //Declarative approach
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return String.format("name: %s%ngender: %s%n",
                    this.name, this.gender);
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
