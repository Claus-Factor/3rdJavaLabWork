package com.labs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {

    public static void main(String[] args) {
        int iterations = 100000; // количество операций
        comparePerformance(iterations);
    }

    public static void comparePerformance(int iterations) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        System.out.printf("%-15s | %-10s | %-15s | %-15s%n", "Method", "Iterations", "ArrayList (ms)", "LinkedList (ms");
        System.out.println("-------------------------------------------------------------");

        // Test add method
        System.out.printf("%-15s | %-10d | %-15d | %-15d%n",
                "add", iterations, testAdd(arrayList, iterations), testAdd(linkedList, iterations));

        // Test get method
        System.out.printf("%-15s | %-10d | %-15d | %-15d%n",
                "get", iterations, testGet(arrayList, iterations), testGet(linkedList, iterations));

        // Test delete method
        System.out.printf("%-15s | %-10d | %-15d | %-15d%n",
                "delete", iterations, testDelete(arrayList), testDelete(linkedList));
    }



    private static long testAdd(List<Integer> list, int iterations) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long testGet(List<Integer> list, int iterations) {
        // Ensure the list is filled
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.get(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long testDelete(List<Integer> list) {
        // Ensure the list is filled
        for (int i = 0; i < list.size(); i++) {
            list.add(i);
        }
        long startTime = System.currentTimeMillis();
        while (!list.isEmpty()) {
            list.remove(0); // удаляем из начала списка
        }
        return System.currentTimeMillis() - startTime;
    }
}
