/**
 * 
 */
package br.com.projetoalgesd.models;

import br.com.projetoalgesd.interfaces.IMercadoria;

/**
 * @author Wendel Hime Lino Castro
 *
 */
public class Mercadoria implements IMercadoria {
	private int codigo, quantidade;
	private String nome, unidade;
	private double precoUnitario;

	public Mercadoria() {
		this.codigo = 0;
		this.quantidade = 0;
		this.nome = "";
		this.unidade = "";
		this.precoUnitario = 0.0;
	}

	public Mercadoria(IMercadoria sourceObject) {
		this.codigo = sourceObject.getCodigo();
		this.quantidade = sourceObject.getQuantidade();
		this.nome = sourceObject.getNome();
		this.unidade = sourceObject.getUnidade();
		this.precoUnitario = sourceObject.getPrecoUnitario();
	}

	/**
	 * @return the codigos
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade
	 *            the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the unidade
	 */
	public String getUnidade() {
		return unidade;
	}

	/**
	 * @param unidade
	 *            the unidade to set
	 */
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	/**
	 * @return the precoUnitario
	 */
	public double getPrecoUnitario() {
		return precoUnitario;
	}

	/**
	 * @param precoUnitario
	 *            the precoUnitario to set
	 */
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
}
