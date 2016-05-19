package br.com.projetoalgesd.enums;

public enum ColunasMercadoria {
	Preco(1),Quantidade(2),Unidade(3), Nome(4), Codigo(5);
	
	public int valor;
	ColunasMercadoria(int indice)
	{
		valor = indice;
	}
	
	public int getValor()
	{
		return valor;
	}
}