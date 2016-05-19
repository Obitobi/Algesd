/**
 * 
 */
package br.com.projetoalgesd.ordenacao;

/**
 * @author Wendel Hime Lino Castro Classe utilizada para definir métodos de
 *         ordenação
 */
public class Ordenacao {
	// para ordenar por preço unitário
	public static double[] troca(double[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length; j++) {
				double valorAtual = vetor[j];
				if (j + 1 < vetor.length) {
					if (valorAtual > vetor[j + 1]) {
						vetor[j] = vetor[j + 1];
						vetor[j + 1] = valorAtual;
					}
				}
			}
		}
		return vetor;
	}
	// para ordenar por unidade
	public static String[] selecao(String[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			int index = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j].compareTo(vetor[index]) < 0) {
					index = j;
				}
			}
			String aux = vetor[i];
			vetor[i] = vetor[index];
			vetor[index] = aux;
		}
		return vetor;
	}
	// para ordenar por nome
	public static String[] insercao(String[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			String aux = vetor[i];
			int j = i - 1;
			while (j >= 0 && vetor[j].compareTo(aux) > 0) {
				vetor[j + 1] = vetor[j];
				j--;
			}
			vetor[j + 1] = aux;
		}
		return vetor;
	}
	// para ordenar por quantidade
	/**
	 * Ordena o vetor pelo valor de quantidade das mercadorias
	 * @param 
	 * @return   
	 */
	public static double[] merge(double[] vetor) {
		double vetorAuxiliar[] = new double[vetor.length];
		return merge(vetor, 0, vetor.length - 1, vetorAuxiliar);
	}

	public static double[] merge(double vetor[], int inicio, int fim, double[] vetorAuxiliar) {
		int meio = (inicio + fim) / 2;
		if (fim - inicio >= 1) {
			merge(vetor, inicio, meio, vetorAuxiliar);
			merge(vetor, meio + 1, fim, vetorAuxiliar);
		}
		return mescla(vetor, inicio, meio, fim, vetorAuxiliar);
	}
	public static double[] mescla(double[] vetor, int inicio, int meio, int fim, double[] vetorAuxiliar) {
		int i = inicio;
		int j = meio + 1;
		int k = inicio;
		while (k <= fim) {
			if (i <= meio && j <= fim) {
				if (vetor[i] < vetor[j]) {
					vetorAuxiliar[k] = vetor[i];
					i++;
					k++;
				} else {
					vetorAuxiliar[k] = vetor[j];
					j++;
					k++;
				}
			} else if (i > meio) {
				vetorAuxiliar[k] = vetor[j];
				j++;
				k++;
			} else {
				vetorAuxiliar[k] = vetor[i];
				i++;
				k++;
			}
		}
		for (i = inicio; i <= fim; i++)
			vetor[i] = vetorAuxiliar[i];
		return vetor;
	}
	// Para ordenar por código
	public static int[] quick(int[] vetor) {
		return quick(vetor, 0, vetor.length - 1);
	}

	public static int[] quick(int[] vetor, int esquerda, int direita) {
		int indice = particao(vetor, esquerda, direita);
		if (esquerda < indice - 1)
			vetor =  quick(vetor, esquerda, indice - 1);
		if (indice < direita)
			vetor = quick(vetor, indice, direita);
		return vetor;
	}

	public static int particao(int vetor[], int esquerda, int direita) {
		int i = esquerda, j = direita;
		double pivo = vetor[(esquerda + direita) / 2];
		while (i <= j) {
			while (vetor[i] < pivo)
				i++;
			while (vetor[j] > pivo)
				j--;
			if (i <= j) {
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				i++;
				j--;
			}
		}
		return i;
	}
}
