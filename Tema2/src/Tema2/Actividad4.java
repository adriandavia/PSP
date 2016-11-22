package Tema2;
public class Actividad4 implements Runnable {
	private int espera;
	private String nombre;
	
	public static void main(String[] args) {			
		Thread hilo = new Thread(new Actividad4(3000, "Hilo 1"));
		hilo.start();
		Thread hilo1 = new Thread(new Actividad4(5000, "Hilo 2"));
		hilo1.start();
		
		System.out.println("Empiza hilo main y voy a parar mi ejecución en 4000 ms.");
		
		try{
			hilo.sleep(4000); 
		
		} catch (InterruptedException e){
			System.err.println("Soy el hilo "+ Thread.currentThread().getName() +" y me han interrumpido.");
			
		}
		
		System.out.println("Termina el hilo main");
	}
	
	public Actividad4 (int espera, String nombre) {
		this.espera = espera;
		this.nombre = nombre;
	}
		
	public void run() {
					
		System.out.println("Soy el hilo "+ nombre +" y he iniciado mi ejecución.");			
		System.out.println("Soy el hilo "+ nombre +" y voy a parar mi ejecución "+ espera +" ms.");
		
		try {			
			Thread.sleep(espera);			
		} catch (InterruptedException e) {			
			System.err.println("Soy el hilo "+ nombre +" y me han interrumpido.");			
		}
		
		System.out.println("Soy el hilo "+ nombre +" y continúo mi ejecución.");			
		System.out.println("Soy el hilo "+ nombre +" y he finalizado mi ejecución.");
	}	
}