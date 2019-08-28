package com.company.test;

import com.company.Sorter;
import org.junit.Test;

import static org.junit.Assert.*;

public class SorterTest {

    private Sorter sorter;

    @org.junit.Before
    public void setUp() throws Exception {
        sorter = new Sorter();
    }

    @Test
    public void sortDeveOrdenarOArray(){
        int[] items = new int[100];
        for (int i = 0; i < items.length; ++i) {
            items[i] = items.length - 1 - i;
        }

        sorter.sort(items);

        for (int i = 0; i < items.length; ++i) {
            assertEquals(i, items[i]);
        }
    }
}