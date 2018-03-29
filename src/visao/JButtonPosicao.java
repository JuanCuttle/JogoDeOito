package visao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.implementacao.*;

public class JButtonPosicao extends JButton {

	private static final long serialVersionUID = 1L;
	private final Peca peca;
	private final Integer tamanho;

	public JButtonPosicao(final GUI_Jogo jogo, final Peca peca, final Integer tamanho) {
		this.tamanho = (int)(Math.pow(tamanho,2));
		this.peca=peca;
		setFont(new Font("Tahoma", Font.BOLD, 40));
		addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					jogo.moverPeca(peca);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void atualizar(GUI_Jogo jogo) {
		this.setText("" + peca.getNumero());
		this.setVisible(peca.getNumero() != tamanho);
	}
	public Peca getPecaBotao(){
		return this.peca;
	}
}
