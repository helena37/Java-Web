package finalsection;

import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseName = name -> {
            //logic
            if (name.isBlank()) {
                throw new IllegalArgumentException("");
            }
            return name.toUpperCase();
        };

        String upperCasedName = upperCaseName.apply("Alex");
        System.out.println(upperCasedName);
    }
}
