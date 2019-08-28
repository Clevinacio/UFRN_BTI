package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] numeros = {
	            10,
                20,
                40,
                30
        };

	    Searcher s = new Searcher();
	    int pos = s.search(numeros, 10);
    }
}
