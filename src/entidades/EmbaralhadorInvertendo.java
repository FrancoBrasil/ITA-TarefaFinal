package entidades;

import interfaces.Embaralhador;

public class EmbaralhadorInvertendo implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {

		StringBuffer sb = new StringBuffer(palavra);
		sb.reverse();
		return sb.toString();
	}
}
