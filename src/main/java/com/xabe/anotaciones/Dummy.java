package com.xabe.anotaciones;

@AnotacionClase(type="Soy la clase Dummy")
public class Dummy {

	@AnotacionCampo(type="Soy el campo algo")
	private String algo;
	
	@AnotacionMetodo(type="soy el metodo hacerAlgo")
	public void hacerAlgo(){
		System.out.println(algo);
	}
}
