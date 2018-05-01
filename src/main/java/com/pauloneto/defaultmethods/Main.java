package com.pauloneto.defaultmethods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		List<String> texto = new ArrayList<>();
		texto.add("trakinas");
		texto.add("negresco");
		texto.add("oreo");
		//Iterando coleções
		
		//Até o Java 7
//		for (String string : texto) {
//			System.out.println(string);
//		}
		//A partir do java 8
		Consumer<String> consumer = new ImprimeNoConsole();
		texto.forEach(consumer);
		//ou
		texto.forEach(t ->{
			System.out.println(t);
		});
	}
}

class ImprimeNoConsole implements Consumer<String>{
	@Override
	public void accept(String t) {
		System.out.println(t);
	}
}