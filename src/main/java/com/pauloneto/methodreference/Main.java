package com.pauloneto.methodreference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Main {
	static List<String> texto = new ArrayList<>();
	static {
		texto.add("trakinas");
		texto.add("negresco");
		texto.add("oreo");
		texto.add("bono");
		texto.add("passa tempo");
		
	}
	public static void main(String[] args) {
		//Methos reference
		//É muito comum escrevermos lambdas curtos, que simplesmente 
		//invocam um único método. É o exemplo de s -> s.length(). 
		//Dada uma String, invoque e retorne o método length. Por esse 
		//motivo, há uma forma de escrever esse tipo de lambda de uma 
		//forma ainda mais reduzida. Em vez de fazer:
		//lambda
		texto.sort(Comparator.comparing(s -> s.length()));
		//method reference
		texto.sort(Comparator.comparing(String::length));
		
		//Semelhança entre um lambda e seu method reference equivalente.
		Function<String, Integer> funcao1 = s -> s.length();
		Function<String, Integer> funcao2 = String::length;
		//Outro exemplo
		texto.forEach(s -> System.out.println(s));
		texto.forEach(System.out::println);
		texto.sort(Comparator.comparing(funcao2));
		
		/*
		 * Quando usar lambda e quando usar method reference? 
		 * Algumas vezes não é possível usar method references.
		 * Se você tiver, por exemplo, um lambda que dada uma 
		 * String, pega os 5 primeiros caracteres, faríamos s -> s.substring(0, 5). 
		 * Esse lambda não pode ser escrito como method reference! Pois não é uma 
		 * simples invocação de métodos onde os parâmetros são os mesmos que os do lambda.
		 */
		
	}

}
	