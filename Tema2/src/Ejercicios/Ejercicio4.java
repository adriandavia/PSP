package Ejercicios;

public class Ejercicio4 implements Runnable{
	public static void main(String[] args) {
		
		//CREAMOS LOS HILOS
			new Thread(new Ejercicio4(3000)).start();
			new Thread(new Ejercicio4(5000)).start();
			
		//AQUI INTERRUMPIMOS EL PADRE
			try {
				Thread.sleep(4000);
			} catch (Exception e) {
				System.out.println("Interrumpido");
				return;
			}
			System.out.println("Hilo pricipal acabado");
	}
	
	private int espera;
	
	public Ejercicio4(int espera){
		this.espera=espera;
	}
	//AQUÍ DECIMOS QUE LOS HILOS SE ESPEREN 
	public void run(){	
		int tiempo1=3000;
		int tiempo2=5000;
		System.out.println("Soy el hilo "+Thread.currentThread().getName()+" mi tiempo de espera es "+tiempo1);
		System.out.println("Soy el hilo "+Thread.currentThread().getName()+" mi tiempo de espera es "+tiempo2);
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			e.getMessage();
			System.out.println("Se ha interrumpido");
			
			return;
		}
		System.out.println("Terminado");
			
	}
}




