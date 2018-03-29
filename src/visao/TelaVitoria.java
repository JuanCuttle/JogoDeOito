package visao;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TelaVitoria extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public TelaVitoria(){
		mostrarTela();
	}

	private void mostrarTela() {
		this.setTitle("Sliding puzzle");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		JPanel painel = new JPanel();
		painel.setSize(400, 300);
		
		JTextArea texto = new JTextArea("Parabéns, você venceu o jogo!!!!");
		texto.setFont(new Font("Tahoma", Font.BOLD, 24));
		texto.setLocation(400, 300);
		painel.add(texto);
		
		this.setSize(420, 100);
		this.add(painel);
		this.setVisible(true);
	}
}
