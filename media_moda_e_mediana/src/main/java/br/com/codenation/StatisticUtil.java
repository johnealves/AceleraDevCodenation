package br.com.codenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma = 0;
		for (int num:elements) {
			soma += num;
		}
		return soma / elements.length;
	}

	public static int mode(int[] elements) {
		int mode = 0;
		int cont = 0;
		int repetition = 0;

		for (int element:elements) {
			for (int num:elements) {
				if(num == element) {
					cont++;
				};
			}
			if (cont > repetition) {
				mode = element;
				repetition = cont;
			}
			cont = 0;
		}

		return mode;
	}

	public static int median(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length - 1; j++) {
				if(elements[j] > elements[j + 1]) {
					int aux = elements[j];
					elements[j] = elements[j + 1];
					elements[j + 1] = aux;
				}
			}
		}

		System.out.println(Arrays.toString(elements));


		int position = elements.length / 2;
		if (elements.length % 2 != 0) {
			return elements[position];
		} else {
			return (elements[position - 1] + elements[position]) / 2;
		}
	}
}