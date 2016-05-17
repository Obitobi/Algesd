/**
 * 
 */
package br.com.projetoppint.formularios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.ferramentas.Busca;
import br.com.ferramentas.Estatistica;
import br.com.ferramentas.Ordenacao;
import br.com.projetoppint.modelos.Vetor;

/**
 * @author Wendel Hime Lino Castro
 * @see Classe utilizada para o formulario principal
 */
public class Principal {
	private Vetor vetor;
	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu[] menus, algesd;
	// private JMenuItem[] sobreVetor, probest, cdi, ordenacao, busca;
	private JMenuItem[] sobreVetor, probest, ordenacao, busca;

	public void Init() {
		// String[] titulosMenus = new String[] { "Vetor", "PROBEST", "CDI",
		// "ALGESD", "Sair" };
		String[] titulosMenus = new String[] { "Vetor", "PROBEST", "ALGESD", "Sair" };
		frame = new JFrame("Trabalho PPINT");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		menus = new JMenu[titulosMenus.length];

		for (int i = 0; i < titulosMenus.length; i++) {
			menus[i] = new JMenu(titulosMenus[i]);
		}

		String[] titulosSobreVetor = new String[] { "Dimensiona", "Digita", "Apresenta" };
		sobreVetor = new JMenuItem[titulosSobreVetor.length];
		for (int i = 0; i < sobreVetor.length; i++) {
			sobreVetor[i] = new JMenuItem(titulosSobreVetor[i]);
			sobreVetor[i].setEnabled(false);
			menus[0].add(sobreVetor[i]);
		}
		sobreVetor[0].setEnabled(true);

		sobreVetor[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dimensiona();
			}
		});

		sobreVetor[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				defineValores();
			}
		});

		sobreVetor[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				apresenta();
			}
		});

		String[] titulosProbest = new String[] { "Média", "Desvio Padrão", "Variância", "Mediana", "Coef.Assimetrica",
				"Coef.Variação" };
		probest = new JMenuItem[titulosProbest.length];
		for (int i = 0; i < probest.length; i++) {
			probest[i] = new JMenuItem(titulosProbest[i]);
			probest[i].setEnabled(false);
			menus[1].add(probest[i]);
		}

		probest[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Média dos valores: " + Estatistica.media(vetor.getValores()));
			}
		});

		probest[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Desvio padrão: " + Estatistica.desvioPadrao(vetor.getValores()));
			}
		});

		probest[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Variância: " + Estatistica.variancia(vetor.getValores()));
			}
		});

		probest[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mediana: " + Estatistica.mediana(vetor.getValores()));
			}
		});

		probest[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Coeficiente assimetria: " + Estatistica.coeficienteAssimetria(vetor.getValores()));
			}
		});

		probest[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Coeficiente de variação: " + Estatistica.coeficienteVariacao(vetor.getValores()));
			}
		});

		/*
		 * String[] titulosCdi = new String[] { "Função", "Derivada" }; cdi =
		 * new JMenuItem[titulosCdi.length]; for (int i = 0; i < cdi.length;
		 * i++) { cdi[i] = new JMenuItem(titulosCdi[i]); menus[2].add(cdi[i]); }
		 */
		String[] titulosAlgesd = new String[] { "Ordenação", "Busca" };
		String[] titulosOrdenacao = new String[] { "Trocas", "Seleção", "Inserção", "Quick", "Merge" };
		String[] titulosBusca = new String[] { "Linear Iterativa", "Linear Recursiva", "Binária Iterativa",
				"Binária Recursiva" };
		algesd = new JMenu[titulosAlgesd.length];
		for (int i = 0; i < titulosAlgesd.length; i++) {
			algesd[i] = new JMenu(titulosAlgesd[i]);
			menus[2].add(algesd[i]);
		}
		ordenacao = new JMenuItem[titulosOrdenacao.length];
		for (int i = 0; i < titulosOrdenacao.length; i++) {
			ordenacao[i] = new JMenuItem(titulosOrdenacao[i]);
			algesd[0].add(ordenacao[i]);
		}
		ordenacao[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vetor.setValor(Ordenacao.troca(vetor.getValores()));
				for (int i = 0; i < probest.length; i++) {
					probest[i].setEnabled(true);
				}
			}
		});
		ordenacao[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vetor.setValor(Ordenacao.selecao(vetor.getValores()));
				for (int i = 0; i < probest.length; i++) {
					probest[i].setEnabled(true);
				}
			}
		});
		ordenacao[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vetor.setValor(Ordenacao.insercao(vetor.getValores()));
				for (int i = 0; i < probest.length; i++) {
					probest[i].setEnabled(true);
				}
			}
		});
		ordenacao[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vetor.setValor(Ordenacao.quick(vetor.getValores()));
				for (int i = 0; i < probest.length; i++) {
					probest[i].setEnabled(true);
				}
			}
		});
		ordenacao[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vetor.setValor(Ordenacao.merge(vetor.getValores()));
				for (int i = 0; i < probest.length; i++) {
					probest[i].setEnabled(true);
				}
			}
		});
		busca = new JMenuItem[titulosBusca.length];
		for (int i = 0; i < titulosBusca.length; i++) {
			busca[i] = new JMenuItem(titulosBusca[i]);
			algesd[1].add(busca[i]);
		}

		busca[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(null,
								"Valor no índice: " + Busca.linearIterativa(
										Double.parseDouble(
												JOptionPane.showInputDialog("Digite o valor a ser pesquisado: ")),
										vetor.getValores()));
			}
		});

		busca[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(null,
								"Valor no índice: " + Busca.linearRecursiva(
										Double.parseDouble(
												JOptionPane.showInputDialog("Digite o valor a ser pesquisado: ")),
										vetor.getValores(), vetor.getValores().length - 1));
			}
		});

		busca[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(null,
								"Valor no índice: " + Busca.binariaIterativa(
										Double.parseDouble(
												JOptionPane.showInputDialog("Digite o valor a ser pesquisado: ")),
										vetor.getValores()));
			}
		});

		busca[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(null,
								"Valor no índice: " + Busca.binariaRecursiva(
										Double.parseDouble(
												JOptionPane.showInputDialog("Digite o valor a ser pesquisado: ")),
										vetor.getValores(), 0, vetor.getValores().length - 1));
			}
		});

		menus[3].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		menuBar = new JMenuBar();
		for (int i = 0; i < menus.length; i++) {
			menus[i].setEnabled(false);
			menuBar.add(menus[i]);
		}
		menus[0].setEnabled(true);
		menus[3].setEnabled(true);
		panel.add(menuBar, BorderLayout.NORTH);
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Método utilizado para instanciar o vetor e definir dimensão
	 */
	public void dimensiona() {
		try {
			vetor = new Vetor(Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da dimensão do vetor: ")));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor inserido inválido " + e.getMessage());
		}
		for (int i = 0; i < sobreVetor.length; i++) {
			sobreVetor[i].setEnabled(true);
		}
	}

	/**
	 * Método utilizado para definir valores do array
	 */
	public void defineValores() {
		try {
			for (int i = 0; i < vetor.getValores().length; i++) {
				vetor.setValores(i, Double.parseDouble(
						JOptionPane.showInputDialog("Digite o valor da posição " + (i + 1) + " do vetor: ")));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor inserido inválido " + e.getMessage());
		}
		for (int i = 0; i < menus.length; i++) {
			menus[i].setEnabled(true);
		}
	}

	/**
	 * Método utilizado para apresentar os dados do vetor
	 */
	public void apresenta() {
		String text = "";
		for (int i = 0; i < vetor.getValores().length; i++) {
			text += "Vetor[" + i + "] = " + vetor.getValor(i) + "\n";
		}
		JOptionPane.showMessageDialog(null, text);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.Init();
	}

}
