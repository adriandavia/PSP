
public class HiloEsperaReturn {
	public static void main(String[] args) {
		Return retorno=new Return();
		retorno.start();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			return;
		}
		retorno.interrupt();
	}
	
	

}

class Return extends Thread{
	public void run(){
		System.out.println("Soy el hijo creado que está empezando");
		try {
			System.out.println("Voy a esperar 3 segundos");
			this.sleep(2000);
		} catch (Exception e) {
			System.out.println("hilo creado interrumpido");
			return;
		}
		System.out.println("Soy el hilo creado que va a acabar");
	}
}
