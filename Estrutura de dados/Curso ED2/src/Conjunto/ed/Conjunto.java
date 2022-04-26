package Conjunto.ed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Conjunto {

	private ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();

	public Conjunto() {
		for (int i = 0; i < 26; i++) {
			tabela.add(new LinkedList<String>());
		}
	}

	public void adiciona(String palavra) {
		if(!contem(palavra)) {
		int indice = calculaIndicedDaTabela(palavra);
		List<String> lista = tabela.get(indice);
		lista.add(palavra);
		}
	}
	
	public void remove(String palavra) {
		if(contem(palavra)) {
			int indice = calculaIndicedDaTabela(palavra);
			List<String> lista = tabela.get(indice);
			lista.remove(palavra);
		}
	}

	public boolean contem(String palavra) {
		int indice = calculaIndicedDaTabela(palavra);
		return tabela.get(indice).contains(palavra);
	}
	
	private int calculaIndicedDaTabela(String palavra) {
		return palavra.toLowerCase().charAt(0) % 26;
	}
	
	@Override
	public String toString() {
		return tabela.toString();
	}
}
