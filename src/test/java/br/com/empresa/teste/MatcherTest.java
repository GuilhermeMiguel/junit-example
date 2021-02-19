package br.com.empresa.teste;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.hamcrest.beans.HasProperty;
import org.hamcrest.object.HasToString;
import org.junit.Test;

public class MatcherTest {

	/*
	  		Matchers fazem testes em objetos 
	*/
	
	
	/**
	  	Verifica se a classe possui o toString daquela forma
	*/
	@Test
	public void verificaToString(){
	    var func = new Funcionario("Pedro", "Pedra");
	    String funcStr = func.toString();
	    assertThat(funcStr, HasToString.hasToString(funcStr));
	}
	
	@Test
	public void verificaExistenciaDePropriedade() {
	    assertThat(Funcionario.class, HasProperty.hasProperty("name"));
	}
	
	
	@Test
	public void verificaSeObjetoEstaVazio() {
	    List<String> emptyList = new ArrayList<>();
	    assertThat(emptyList, Matchers.empty());
	}
	
	@Test
	public void verificaSeEhMaior() {
	    assertThat(1, Matchers.greaterThan(0));
	}
	
	@Test
	public void verificacoesComString() {
	    String str = null;
	    assertThat(str, Matchers.isEmptyOrNullString());
	}
}
