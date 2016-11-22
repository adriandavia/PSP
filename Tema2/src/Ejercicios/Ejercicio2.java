package Ejercicios;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in); 
		System.out.println("Cuantos hilos quieres");
		int numero=scan.nextInt();
		
		RunnableClass rc = new RunnableClass(numero);
		for(int i=1; i <=numero; i++){
			
			Thread hilo1= new Thread(rc);
			hilo1.start();
		}
	}
}
class RunnableClass implements Runnable {
	public int numero;
	public RunnableClass(int numero1){
		this.numero=numero1;
	}
	public void run(){	
			System.out.println("Ejecutando :"+Thread.currentThread().getName());
			System.out.println("finalizando:"+Thread.currentThread().getName());
	}
}
