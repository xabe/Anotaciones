package com.xabe.anotaciones;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		//Obtenemos la anotacion de la clase
		Dummy dummy = new Dummy();
		AnotacionClase annotationClase = dummy.getClass().getAnnotation(AnotacionClase.class);
		
		System.out.println("\t\t Anotaciones -----> " + annotationClase.type());
		
		
		Annotation annotations[];
		AnotacionCampo anotacionCampo;
		AnotacionMetodo anotacionMetodo;
		
		//Obtenemos las anotaciones de los campos
		Field[] fields = dummy.getClass().getDeclaredFields();
		
		for(Field field : fields){
		
			annotations = field.getAnnotations();
			
			for(Annotation annotation : annotations){
				
				if(annotation instanceof AnotacionCampo)
				{
					//Para poder modificar su valor
					field.setAccessible(true);
					
					anotacionCampo = (AnotacionCampo)annotation;
					System.out.println("\t\t Anotaciones -----> " +anotacionCampo.type());
					
					//Ahora asignamos el valor de anotacion al objecto que hemos creado
					field.set(dummy, anotacionCampo.type());
				}
			}
		}
		
		//Obtenemos las anotaciones de los metodos
		Method[] methods = dummy.getClass().getDeclaredMethods();
		
		for(Method method : methods){
		
			annotations = method.getAnnotations();
			
			for(Annotation annotation : annotations){
				
				if(annotation instanceof AnotacionMetodo)
				{
					anotacionMetodo = (AnotacionMetodo) annotation;
					System.out.println("\t\t Anotaciones -----> " + anotacionMetodo.type());
					
					//Ahora vamos a invocar al metodo
					method.invoke(dummy);
				}
			}
		}
		
	}

}
