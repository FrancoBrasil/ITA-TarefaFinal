import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entidades.EmbaralhadorInvertendo;
import entidades.EmbaralhadorRandomico;

class TestesEmbaralhador {

	@Test
	void testEmbaralhadorRandomico() {
		String str = "ARARAQUARA";
		EmbaralhadorRandomico er = new EmbaralhadorRandomico();
		String situacao = er.embaralhar(str);
		
		assertNotEquals("ARARAQUARA", situacao);
	}
	
	@Test
	void testEmbaralhadorInvertendo() {
		String str = "ARARAQUARA";
		EmbaralhadorInvertendo ei = new EmbaralhadorInvertendo();
		String situacao = ei.embaralhar(str);
		
		assertNotEquals("ARARAQUARA", situacao);
		assertEquals("ARAUQARARA", situacao);
	}

}
