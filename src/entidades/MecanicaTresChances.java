package entidades;

import interfaces.Embaralhador;
import interfaces.MecanicaDoJogo;

public class MecanicaTresChances implements MecanicaDoJogo {
	
	private int vida, pontos;
	String palavra;
	String palavraDepois;

	BancoDePalavra bp = new BancoDePalavra();
	FabricaEmbaralhador fe = new FabricaEmbaralhador();
		
		public MecanicaTresChances(){
			this.vida = 3;
			this.pontos = 0;
			novaPalavra();
			setPalavraDepois();
		}

	@Override
	public boolean verificaPalavra(String palavra) {
		if(palavra.equals(getPalavra()))
			return true;
		return false;
	}

	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	public int getPontos() {
		return this.pontos;
	}

	@Override
	public void perdeVida() {
		this.vida--;
		
	}

	@Override
	public void acerta(int n) {
		this.pontos += n * 2;
		
	}

	@Override
	public void setPalavraDepois() {
		Embaralhador e = fe.retornaEmbaralhador();
		this.palavraDepois = e.embaralhar(getPalavra());
		
	}

	@Override
	public String getPalavra() {
		return this.palavra;
	}

	@Override
	public void novaPalavra() {
		this.palavra = bp.buscaPalavra();
		setPalavraDepois();
		
	}

	@Override
	public String getPalavraDepois() {
		return this.palavraDepois;
	}

}
