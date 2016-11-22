package Tema2;
public class Actividad6 implements Runnable {
	private int espera;
	private String nombre;
	
	public static void main(String[] args) {			
		Thread hilo = new Thread(new Actividad6(3000, "Hilo 1"));
		hilo.start();
		Thread hilo1 = new Thread(new Actividad6(5000, "Hilo 2"));
		hilo1.start();
		Thread hilodaemon = new Thread(new Actividad6(20000, "Daemon"));
		hilodaemon.setDaemon(true);
		hilodaemon.start();
		
		System.out.println("Soy el hilo padre y he iniciado mi ejecución.");
		System.out.println("Soy el hilo padre y voy a parar mi ejecución en 2000 ms.");
		try{
			hilo.sleep(2000); 
		
		} catch (InterruptedException e){
			System.err.println("Soy el hilo "+ Thread.currentThread().getName() +" y me han interrumpido.");
			
		}
		
		System.out.println("Soy el hilo padre y he terminado mi ejecución.");
	}
	
	public Actividad6 (int espera, String nombre) {
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