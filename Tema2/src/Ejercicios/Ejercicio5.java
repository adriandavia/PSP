package Ejercicios;

public class Ejercicio5 {
public static void main(String[] args) {
		
		//CREAMOS LOS HILOS
			Thread hilo1=new Thread(new Ejercicio4(3000));
			hilo1.start();
			Thread hilo2=new Thread(new Ejercicio4(5000));
			hilo2.start();
			
		//AQUI INTERRUMPIMOS EL PADRE
			try {
				hilo1.join();
				hilo2.join();
			} catch (Exception e) {
				System.out.println("Interrumpido");
				return;
			}
			System.out.println("Hilo pricipal acabado");
	}
	
	private int espera;
	
	public Ejercicio5(int espera){
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
