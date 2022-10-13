package com.github.chMatvey.hackerrank;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class BigDecimalSolution {
    @Getter
    static class NumberWrapper implements Comparable<NumberWrapper> {
        final BigDecimal number;
        final String view;

        NumberWrapper(String view) {
            this.number = new BigDecimal(view);
            this.view = view;
        }

        @Override
        public int compareTo(NumberWrapper o) {
            return number.compareTo(o.number);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stream.generate(scanner::next)
                .limit(scanner.nextInt())
                .map(NumberWrapper::new)
                .sorted(Comparator.reverseOrder())
                .map(NumberWrapper::getView)
                .forEach(System.out::println);
    }
}
