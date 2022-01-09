package examples.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {
    public static void main(String[] args) {

        // This function does two things - checks correctness of y and then does main thing - division
        // In functional programming that's clear sign it should be refactored

        // BiFunction<Float, Float, Float> divide = (x, y) -> {
        //     if (y == 0f) {
        //         System.out.println("Error, cannot divide by 0!");
        //         return 0f;
        //     }
        //     return x / y;
        // };

        // function that makes one thing - division
        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        // function that takes other function as an argument and returns similar function
        // returned function is 'wrapped' by additional  check of second argument (if not zero)
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> checkIfYIsNotZero =
                (func) -> (x, y) -> {
                    if (y == 0f) {
                        System.out.println("Error, cannot divide by 0!");
                        return 0f;
                    }
                    return func.apply(x, y);
                };

        // declare function that is 'divide' function wrapped with additional check of second argument
        BiFunction<Float, Float, Float> divideSafe = checkIfYIsNotZero.apply(divide);

        System.out.println(divideSafe.apply(10f, 0f));
        System.out.println(divideSafe.apply(10f, 2f));

    }
}
