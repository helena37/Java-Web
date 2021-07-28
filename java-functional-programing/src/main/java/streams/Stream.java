package streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static streams.Stream.Gender.FEMALE;
import static streams.Stream.Gender.MALE;

public class Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

//        people.stream()
//                .map(person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "name: " + name
                    + "\ngender: " + gender
                    + "\n*********";
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
