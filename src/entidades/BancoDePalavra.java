package entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BancoDePalavra {

	List<String> palavras = new ArrayList<>();

	String[] fields;
	String palavra = null;

	String path = "src/arquivo/cidades.txt";
	{

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				fields = line.split(", ");

				for (int i = 0; i < fields.length; i++) {
					palavras.add(fields[i]);

				}
				
				Random random = new Random();
				palavra = palavras.get(random.nextInt(palavras.size()));
				
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public String buscaPalavra() {
		Random r = new Random();
		int n = r.nextInt(palavras.size());
		return palavras.get(n);
	}
}
