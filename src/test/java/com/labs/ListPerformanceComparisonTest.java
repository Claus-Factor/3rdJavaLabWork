package com.labs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ListPerformanceComparisonTest {

    private static final int ITERATIONS = 100_000;

    @Test
    void testAddPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Замеряем время для ArrayList
        long arrayListStart = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.add(i);
        }
        long arrayListEnd = System.nanoTime();

        // Замеряем время для LinkedList
        long linkedListStart = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            linkedList.add(i);
        }
        long linkedListEnd = System.nanoTime();

        System.out.printf("testAddPerformance: ArrayList = %.3f ms, LinkedList = %.3f ms%n",
                (arrayListEnd - arrayListStart) / 1_000_000.0,
                (linkedListEnd - linkedListStart) / 1_000_000.0);

        assertEquals(ITERATIONS, arrayList.size(), "ArrayList add test failed!");
        assertEquals(ITERATIONS, linkedList.size(), "LinkedList add test failed!");
    }

    @Test
    void testGetPerformance() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Подготовка данных
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Замеряем время для ArrayList
        long arrayListStart = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            assertEquals(i % ITERATIONS, arrayList.get(i % arrayList.size()));
        }
        long arrayListEnd = System.nanoTime();

        // Замеряем время для LinkedList
        long linkedListStart = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            assertEquals(i % ITERATIONS, linkedList.get(i % linkedList.size()));
        }
        long linkedListEnd = System.nanoTime();

        System.out.printf("testGetPerformance: ArrayList = %.3f ms, LinkedList = %.3f ms%n",
                (arrayListEnd - arrayListStart) / 1_000_000.0,
                (linkedListEnd - linkedListStart) / 1_000_000.0);
    }

    @Test
    void testRemovePerformance() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Подготовка данных
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Замеряем время для ArrayList
        long arrayListStart = System.nanoTime();
        while (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() / 2); // Удаление из середины
        }
        long arrayListEnd = System.nanoTime();

        // Замеряем время для LinkedList
        long linkedListStart = System.nanoTime();
        while (!linkedList.isEmpty()) {
            linkedList.remove(linkedList.size() / 2); // Удаление из середины
        }
        long linkedListEnd = System.nanoTime();

        System.out.printf("testRemovePerformance: ArrayList = %.3f ms, LinkedList = %.3f ms%n",
                (arrayListEnd - arrayListStart) / 1_000_000.0,
                (linkedListEnd - linkedListStart) / 1_000_000.0);

        assertTrue(arrayList.isEmpty(), "ArrayList remove test failed!");
        assertTrue(linkedList.isEmpty(), "LinkedList remove test failed!");
    }
}