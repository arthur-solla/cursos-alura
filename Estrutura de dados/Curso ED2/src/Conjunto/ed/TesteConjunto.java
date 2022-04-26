package Conjunto.ed;

import java.util.HashSet;
import java.util.Set;

public class TesteConjunto {
	
	public static void main(String[] args) {
		
		Conjunto conjunto = new Conjunto();
		conjunto.adiciona("Mauricio");
		System.out.println(conjunto);
		
		conjunto.adiciona("Mauricio");
		System.out.println(conjunto);
		
		conjunto.adiciona("Marcelo");
		System.out.println(conjunto);
		
		conjunto.adiciona("Guilherme");
		System.out.println(conjunto);
		
		conjunto.remove("Mauricio");
		System.out.println(conjunto);
		
		Set<String> conjuntoDoJava = new HashSet<String>();
		
		conjuntoDoJava.add("Mauricio");
		conjuntoDoJava.add("Paula");
		
		System.out.println(conjuntoDoJava);
		
		String x = "Guilherme";
		x.hashCode();
		
		System.out.println("Guilherme".hashCode());
		System.out.println("Guilherme".hashCode());
		
	}
}
