package entidades;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import interfaces.Embaralhador;

public class EmbaralhadorRandomico implements Embaralhador {

	@Override
	public String embaralhar(String palavra) {
		
		List<String> letters = Arrays.asList(palavra.split(""));
		Collections.shuffle(letters);
		StringBuilder t = new StringBuilder(palavra.length());
		for (String k : letters) {
			t.append(k);
		}

		return t.toString();
	}

}
