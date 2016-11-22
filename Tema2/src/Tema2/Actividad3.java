package Tema2;

public class Actividad3 {
	public static void main (String []args){
		HiloEspera hilo = new HiloEspera();
		hilo.start();
		System.out.println("Hilo main");
		try{ //Sleep solo sirve para que un hilo duerma, da igual donde lo ejecutemos, se duerme el metodo que lo contiene
			hilo.sleep(3000);
		}catch (InterruptedException e){
			System.out.println(Thread.currentThread().getName() + "interrumpido");
			return; //Necesario para que acabe de ejecutar 
		}
		System.out.println("Acabado hilo main");
		//hilo.interrupt(); Si no lo interrumpes el hijo sigue ejecutandose
	}
}

class HiloEspera extends Thread {
	public void run() {	
		System.out.println("Soy el "+ Thread.currentThread().getName() +" empezando.");	
		try {	
			this.sleep(10000);			
			// También se puede hacer así y lo aplicará al hilo actual.			
			// Thead.sleep(3000);		
		} catch (InterruptedException e) {	
			System.out.println(Thread.currentThread().getName() +" interrumpido.");			
			return;			
		}	
		System.out.println(Thread.currentThread().getName() +" acabado.");			
	}

}