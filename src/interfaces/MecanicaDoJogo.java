package interfaces;

public interface MecanicaDoJogo {

	abstract boolean verificaPalavra(String palavra);

	abstract int getVida();

	abstract int getPontos();

	abstract void perdeVida();

	abstract void acerta(int n);

	abstract void setPalavraDepois();

	abstract String getPalavra();

	abstract void novaPalavra();

	abstract String getPalavraDepois();
}
