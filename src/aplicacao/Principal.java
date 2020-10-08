package aplicacao;

import java.util.Scanner;

import entidades.FabricaMecanicaDoJogo;
import interfaces.MecanicaDoJogo;

public class Principal{

	public static void main(String[] args) {
		
		String palavra, nivel, n;
		FabricaMecanicaDoJogo m = new FabricaMecanicaDoJogo();
		MecanicaDoJogo mj;
		
		Scanner sc = new Scanner(System.in);
		
		do{
			
			System.out.println("BEM VINDO AO JOGO --> JOGO PALAVRAS EMBARALHADAS");
			System.out.println("");
			System.out.println("DESCUBRA QUAL � A PALAVRA");
			System.out.println("SELECIONE O TIPO DO JOGO:");
			System.out.println("1 - TR�S CHANCES");
			System.out.println("2 - MORTE S�BITA");
			System.out.println("TR�S CHANCES 1 PONTO POR ACERTO/ MORTE S�BITA 2 PONTOS POR ACERTO:");
			
			do{
				nivel = sc.nextLine();
				if(!nivel.equals("1") && !nivel.equals("2"))
					System.out.println("Op��o inv�lida. Digite novamente");
			}while(!nivel.equals("1") && !nivel.equals("2"));
			
			if(nivel.equals("2")){
				mj = m.retornaMecanica(2);
				System.out.println("Voc� escolheu o n�vel dif�cil");
			}else{
				mj = m.retornaMecanica(1);
				System.out.println("Voc� escolheu o n�vel f�cil");
			}
			
			do{
				System.out.println("Adivinhe a palavra:");	
				System.out.println(mj.getPalavraDepois());
				System.out.println("Digite sua resposta:");
				palavra = sc.nextLine();
				if(mj.verificaPalavra(palavra.toUpperCase())){
					System.out.println("Voc� acertou!! :)");
					mj.acerta(mj.getPalavra().length());
				}
				else{
					System.out.println("Voc� errou!! :(");
					System.out.println("A palavra correta era " + mj.getPalavra());
					mj.perdeVida();
					if(mj.getVida() != 0)
						System.out.println("Ainda restam: " + mj.getVida() + " vida(s).");
				}
				mj.novaPalavra();
				
			}while(mj.getVida() > 0);
			
			System.out.println("O jogo acabou!");
			System.out.println("Sua pontua��o foi de " + mj.getPontos() + " pontos.");
			System.out.println("");
			System.out.println("Gostaria de jogar novamente:");
			System.out.println("1 - Sim; 2 - N�o");
			do{
				n = sc.nextLine();
				if(!n.equals("1") && !n.equals("2"))
					System.out.println("Op��o inv�lida, tente novamente.");
			}while(!n.equals("1") && !n.equals("2"));
		}while(n.equals("1"));
		System.out.println("Jogo finalizado!");
		sc.close();
	
	}

}
