package Tema2;

public class Actividad9 extends Thread {
	private static int variable = 0;
	private static Actividad9 hilo1 = new Actividad9("Hilo1");
	private static Actividad9 hilo2 = new Actividad9("Hilo2");
	private String nombre;
	
	public static void main(String []args){
		System.out.println("Variable empieza con valor " +variable);
		hilo1.start();
		hilo2.start();
		
	}
	
	public Actividad9(String nombre){
		this.nombre = nombre;
	}
	public void run(){
		if (this.getName().compareTo("Hilo1") == 0){
			try{
				hilo2.join();
			}catch(InterruptedException e){
				System.err.println("me han interrumpido.");
			}
			while(variable < 10){
				variable++;
			}
			hilo2.interrupt();
		}else {
			try{
				hilo1.join();
			}catch(InterruptedException e){
				System.err.println("me han interrumpido.");
			}
			while(variable > 5){
				variable--;
			}
			hilo1.interrupt();
			System.out.println(variable);
		}
		
	}
}