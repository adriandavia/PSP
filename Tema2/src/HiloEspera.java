
public class HiloEspera extends Thread {
	public static void main(String[] args) {
		/*DORMIR EL HIJO**/
		HiloEspera hilo= new HiloEspera();
		System.out.println("Soy el "+Thread.currentThread().getName()+"empezando");
		hilo.start();
		try {
			hilo.sleep(5000);
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName()+"Interrumpido");
		}
		System.out.println(Thread.currentThread().getName()+"Terminado");
	}
}


