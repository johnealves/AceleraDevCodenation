package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		ArrayList<Integer> sequecia = new ArrayList();
		sequecia.add(0);
		sequecia.add(1);

		int i = 0, j = 1, soma;

		while (j < 350){
			soma = i + j;
			i = j;
			j = soma;
			sequecia.add(j);
		}

		return sequecia;
	}

	public static Boolean isFibonacci(Integer a) {
		Boolean resultado = fibonacci().contains(a);

		return resultado;
	}

}