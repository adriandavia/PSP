package Tema2;

public class Actividad2 {
	public static void main (String []args){
		for (int i = 0; i <= 10; i++){
			Ac2Thread hilo = new Ac2Thread ();
			hilo.start();
		}
	}
}
class Ac2Thread extends Thread{
	public void run(){
		System.out.println(Thread.currentThread().getName());
		System.out.println("Fin" + Thread.currentThread().getName());
	}
}
