/**
 * 
 */
package br.com.projetoppint.modelos;

/**
 * @author Wendel Hime Lino Castro
 * Classe utilizada como o modelo do Vetor
 */
public class Vetor 
{
	private double[] valores;
	
	public Vetor()
	{
		
	}
	
	public Vetor(int dimensao)
	{
		valores = new double[dimensao];
	}
	
	public void setValores(int indice, double valor)
	{
		valores[indice] = valor;
	}
	
	public double[] getValores()
	{
		return valores;
	}
	
	public double getValor(int indice)
	{
		return valores[indice];
	}
	
	public void setValor(double[] valor)
	{
		this.valores = valor;
	}
}
