package com.labs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListPerformanceComparison {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int iterations;
        System.out.println("Введите количество операция для проверки: ");
        iterations = scanner.nextInt();

//        iterations = 100000; // количество операций

        comparePerformance(iterations);
    }

    public static void comparePerformance(int iterations) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Создаем таблицу для вывода результатов
        System.out.printf("%-15s | %-10s | %-15s | %-15s%n", "Method", "Operations", "ArrayList (ms)", "LinkedList (ms");
        System.out.println("---------------------------------------------------------------");

        // Тестируем метод add
        testMethod("add", iterations, new ArrayList<>(), new LinkedList<>());

        // Тестируем метод get
        testMethod("get", iterations, new ArrayList<>(), new LinkedList<>());

        // Тестируем метод remove
        testMethod("remove", iterations, new ArrayList<>(), new LinkedList<>());
    }



    private static void testMethod(String methodName, int iterations, List<Integer> arrayList, List<Integer> linkedList) {
        long arrayListTime = 0;
        long linkedListTime = 0;

        // Подготовка данных для методов get и remove
        if (methodName.equals("get") || methodName.equals("remove")) {
            for (int i = 0; i < iterations; i++) {
                arrayList.add(i);
                linkedList.add(i);
            }
        }

        // Измеряем время для ArrayList
        switch (methodName) {
            case "add" -> {
                long start = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    arrayList.add(i);
                }
                long end = System.nanoTime();
                arrayListTime = end - start;
            }
            case "get" -> {
                long start = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    arrayList.get(i % arrayList.size()); // Операция get
                }
                long end = System.nanoTime();
                arrayListTime = end - start;
            }
            case "remove" -> {
                long start = System.nanoTime();
                while (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() / 2); // Удаляем из середины
                }
                long end = System.nanoTime();
                arrayListTime = end - start;
            }
        }

        // Измеряем время для LinkedList
        switch (methodName) {
            case "add" -> {
                long start = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    linkedList.add(i);
                }
                long end = System.nanoTime();
                linkedListTime = end - start;
            }
            case "get" -> {
                long start = System.nanoTime();
                for (int i = 0; i < iterations; i++) {
                    linkedList.get(i % linkedList.size()); // Операция get
                }
                long end = System.nanoTime();
                linkedListTime = end - start;
            }
            case "remove" -> {
                long start = System.nanoTime();
                while (!linkedList.isEmpty()) {
                    linkedList.remove(linkedList.size() / 2); // Удаляем из середины
                }
                long end = System.nanoTime();
                linkedListTime = end - start;
            }
        }

        // Конвертируем время из наносекунд в миллисекунды и выводим результаты
        System.out.printf("%-15s | %-10d | %-15.3f | %-15.3f%n",
                methodName, iterations, arrayListTime / 1_000_000.0, linkedListTime / 1_000_000.0);
    }
}
