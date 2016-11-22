package Ejercicios;

public class Ejercicio7 {
	public static void main(String[] args) {
		HiloPrioridad thread1 = new HiloPrioridad();
		thread1.setName("Hilo 1");
		thread1.setPriority(1);
		HiloPrioridad thread2 = new HiloPrioridad();
		thread2.setName("Hilo 2");
		thread2.setPriority(Thread.MAX_PRIORITY);
		HiloPrioridad thread3 = new HiloPrioridad();
		thread3.setName("Hilo 3");
		thread3.setPriority(3);
		HiloPrioridad thread4 = new HiloPrioridad();
		thread4.setName("Hilo 4");
		thread4.setPriority(6);
		HiloPrioridad thread5 = new HiloPrioridad();
		thread5.setName("Hilo 5");
		thread5.setPriority(1);
		HiloPrioridad thread6 = new HiloPrioridad();
		thread1.setName("Hilo 6");
		thread1.setPriority(9);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		}
}
class HiloPrioridad extends Thread {
	public void run() {
	System.out.println("Soy el "+ Thread.currentThread().getName() +" empezando.");
	for(int i=0; i<10; i++)
	System.out.println("Soy el "+ Thread.currentThread().getName() +" iteración "+ i);
	System.out.println("Soy el "+ Thread.currentThread().getName() +" acabando.");
	}
}
