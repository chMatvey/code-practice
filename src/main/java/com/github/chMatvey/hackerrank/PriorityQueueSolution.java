package com.github.chMatvey.hackerrank;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PriorityQueueSolution {
    @Getter
    @AllArgsConstructor
    static class Student {
        private final int id;
        private final String name;
        private final double cgpa;
    }

    static Comparator<Student> STUDENT_COMPARATOR = (s1, s2) -> {
        int result = Double.compare(s1.getCgpa(), s2.getCgpa()) * -1;
        if (result == 0) {
            result = s1.getName().compareTo(s2.getName());
            if (result == 0) result = Integer.compare(s1.getId(), s2.getId());
        }
        return result;
    };

    static class Priorities {
        static final String ENTER = "ENTER";
        static final String SERVED = "SERVED";

        List<Student> getStudents(List<String> events) {
            if (events.isEmpty()) return new ArrayList<>();
            Queue<Student> queue = new PriorityQueue<>(events.size(), STUDENT_COMPARATOR);

            for (String event : events) {
                if (SERVED.equals(event)) {
                    queue.poll();
                } else {
                    String[] strings = event.split(" ");
                    if (strings.length != 4 || !ENTER.equals(strings[0]))
                        throw new IllegalArgumentException("Incorrect event");

                    String name = strings[1];
                    double cgpa = Double.parseDouble(strings[2]);
                    int id = Integer.parseInt(strings[3]);

                    Student student = new Student(id, name, cgpa);
                    queue.add(student);
                }
            }
            return queue.stream().sorted(STUDENT_COMPARATOR).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> events = Stream.generate(scanner::nextLine)
                .map(String::trim)
                .filter(event -> !event.isEmpty())
                .limit(scanner.nextInt())
                .collect(Collectors.toList());

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    }
}
