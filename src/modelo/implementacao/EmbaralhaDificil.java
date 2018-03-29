package modelo.implementacao;
import modelo.implementacao.Jogo;
import interfaces.Estrategia;

public class EmbaralhaDificil implements Estrategia{
 
	public void embaralhar(Jogo jogo){
		int tamanho = (int)(Math.pow(jogo.getTamanho(), 2))-1;
		for(int i=0;i<100;i++){
			int numeroPecaMovida = (int)(Math.random()*tamanho)+1;
				jogo.moverPeca(numeroPecaMovida);
		}
	}
}
