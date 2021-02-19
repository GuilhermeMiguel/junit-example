package br.com.empresa.teste;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class CalculadoraTest {

	/*
	 
	  Exemplo basico de teste, estou passando 12 como resultado esperado e passo após isso o resultado da minha operação 
	
	*/
	
	@Test
	public void testeMultiplicar() {
		var calc = new Calculadora();
		int mult = calc.multiplicar(2, 2, 3);
		assertEquals(12, mult);
	}
	
	
	/*
	  	
	  	Mocks basicamente sao valores forcados em testes
	  	
	*/
	
	@SuppressWarnings("unused")
	@Test
	public void testeMultiplicarComMock() {
		var calculadora = mock(Calculadora.class);
		
		//Quando o resultado for 10 eu forço ser 15
		when(calculadora.multiplicar(1, 5, 2)).thenReturn(15);
		
		//Como eu forcei que quando o resultado for 10 eu passo 15
		int resultado = calculadora.multiplicar(1, 5, 2);
		
		//Ele vai zerar o resultado 2, pois a classe esta mockada
		int resultado2 = calculadora.multiplicar(1, 5, 3);
		
		assertEquals(10, resultado);
		
		
	}
}
