package modelo.implementacao;

import interfaces.Estrategia;

import java.util.List;
import java.util.ArrayList;

public class Jogo {

	private Peca pecaBranca;
	private List<Peca> pecas;
	private double tamanho;

	public Jogo(Integer tamanho) throws Exception {
		this.tamanho = tamanho;
		this.montarTabuleiro();
	}

	// Inicializa��o do tabuleiro, com as pe�as em suas poi��es "corretas"
	private void montarTabuleiro() {
		Integer numeroPeca = 1;
		ArrayList<Peca> todasPecas = new ArrayList<Peca>();
		for (int lin = 1; lin <= tamanho; lin++) {
			for (int col = 1; col <= tamanho; col++) {
				Peca peca = new Peca(new Posicao(lin, col), numeroPeca);
				todasPecas.add(peca);
				if (lin == tamanho && col == tamanho) {
					this.pecaBranca = peca;
				}
				numeroPeca++;
			}
		}
		this.pecas = todasPecas;
	}

	// Realiza��o do movimento
	public boolean moverPeca(Integer numeroPeca) {
		Peca movida = this.obterPecaPor(numeroPeca);
		if (this.eVizinhaDaBranca(movida)) {
			Integer numeroPecaBranca = this.pecaBranca.getNumero();

			Integer temp = numeroPeca;
			movida.setNumero(numeroPecaBranca);
			pecaBranca.setNumero(temp);
			pecaBranca = this.obterPecaPor((int)Math.pow(tamanho,2));
			return true;
		} else{
			return false;
		}
	}

	// Retorna a pe�a representada por um dado n�mero
	public Peca obterPecaPor(int numeroPeca) {
		Peca p = null;
		for (int i = 0; i < pecas.size(); i++) {
			p = pecas.get(i);
			if (p.getNumero() == numeroPeca) {
				return p;
			}
		}
		return p;
	}

	// Checagem se a pe�a � "vizinha" da peca "branca", ou seja, pode ser movida
	public boolean eVizinhaDaBranca(Peca peca) {
		Posicao posPeca = peca.getPos();
		Integer posX = posPeca.getPosX();
		Integer posY = posPeca.getPosY();
		Integer posXB = this.pecaBranca.getPosX();
		Integer posYB = this.pecaBranca.getPosY();
		if ((posX == posXB && posY == posYB - 1)
				|| (posX == posXB && posY == posYB + 1)) {
			return true;
		}
		if ((posX == posXB - 1 && posY == posYB)
				|| (posX == posXB + 1 && posY == posYB)) {
			return true;
		}
		return false;
	}

	public List<Peca> getPecas() {
		return this.pecas;
	}

	public void embaralhar(Class<? extends Estrategia> abc) throws Exception {
			Fabrica.getInstance().modo(abc).embaralhar(this);
	}
	public double getTamanho(){
		return this.tamanho;
	}
}