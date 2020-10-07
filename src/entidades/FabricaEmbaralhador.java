package entidades;

import java.util.Random;

import interfaces.Embaralhador;

public class FabricaEmbaralhador {

	public Embaralhador retornaEmbaralhador() {
		Random r = new Random();
		if (r.nextInt(2) == 0) {
			return new EmbaralhadorRandomico();
		}
		return new EmbaralhadorPilha();
	}

}
