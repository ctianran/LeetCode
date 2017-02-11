package com.chentianran;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PriorityQueue<Integer> heap  = new PriorityQueue<Integer>(list);
        System.out.println(heap.poll());
        System.out.println(heap.poll());
    }
}
