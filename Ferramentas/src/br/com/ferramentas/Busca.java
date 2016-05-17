/**
 * 
 */
package br.com.ferramentas;

/**
 * @author Wendel Hime Lino Castro Classe utilizada para realizar buscas
 */
public class Busca {
	/**
	 * Método utilizdo para realizar busca linear iterativa
	 * @param valor valor a ser procurado
	 * @param vetor vetor que será feita a busca
	 * @return retorna indice ou -1 para caso não exista
	 */
	public static int linearIterativa(double valor, double[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] == valor)
				return i;
		}
		return -1;
	}

	/**
	 * Método utilizado para realizar busca linear recursiva
	 * @param valor valor a ser procurado
	 * @param vetor vetor em que será feita pesquisa
	 * @param indice indice a ser procurado
	 * @return retorna indice ou -1 para caso não exista
	 */
	public static int linearRecursiva(double valor, double[] vetor, int indice) {
		if (indice == -1)
			return -1;
		if (vetor[indice] == valor)
			return indice;
		return linearRecursiva(valor, vetor, indice - 1);
	}

	/**
	 * Método utilizado para realizar busca binária iterativa
	 * @param procurado valor procurado
	 * @param vetor vetor a ser pesquisado
	 * @return retorna o valor do indice ou -1 caso não exista
	 */
	public static int binariaIterativa(double procurado, double[] vetor)
	{
		int inicio = 0, fim = vetor.length-1;
		int meio;
		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if(vetor[meio] == procurado) return meio;
			else if(vetor[meio] > procurado) fim = meio - 1;
			else inicio = meio + 1;
		}
		return -1;
	}
	
	/**
	 * Método utilizado para realizar busca binaria recursiva
	 * @param procurado valor procurado
	 * @param vetor vetor a ser analisado
	 * @param inicio início da pesquisa
	 * @param fim fim da pesquisa
	 * @return retorna indice caso exista se não retorna -1
	 */
	public static int binariaRecursiva(double procurado, double[] vetor, int inicio, int fim)
	{
		int meio;
		if(inicio <= fim)
		{
			meio = (inicio + fim) / 2;
			if(vetor[meio] == procurado) return meio;
			else if(vetor[meio] > procurado) return binariaRecursiva(procurado, vetor, inicio, meio - 1);
			else return binariaRecursiva(procurado, vetor, meio + 1, fim);
		}
		return -1;
	}
}
