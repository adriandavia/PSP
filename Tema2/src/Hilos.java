
public class Hilos {
	public static void main(String[] args) {
		RunnableClass rc = new RunnableClass();
		Thread hilo1= new Thread(rc);
		Thread hilo2= new Thread(rc);
		Thread hilo3= new Thread(rc);
		hilo1.setName("hilo1");
		hilo2.setName("hilo2");
		hilo3.setName("hilo3");
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}
}

class RunnableClass implements Runnable {
	public void run(){
		for(int i=0; i <=5; i++){
			System.out.println("Ejecutando "+Thread.currentThread().getName()+":"+i);
		}
	}
}
