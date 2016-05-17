/**
 * 
 */
package br.com.ferramentas;

import java.util.HashMap;

/**
 * @author Wendel Hime Lino Castro Classe utilizada para funções estatísticas
 */
public class Estatistica {
	public static double media(double[] vetor) {
		double somatoria = 0;
		for (double valor : vetor) {
			somatoria += valor;
		}
		return (somatoria / vetor.length);
	}

	public static double mediana(double[] vetor) {
		double valorMediana = 0;
		if ((vetor.length % 2) == 0) {
			int indice1 = vetor.length / 2;
			int indice2 = indice1 + 1;
			valorMediana = (vetor[indice1] + vetor[indice2]) / 2;
		} else {
			int indice = vetor.length / 2;
			valorMediana = vetor[indice];
		}
		return valorMediana;
	}

	public static double desvioPadrao(double[] vetor) {
		double valorMedia = media(vetor);
		double valorSomatoria = 0;
		for (int i = 0; i < vetor.length; i++) {
			valorSomatoria += vetor[i] - valorMedia;
		}
		return Math.sqrt((Math.pow(valorSomatoria, 2) / (vetor.length - 1)));
	}

	public static double variancia(double[] vetor) {
		return Math.pow(desvioPadrao(vetor), 2);
	}

	public static double coeficienteVariacao(double[] vetor) {
		return (desvioPadrao(vetor) / media(vetor)) * 100;
	}

	public static double coeficienteAssimetria(double[] vetor) {
		return media(vetor) - moda(vetor);
	}

	public static double moda(double[] vetor) {
		HashMap<Double, Integer> lista = new HashMap<>();
		for (int i = 0; i < vetor.length; i++) {
			if (lista.containsKey(vetor[i])) {
				lista.replace(vetor[i], lista.get(vetor[i]) + 1);
			} else {
				lista.put(vetor[i], 1);
			}
		}
		double keyMaior = 0;
		int valorMaior = 0;
		for (int i = 0; i < vetor.length; i++) {
			if (valorMaior < lista.get(vetor[i])) {
				valorMaior = lista.get(vetor[i]);
				keyMaior = vetor[i];
			}
		}
		return keyMaior;
	}
}
