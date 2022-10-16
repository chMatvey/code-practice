package com.github.chMatvey.codewars;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SumOfDivided {
    public static String sumOfDivided(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .map(NumberToPrimeFactors::new)
                .reduce(new HashMap<>(), REDUCER, (m1, m2) -> m1)
                .entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(entry -> String.format("(%d %d)", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

    private static Set<Integer> primeFactors(int number) {
        Set<Integer> result = new HashSet<>();
        if (number < 0)
            number *= -1;
        for (int i = 2; i < number; i++) {
            while (number % i == 0) {
                result.add(i);
                number /= i;
            }
        }
        if (number > 2)
            result.add(number);

        return result;
    }

    private static class NumberToPrimeFactors {
        final int number;
        final Set<Integer> primeFactors;

        NumberToPrimeFactors(int number) {
            this.number = number;
            this.primeFactors = primeFactors(number);
        }
    }

    private final static BiFunction<Map<Integer, Integer>, NumberToPrimeFactors, Map<Integer, Integer>> REDUCER =
            (map, numberToPrimeFactors) -> {
                for (Integer factor : numberToPrimeFactors.primeFactors) {
                    Integer sum = map.get(factor);
                    if (sum == null) {
                        map.put(factor, numberToPrimeFactors.number);
                    } else {
                        map.replace(factor, sum + numberToPrimeFactors.number);
                    }
                }
                return map;
            };
}
