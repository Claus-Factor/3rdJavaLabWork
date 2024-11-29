package com.labs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformanceComparison {

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
