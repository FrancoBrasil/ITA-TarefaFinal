package aplicacao;

import java.util.Scanner;

import entidades.FabricaMecanicaDoJogo;
import interfaces.MecanicaDoJogo;

public class Principal{

	public static void main(String[] args) {
		
		String palavra, tipo, n;
		FabricaMecanicaDoJogo m = new FabricaMecanicaDoJogo();
		MecanicaDoJogo mj;
		
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.println("*************************************************");
			System.out.println("BEM VINDO AO JOGO --> JOGO PALAVRAS EMBARALHADAS");
			System.out.println("*************************************************");
			System.out.println("DESCUBRA QUAL O NOME DA CIDADE");
			System.out.println("1 - TR�S CHANCES");
			System.out.println("2 - MORTE S�BITA");
			System.out.println("TR�S CHANCES 1 PONTO POR ACERTO/ MORTE S�BITA 2 PONTOS POR ACERTO:");
			System.out.print("SELECIONE O TIPO DO JOGO --> ");
			do{
				tipo = sc.nextLine();
				if(!tipo.equals("1") && !tipo.equals("2"))
					System.out.println("Op��o inv�lida! Digite novamente");
			}while(!tipo.equals("1") && !tipo.equals("2"));
			
			if(tipo.equals("2")){
				mj = m.retornaMecanica(2);
				System.out.println("JOGO MORTE S�BITA - 1 CHANCE");
			}else{
				mj = m.retornaMecanica(1);
				System.out.println("JOGO TR�S VIDAS - 3 CHANCES");
			}
			
			do{
				System.out.println("ADVINHE A CIDADE:");	
				System.out.println(mj.getPalavraDepois());
				System.out.print("SUA RESPOSTA --> ");
				palavra = sc.nextLine();
				if(mj.verificaPalavra(palavra.toUpperCase())){
					System.out.println("PARAB�NS, VOC� ACERTOU!! :)");
					mj.acerta(mj.getPalavra().length());
				}
				else{
					System.out.println("RESPOSTA ERRADA!!! :(");
					System.out.println("PALAVRA CORRETA --> " + mj.getPalavra());
					mj.perdeVida();
					if(mj.getVida() != 0)
						System.out.println("Restam: " + mj.getVida() + " vida(s).");
				}
				mj.novaPalavra();
				
			}while(mj.getVida() > 0);
			
			System.out.println("FIM DO JOGO!");
			System.out.println("Sua pontua��o foi de " + mj.getPontos() + " pontos.");
			System.out.println("");
			System.out.println("JOGAR NOVAMENTE:");
			System.out.println("1 - Sim; 2 - N�o");
			do{
				n = sc.nextLine();
				if(!n.equals("1") && !n.equals("2"))
					System.out.println("Op��o inv�lida, tente novamente.");
			}while(!n.equals("1") && !n.equals("2"));
		}while(n.equals("1"));
		System.out.println("FIM DO JOGO!");
		sc.close();
	
	}

}
