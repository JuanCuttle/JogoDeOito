package modelo.implementacao;

import interfaces.Estrategia;

	public class Fabrica {


		private static Fabrica embaralhador;
		
		public Fabrica() {
		}
		
		public static Fabrica getInstance() {
			if (embaralhador == null) {
				embaralhador = new Fabrica();
			}
			return embaralhador;
		}
		public Estrategia modo(Class<?extends Estrategia> classe) throws Exception {
			return classe.newInstance();
		}
}
