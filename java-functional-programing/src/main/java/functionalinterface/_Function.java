package functionalinterface;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, give me a number to increment!");
        int increment = incrementByOne(Integer.parseInt(sc.nextLine()));

        System.out.println("Increment1: " + increment);

        System.out.println("Please, enter your value:");
        int increment2 = incrementByOneFunction.apply(Integer.parseInt(sc.nextLine()));

        System.out.println("Increment2: " + increment2);

        int multiply = multiplyBy10Function.apply(increment2);

        System.out.println("Multiply Function: " + multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);

        System.out.println("Please, choose a number to add 1 and multiply by 10: ");
        int lastNumber = addBy1AndThenMultiplyBy10.apply(Integer.parseInt(sc.nextLine()));

        System.out.println(lastNumber);

        //BiFunction takes 2 arguments and produces 1 result
        System.out.println("BiFunction Result: " + incrementByOneAndMultiply(5, 10));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
            (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
