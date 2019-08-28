package br.ufrn.imd.lpii.dome;

public class Main {

	public static void main(String[] args) {
		Database database = new Database();
		CD cd1 = new CD("A Swingin' Affair (64 mins)*",
				"Frank Sinata", 16,64 );
		cd1.setComment("my favorite Sinatra album");
		DVD dvd1 = new DVD("O Brother, Where Art Thou?","Joel & Ethan Coen",106);
		dvd1.setComment("The Coen Brothers best movie!");
		
		
		
		database.addItem(cd1);
		database.addItem(dvd1);
		
		database.list();

	}

}
