package com.pauloneto.lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	static List<String> texto = new ArrayList<>();
	static {
		texto.add("trakinas");
		texto.add("negresco");
		texto.add("oreo");
		texto.add("bono");
		texto.add("passa tempo");
		
	}
	/**
	 * Lembre-se que para trabalhar com lambda, uma interface funcional precisa estar envolvida.
	 * @param args
	 */
	public static void main(String[] args) {
		//Até o java 7
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		//A partir do java 8
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
		//iterando com java 8: classe anonima
		texto.forEach(new Consumer<String>() {
		    public void accept(String s) {
		        System.out.println(s);
		    }
		});
		//iterando com java 8: lambda
		//Essa sintaxe funciona para qualquer interface 
		//que tenha apenas um método abstrato
		texto.forEach((String s) -> {
		    System.out.println(s);
		});
		//ou
		texto.forEach((s) -> {
		    System.out.println(s);
		});
		//ou
		texto.forEach(s -> {
		    System.out.println(s);
		});
		//ou
		texto.forEach(s -> System.out.println(s));
		// Uma interface que possui apenas um método abstrato 
		//é agora conhecida como interface funcional e pode ser utilizada dessa forma
		
		//Outro exemplo é o próprio Comparator. Se utilizarmos a forma 
		//de classe anônima, teremos essa situação: 
		texto.sort(new Comparator<String>() {
		    public int compare(String s1, String s2) {
		        if (s1.length() < s2.length())
		            return -1;
		        if (s1.length() > s2.length())
		            return 1;
		        return 0;
		    }
		});
		//ou com lambda
		texto.sort((s1, s2) -> {
		    if (s1.length() < s2.length())
		        return -1;
		    if (s1.length() > s2.length())
		        return 1;
		    return 0;
		});
		//ou
		texto.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length());
		});
		//ou como há apenas um único statement, podemos remover as chaves
		texto.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
	}

}
