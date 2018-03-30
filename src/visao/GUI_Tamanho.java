package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI_Tamanho extends JFrame{
	
	private static final long serialVersionUID = -3722991115350962858L;
	private Integer botaoClicado;
	
	public GUI_Tamanho(){
		criarJanela();
	}
	public void criarJanela(){
		this.setTitle("Sliding puzzle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel painel = new JPanel();
		painel.setSize(400, 300);
		
		JTextArea texto = new JTextArea("Selecione o tamamho do jogo");
		painel.add(texto);
		
		JButton botao2x2 = new JButton("2x2");
		botao2x2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				botaoClicado=2;
				try{
					new GUI_Dificuldade(2);
				}
				catch(Exception erro){
					erro.printStackTrace();
				}
				fecharJanela();
			}
		});
		painel.add(botao2x2);
		
		JButton botao3x3 = new JButton("3x3");
		botao3x3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				botaoClicado=3;
				try{
					new GUI_Dificuldade(3);
				}
				catch(Exception erro){
					erro.printStackTrace();
				}
				fecharJanela();
			}
		});
		painel.add(botao3x3);
		
		JButton botao4x4 = new JButton("4x4");
		botao4x4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				botaoClicado=4;
				try{
					new GUI_Dificuldade(4);
				}
				catch(Exception erro){
					erro.printStackTrace();
				}
				fecharJanela();
			}
		});
		painel.add(botao4x4);
		
		JButton botao5x5 = new JButton("5x5");
		botao5x5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				botaoClicado=5;
				try{
					new GUI_Dificuldade(5);
				}
				catch(Exception erro){
					erro.printStackTrace();
				}
				fecharJanela();
			}
		});
		painel.add(botao5x5);
		
		this.setSize(450, 300);
		this.add(painel);
		this.setVisible(true);
	}
	
	public Integer getTamanho() {
		
		switch (botaoClicado) {
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		default:
			return 5;
		}
	}
	
	private void fecharJanela() {
		this.dispose();
	}

}
