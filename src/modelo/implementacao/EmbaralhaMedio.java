package modelo.implementacao;
import modelo.implementacao.Jogo;
import interfaces.Estrategia;

public class EmbaralhaMedio implements Estrategia{
	
	public void embaralhar(Jogo jogo){
		Integer tamanho = (int)(Math.pow(jogo.getTamanho(), 2))-1;
		for(int i=0;i<50;i++){
			Integer numeroPecaMovida = (int)(Math.random()*tamanho)+1;
				jogo.moverPeca(numeroPecaMovida);
		}
	}
}
