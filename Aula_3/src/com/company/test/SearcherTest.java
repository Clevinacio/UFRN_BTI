package com.company.test;

import com.company.Searcher;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class SearcherTest {
    private Searcher searcher;

    @org.junit.Before
    public void setUp() throws Exception {
        searcher = new Searcher();
    }

    public Searcher getSearcher() {
        return searcher;
    }

    @Test
    public void returnLessOneIfArrayIsEmpty() {
        int[] empty = {10,20,30,40};
        assertEquals(-1,searcher.search(empty,50));
    }

    @Test
    public void returnPostitionIfArrayIsEmpty() {
        int[] empty = {10,20,30,40};
        assertEquals(0,searcher.search(empty,10));
        assertEquals(1,searcher.search(empty,20));
        assertEquals(2,searcher.search(empty,30));
        assertEquals(3,searcher.search(empty,40));
    }

    @Test
    public void returnPostitionIfFoundRandomElement() {
        Random r = new Random();
        int size = Math.abs(r.nextInt()) %100;
        int[] entrada = new int[size];

        for (int i = 0; i < entrada.length; ++i) {
            entrada[i] = r.nextInt() % 100;
        }

        Arrays.sort(entrada);

        int pos = Math.abs(r.nextInt()) % entrada.length;

        assertEquals(pos, searcher.search(entrada, entrada[pos]));
    }
}