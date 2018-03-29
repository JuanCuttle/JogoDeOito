package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modelo.implementacao.EmbaralhaDificil;
import modelo.implementacao.EmbaralhaFacil;
import modelo.implementacao.EmbaralhaMedio;


public class GUI_Dificuldade extends JFrame{
	private static final long serialVersionUID = -3722991115350962858L;
	private Integer botaoClicado;
	private final Integer tamanho;
	
	public GUI_Dificuldade(Integer tamanho){
		this.tamanho = tamanho;
		criarJanela();
	}

	private void criarJanela() {
		this.setTitle("Sliding puzzle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel painel = new JPanel();
		painel.setSize(400, 300);
		
		JTextArea texto = new JTextArea("Selecione o n�vel de dificuldade.");
		painel.add(texto);
		
		JButton botaoFacil = new JButton("F�cil");
		botaoFacil.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				botaoClicado = 1;
				try {
					new GUI_Jogo(EmbaralhaFacil.class, tamanho);
				} catch (Exception erro) {
					erro.printStackTrace();
				}
				fecharJanela();
			}
		});
		painel.add(botaoFacil);
		
		JButton botaoMedio = new JButton("M�dio");
		botaoMedio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				botaoClicado = 2;
				try {
					new GUI_Jogo(EmbaralhaMedio.class, tamanho);
				} catch (Exception erro) {
					erro.printStackTrace();
				}
				fecharJanela();
			}
		});
		painel.add(botaoMedio);
		
		JButton botaoDificil = new JButton("Dif�cil");
		botaoDificil.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				botaoClicado = 3;
				try {
					new GUI_Jogo(EmbaralhaDificil.class, tamanho);
				} catch (Exception erro) {
					erro.printStackTrace();
				}
				fecharJanela();
			}
		});
		painel.add(botaoDificil);
		

		this.setSize(450, 300);
		this.add(painel);
		this.setVisible(true);
	}

	public Integer getNivelDificuldade() {
		if(botaoClicado == 1)
			return 1;
		if(botaoClicado == 2)
			return 2;
		return 3;
	}
	
	private void fecharJanela() {
		this.dispose();
	}
}
