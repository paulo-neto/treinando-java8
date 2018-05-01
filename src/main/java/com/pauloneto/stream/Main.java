package com.pauloneto.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	static List<Pessoa> pessoas = new ArrayList<>();
	static {
		pessoas.add(new Pessoa("Antonia", 67));
		pessoas.add(new Pessoa("Paulo",35));
		pessoas.add(new Pessoa("Gerline",26));
		pessoas.add(new Pessoa("Pedro",37));
		pessoas.add(new Pessoa("Severina",95));
		
	}
	public static void main(String[] args) {
		//Ordenando pela idade
		pessoas.stream().sorted(Comparator.comparing(Pessoa::getIdade))
			.forEach(p -> System.out.println(p.getNome()));
		System.out.println("\n");
		//filtrando com idade maior que 40
		pessoas.stream().filter(p -> p.getIdade() > 40)
		.forEach(p -> System.out.println(p.getNome()));
		System.out.println("\n");
		//Transformando Stream<Pessoa> em Stream<String>
		pessoas.stream().map(Pessoa::getNome).forEach(System.out::println);
		System.out.println("\n");
		//filtrando com idade maior que 40 e pegando o primeiro elemento filtrado
		pessoas.stream().filter(p -> p.getIdade() > 40)
			.findFirst().ifPresent(p -> System.out.println(p.getNome()));
		System.out.println("\n");
		//calculando a media de idade
		pessoas.stream().mapToInt(Pessoa::getIdade)
			.average().ifPresent(System.out::println);
		System.out.println("\n");
		//filtrando com idade menor que 50 e 'coletando' em um Set
		Set<Pessoa> collect = pessoas.stream().filter(p -> p.getIdade() < 50).collect(Collectors.toSet());
		
		/*
		 * Os Streams foram desenhados de uma forma a tirar proveito da programação funcional. Se você utilizá-los 
		 * da forma que vimos por aqui, eles nunca gerarão efeitos colaterais. Isso é, apenas o stream será alterado,
		 * e nenhum outro objeto será impactado.Dada essa premissa, podemos pedir para que nosso stream seja processado
		 * em paralelo. Ele mesmo vai decidir quantas threads usar e fazer todo o trabalho, utilizando APIs mais
		 * complicadas (como a de fork join) para ganhar performance. Para fazer isso, basta utilizar parallelStream() em vez de stream()
		 */
		Set<Pessoa> collect2 = pessoas.parallelStream().filter(p -> p.getIdade() < 50).collect(Collectors.toSet());
	}
}
