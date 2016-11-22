package Tema2;

public class HilosEjemplo2 {
	public static void main (String args[]){
		HelloThread hilo = new HelloThread();
		hilo.start();
		System.out.println("Hola desde el hilo principal");
		System.out.println("Acabando proceso");
		
	}
}

class HelloThread extends Thread{
	public void run(){
		System.out.println("Hola desde el hilo creado");
	}
}
