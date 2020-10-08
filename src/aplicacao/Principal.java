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
			System.out.println("DESCUBRA QUAL É A PALAVRA");
			System.out.println("SELECIONE O TIPO DO JOGO:");
			System.out.println("1 - TRÊS CHANCES");
			System.out.println("2 - MORTE SÚBITA");
			System.out.println("TRÊS CHANCES 1 PONTO POR ACERTO/ MORTE SÚBITA 2 PONTOS POR ACERTO:");
			
			do{
				nivel = sc.nextLine();
				if(!nivel.equals("1") && !nivel.equals("2"))
					System.out.println("Opção inválida. Digite novamente");
			}while(!nivel.equals("1") && !nivel.equals("2"));
			
			if(nivel.equals("2")){
				mj = m.retornaMecanica(2);
				System.out.println("Você escolheu o nível difícil");
			}else{
				mj = m.retornaMecanica(1);
				System.out.println("Você escolheu o nível fácil");
			}
			
			do{
				System.out.println("Adivinhe a palavra:");	
				System.out.println(mj.getPalavraDepois());
				System.out.println("Digite sua resposta:");
				palavra = sc.nextLine();
				if(mj.verificaPalavra(palavra.toUpperCase())){
					System.out.println("Você acertou!! :)");
					mj.acerta(mj.getPalavra().length());
				}
				else{
					System.out.println("Você errou!! :(");
					System.out.println("A palavra correta era " + mj.getPalavra());
					mj.perdeVida();
					if(mj.getVida() != 0)
						System.out.println("Ainda restam: " + mj.getVida() + " vida(s).");
				}
				mj.novaPalavra();
				
			}while(mj.getVida() > 0);
			
			System.out.println("O jogo acabou!");
			System.out.println("Sua pontuação foi de " + mj.getPontos() + " pontos.");
			System.out.println("");
			System.out.println("Gostaria de jogar novamente:");
			System.out.println("1 - Sim; 2 - Não");
			do{
				n = sc.nextLine();
				if(!n.equals("1") && !n.equals("2"))
					System.out.println("Opção inválida, tente novamente.");
			}while(!n.equals("1") && !n.equals("2"));
		}while(n.equals("1"));
		System.out.println("Jogo finalizado!");
		sc.close();
	
	}

}
