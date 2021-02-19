package br.com.empresa.teste;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {

	
	
	/*
	 		----------------------------------------
	 					1ª FORMA
	 		----------------------------------------
	 		
	  		O expected nos permite especificar uma exceção que esperamos que seja lançada pelo código sendo testado. 
	  	O teste só tem sucesso se a exceção for lançada, caso contrário temos uma falha.
	  	
	  		Importante ressaltar que não necessários asserts nesse caso
	*/
	
	@Test(expected = IndexOutOfBoundsException.class) 
	public void empty() { 
	     List<String> listaVazia = new ArrayList<>();
	     
	     listaVazia.get(0); 
	}
	
	
	
	/*
	  
	  			----------------------------------------
	 					2ª FORMA
	 			----------------------------------------
	  
	 
				Caso seja necessário capturar a mensagem da exception, podemos utilizar um bloco try/catch 
		 	Mas utilizado até a versão 3 do JUnit.
		
		
			+ Assert.fail() -> se o código de teste executar essa linha, indica que ele falhou, pois, o teste deveria lançar uma exceção;
		
			+ É no catch()  que esperamos que aconteça a execução do teste. 
			Utiliza-se o assertEquals para verificar se a mensagem da exceção (ex.getMessage()) é a que esperada.
	 */
	
	@Test
	public void testExceptionMessage() {
	    try {
	        new ArrayList<Object>().get(0);
	        fail("Esperado que IndexOutOfBoundsException seja lancada");
	    } catch (IndexOutOfBoundsException ex) {
//	    	System.out.println(ex.getMessage());
	        assertThat(ex.getMessage(), is("Index 0 out of bounds for length 0"));
	    }
	}
	
	
	
	
	
	/*
	  		----------------------------------------
	 					3ª FORMA
	 		----------------------------------------
	  	
	  	
	  		Uma ExpectedException é uma rule que nos permite verificar se o nosso código lança uma determinada exceção.
	*/
	
	@Rule
	public ExpectedException excecaoEsperada = ExpectedException.none();
	
	/*
	  	 A varíavel excecaoEsperada é inicializada com o o valor ExpectedException.none(); essa inicialização é para informar que, por padrão, nenhuma exceção é esperada.
	*/

	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
	    List<Object> listaVazia = new ArrayList<>();
	 
	    //excecaoEsperada.expect() – modifica o comportamento padrão definido anteriormente, informando qual o tipo de exceção esperamos: IndexOutOfBoundsException;
	    excecaoEsperada.expect(IndexOutOfBoundsException.class);
	    
	    //Mensagem esperada
	    excecaoEsperada.expectMessage("Index 0 out of bounds for length 0");
	    
	    listaVazia.get(0); 
	}
	
	
}
