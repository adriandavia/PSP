package Tema2;

public class Actividad8 extends Thread{
	private int cont;
	
	public static void main (String []args){
		Actividad8 hilo = new Actividad8(1);
		hilo.start();
		System.out.println("Soy el hilo ancestro y voy a comemzar");
		try{
			hilo.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("El hilo ancestro ha acabado");
	}
	
	public Actividad8 (int cont){
		this.cont = cont;
		this.setName ("Hilo " + cont);
	}
	
	public void run(){
		String nombre = this.getName();
		
		if (cont < 10){
			cont++;
			System.out.println("Soy " + nombre + ", creo un hijo y espero a que acabe");
			Actividad8 hilo = new Actividad8 (cont);
			hilo.start();
			try{
				hilo.join();
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Soy " + nombre + " y voy a esperarme 5 segundos");
			try{
				this.sleep(5000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		System.out.println("Soy " + nombre + " y he acabado");
	}
}
	
