package com.github.chMatvey.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PriorityQueueSolutionTest {
    @Test
    void test1() {
        String input = """
                ENTER Bidhan 3.75 50
                ENTER Rijul 3.8 24
                ENTER Shafaet 3.7 35
                SERVED
                SERVED
                ENTER Samiha 3.85 36
                SERVED
                ENTER Ratul 3.9 42
                ENTER Tanvir 3.6 46
                ENTER Anik 3.95 49
                ENTER Nisha 3.95 50
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED""";
        List<String> events = Arrays.stream(input.split("\n")).toList();
        PriorityQueueSolution.Priorities priorities = new PriorityQueueSolution.Priorities();
        List<PriorityQueueSolution.Student> students = priorities.getStudents(events);

        assertTrue(students.isEmpty());
    }

    @Test
    void test2() {
        String input = """
                ENTER John 3.75 50
                ENTER Mark 3.8 24
                ENTER Shafaet 3.7 35
                SERVED
                SERVED
                ENTER Samiha 3.85 36
                SERVED
                ENTER Ashley 3.9 42
                ENTER Maria 3.6 46
                ENTER Anik 3.95 49
                ENTER Dan 3.95 50
                SERVED""";

        List<String> events = Arrays.stream(input.split("\n")).toList();
        PriorityQueueSolution.Priorities priorities = new PriorityQueueSolution.Priorities();
        List<PriorityQueueSolution.Student> students = priorities.getStudents(events);
        List<String> names = students.stream().map(PriorityQueueSolution.Student::getName).toList();

        assertEquals(List.of("Dan", "Ashley", "Shafaet", "Maria"), names);
    }

    @Test
    void test3() {
        String input = """
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED
                SERVED""";

        List<String> events = Arrays.stream(input.split("\n")).toList();
        PriorityQueueSolution.Priorities priorities = new PriorityQueueSolution.Priorities();
        List<PriorityQueueSolution.Student> students = priorities.getStudents(events);

        assertTrue(students.isEmpty());
    }
}