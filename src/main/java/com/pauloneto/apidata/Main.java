package com.pauloneto.apidata;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		//agora
		System.out.println(LocalDate.now());
		System.out.println("\n");
		//criando uma data especifica
		LocalDate meuAniversario = LocalDate.of(2018, 05, 17);
		//ou
		meuAniversario = LocalDate.of(2018, Month.MAY, 17);
		System.out.println(meuAniversario);
		System.out.println("\n");
		//periodo entre hoje e meu aniversario
		Period periodoEntreHjeMeuAniversario = Period.between(LocalDate.now(), meuAniversario);
		System.out.println(periodoEntreHjeMeuAniversario);
		System.out.println("\n");
		//data atual formatada dd/MM/yyyy
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		
		

	}

}
