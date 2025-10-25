package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	ServicoMatematico servico = mock(ServicoMatematico.class);
	
	@Test
	void soma() {
		// given
		when(servico.somar(2, 3)).thenReturn(5);
		// when
		var calculadora = new Calculadora(servico);
		int resultado = calculadora.somar(2, 3);
		// then
		assertEquals(5, resultado);
	}
	

}
