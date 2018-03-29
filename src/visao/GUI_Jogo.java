package visao;

import interfaces.Estrategia;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import modelo.implementacao.*;

public class GUI_Jogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private Jogo jogo;
	private List<JButtonPosicao> botoes;
	


	public GUI_Jogo(Class<? extends Estrategia> abc, Integer tamanho) throws Exception{
		botoes = new ArrayList<JButtonPosicao>();
		jogo = new Jogo(tamanho);
		comecarJogo(tamanho, abc);
		atualizarValoresDosBotoes();
	}
	

	private void comecarJogo(Integer tamanho, Class<? extends Estrategia> abc) throws Exception {

		this.setTitle("Sliding puzzle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(tamanho * 100, tamanho * 100);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.BLACK);
		this.getContentPane().setLayout(new GridLayout(tamanho, tamanho));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		List<Peca> pecas = jogo.getPecas();
		for (Peca peca : pecas) {
			JButtonPosicao botao = new JButtonPosicao(this, peca, tamanho);
			this.getContentPane().add(botao);
			botoes.add(botao);
			
		}
		jogo.embaralhar(abc);
	}

	public void moverPeca(Peca peca) {
		Integer numeroPeca = peca.getNumero();
		jogo.moverPeca(numeroPeca);
		atualizarValoresDosBotoes();
		checaVitoria();
	}

	public void atualizarValoresDosBotoes() {
		for (JButtonPosicao jButtonPosicao : botoes) {
			jButtonPosicao.atualizar(this);
		}
	}

	public static void main(String[] args) throws Exception {
		GUI_Tamanho tam = new GUI_Tamanho();
		Integer tamanho = tam.getTamanho();
		new GUI_Dificuldade(tamanho);
		
	}
	public void checaVitoria(){
		boolean vitoria=true;
		for (int i=0;i<botoes.size();i++) {
			if(botoes.get(i).getPecaBotao().getNumero()!=i+1){
				vitoria=false;
			}
		}
		if(vitoria==true){
			new TelaVitoria();
		}
	}
}
