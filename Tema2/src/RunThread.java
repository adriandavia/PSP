public class RunThread {
	public static void main(String[] args) {
		HelloTread hilo = new HelloTread();
		hilo.start();
		System.out.println("Hola desde el hilo principal");
		System.out.println("proceso acabado");
	}
}

class HelloTread extends Thread{
	public void run(){
		System.out.println("hola desde el hilo creado");
	}
}