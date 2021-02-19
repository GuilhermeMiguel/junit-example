package br.com.empresa.teste;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;


import org.junit.Test;

public class ExemplosAssertTest {
	
	
	/*
	  	Junit sobrecarrega assertions para tipos primitivos, objetos e arrays
	*/
	
	
	/**
	  	Teste de array de bytes
	*/
	@Test
	public void testAssertArrayEquals() {
		byte[] esperado = "esseTexto".getBytes();
		byte[] atual = "esseTexto".getBytes();
		assertArrayEquals(esperado, atual);
	}

	/**
  		Teste de strings
	*/
	@Test
	public void testAssertEquals() {
		assertEquals("esseTexto", "esseTexto");
	}

	
	@Test
	public void testAssertFalse() {
		assertFalse(false);
	}

	@Test
	public void testAssertNotNull() {
		assertNotNull(new Object());
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame(aNumber, aNumber);
	}

	@Test
	public void testAssertNotSame() {
		var func1 = new Funcionario("Guilherme", "Silva");
		var func2 = new Funcionario("Guilherme", "Silva");
		
//		assertNotSame(func1, func1);
		assertNotSame(func1, func2);
	}

	@Test
	public void testAssertNull() {
		assertNull(null);
	}
	
	
	
	/**
  	
  			AssertJ --> Permite escrever asserts de mais facil compreensão 
  		Oferece asserts para N objetos
	*/
	@Test
	public void checkEquidade() {
		var func1 = new Funcionario("Guilherme", "Silva");
		var func2 = new Funcionario("Guilherme", "Silva");
	    
		assertThat(func1).isEqualTo(func2);
	}

}
