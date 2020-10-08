package entidades;

import interfaces.MecanicaDoJogo;

public class FabricaMecanicaDoJogo {
	
	public MecanicaDoJogo retornaMecanica(int n){
		if(n == 1){ 
			return new MecanicaTresChances();
		}
		return new MecanicaMorteSubita();
	}

}
