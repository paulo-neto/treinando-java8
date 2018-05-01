package com.pauloneto.defaultmethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	static List<String> texto = new ArrayList<>();
	static {
		texto.add("trakinas");
		texto.add("negresco");
		texto.add("oreo");
	}
	
	public static void main(String[] args) {
		//Iterando coleções
		//Até o Java 7
		for (String string : texto) {
			System.out.println(string);
		}
		//A partir do java 8
		Consumer<String> consumer = new ImprimeNoConsole();
		texto.forEach(consumer);
		//Ordenando colecoes 
		//ate o java 7
		Collections.sort(texto, new OrdenaPorTamanho());
		//A partir do java 8
		texto.sort(new OrdenaPorTamanho());
		System.out.println(texto);
		
	}
}

class ImprimeNoConsole implements Consumer<String>{
	@Override
	public void accept(String t) {
		System.out.println(t);
	}
}

class OrdenaPorTamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length()) 
			return -1; 
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}


