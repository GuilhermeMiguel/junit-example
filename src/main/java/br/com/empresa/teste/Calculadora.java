package br.com.empresa.teste;

public class Calculadora {

	
	public Integer multiplicar(int ...valores) {
		Integer mult = 1;
		
		for (int valorMult : valores) 
			mult *= valorMult;
		
		return mult;
	}
}
