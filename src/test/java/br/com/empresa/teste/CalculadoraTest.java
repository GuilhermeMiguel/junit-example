package br.com.empresa.teste;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {

	
	private Calculadora calc;
	
	/*
	  	Before -- Metodo executado uma vez antes de cada metodo de teste
	*/
	
	@Before
	public void instanciaCalculadora() {
		this.calc = new Calculadora(); 	
		System.out.println("Metodo executado uma vez antes de cada metodo de teste");
	}
	
	
	/*
	  		Utilizamos métodos @After quando nossos testes consomem recursos que precisam ser finalizados. 
	  	Exemplos podem ser testes que acessam banco de dados, abrem arquivos, abrem sockets, e etc.
	*/
	
	@After
	public void finalizaCalculoAtual() {
		System.out.println("\n----------------------------------------");
	}
	
	/*
	 
	  Exemplo basico de teste, estou passando 12 como resultado esperado e passo após isso o resultado da minha operação 
	
	*/
	
	@Test
	public void testeMultiplicar() {
		int mult = calc.multiplicar(2, 2, 3);
		System.out.println("Mult: " + mult);
		assertEquals(12, mult);
	}
	
	
	@Test
	public void testeDividir() {
		Double div = calc.dividir(10.0, 5.0);
		System.out.println("Mult: " + div);
		assertEquals(Double.valueOf(2), div);
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
		
		System.out.println("Mult com mock de resultado: " + resultado);
		
		//Ele vai zerar o resultado 2, pois a classe esta mockada
		int resultado2 = calculadora.multiplicar(1, 5, 3);
		
		assertEquals(15, resultado);
		
		
	}
}
