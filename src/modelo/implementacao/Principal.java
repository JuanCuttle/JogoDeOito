package modelo.implementacao;

import visao.GUI_Dificuldade;
import visao.GUI_Tamanho;

public class Principal {
	public static void main(String[] args){
		GUI_Tamanho tam = new GUI_Tamanho();
		Integer tamanho = tam.getTamanho();
		new GUI_Dificuldade(tamanho);
	}
}
