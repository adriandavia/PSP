import java.awt.FontFormatException;
import java.awt.event.MouseWheelEvent;
import javax.xml.stream.util.EventReaderDelegate;
import org.w3c.dom.events.EventTarget;

public class Parking {	
	
	public static void main(String[] args) {
		Barrera entrada = new Barrera(8);
		for (int i = 0; i < 10; i++){
			Coche coche = new Coche("Coche " + i, entrada);
			coche.start();
		}
	}	
}

class Coche extends Thread{
	private String nombre;
	private Barrera barrera;
	public Coche (String nombre, Barrera barrera){
		this.nombre = nombre;
		this.barrera = barrera;
	}
	
	public void run(){
		synchronized (barrera) {
			try{
				while (barrera.gethuecos() == 0){
					wait();
				}
			} catch (Exception e) {
					System.out.println(nombre + " interrumpido");
				}
			}
		barrera.entrar();
		try{
			Thread.sleep(4000);
		} catch (InterruptedException e){
			
		}
		barrera.salir();
	}
}

class Barrera {
	private int huecos;
	public Barrera (int huecos){
		this.huecos = huecos;
	}
	public int gethuecos(){
		return huecos;
	}
	
	public synchronized void entrar(){
		huecos--;
	}
	public synchronized void salir(){
		huecos++;
		notifyAll();
	}
}

class esperar {
	public void esperar(long espera){
		try{
			Thread.sleep(espera);
		}catch (InterruptedException e) {
			System.err.println ("Thread coche interrumpido");
			System.exit(-1);
		}
	}
}