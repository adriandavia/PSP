package Ejercicios;

import java.util.Scanner;

public class Ejercicio9 extends Thread {
	public static int contador=0;
	public static String frase;
	
	public Ejercicio9(String nombre){
		this.setName(nombre);
	}
	
	public void run(){
		if(this.getName().compareTo("hilo1")==0) //PARA COMPARAR EL NOMBRE
			this.contarA();
		if(this.getName().compareTo("hilo2")==0) //PARA COMPARAR EL NOMBRE
			this.contarE();
		if(this.getName().compareTo("hilo3")==0) //PARA COMPARAR EL NOMBRE
			this.contarI();
		if(this.getName().compareTo("hilo4")==0) //PARA COMPARAR EL NOMBRE
			this.contarO();
		if(this.getName().compareTo("hilo5")==0) //PARA COMPARAR EL NOMBRE
			this.contarU();
	}
	
	public synchronized void contarA(){
		for(int i=0; i<frase.length();i++){
			if (frase.charAt(i)=='a' || frase.charAt(i)=='A')
				contador++;
		}
	}
	
	public synchronized void contarE(){
		for(int i=0; i<frase.length();i++){
			if (frase.charAt(i)=='e' || frase.charAt(i)=='E')
				contador++;
		}
	}
	public synchronized void contarI(){
		for(int i=0; i<frase.length();i++){
			if (frase.charAt(i)=='i' || frase.charAt(i)=='I')
				contador++;
		}
	}
	public synchronized void contarO(){
		for(int i=0; i<frase.length();i++){
			if (frase.charAt(i)=='o' || frase.charAt(i)=='O')
				contador++;
		}
	}
	public synchronized void contarU(){
		for(int i=0; i<frase.length();i++){
			if (frase.charAt(i)=='u' || frase.charAt(i)=='U')
				contador++;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		System.out.println("Dime la palabra");
		
		Ejercicio9.frase=scan.nextLine();
		
		Ejercicio9 hilo1= new Ejercicio9("hilo1"); //se necesita constructor
		Ejercicio9 hilo2= new Ejercicio9("hilo2");
		Ejercicio9 hilo3= new Ejercicio9("hilo3");
		Ejercicio9 hilo4= new Ejercicio9("hilo4");
		Ejercicio9 hilo5= new Ejercicio9("hilo5");

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		
		//PARA ACTUALIZAR EL ESTADO DEL CONTADOR, LOS HILOS SE TIENE QUE ESPERAR A QUE TERMINEN
		try{
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
		}catch(Exception e){
			e.getMessage();
		}
		
		System.out.println(contador);
	}
}

