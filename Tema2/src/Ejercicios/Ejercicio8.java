package Ejercicios;

public class Ejercicio8 extends Thread {
	private int numeroHilos;
	
	public Ejercicio8(int numeroHilos) {
		this.numeroHilos = numeroHilos;
		this.setName("Hilo "+ numeroHilos);
	}
	
	public void run() {
		String nombre = this.getName();
		
		if(numeroHilos<10){
			numeroHilos++;
			System.out.println("Soy "+ nombre +", creo un hijo y espero a que acabe.");
			Ejercicio8 hilo = new Ejercicio8(numeroHilos);
			try {
				this.sleep(500);
				hilo.start();
				hilo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Soy "+ nombre +" y voy a esperarme 5 segundos.");
			try {
				this.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			this.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Soy "+ nombre + " acabado.");
		
	}
	
	public static void main(String[] args) {
		Ejercicio8 hilo = new Ejercicio8(1);
		hilo.start();
	}
}

