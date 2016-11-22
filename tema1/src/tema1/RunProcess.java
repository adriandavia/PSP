package tema1;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class RunProcess {
	public static void main (String[] args) throws IOException {
			if(args.length <= 0) {
				System.err.println("Se necesita un programa a ejecutar");
				System.exit(-1);
			}
			
			String comando1 = "ls –la ";
			String comando2 = "tr 'd' 'D'";
			
			ProcessBuilder pb = new ProcessBuilder(comando1);
			ProcessBuilder pb2 = new ProcessBuilder(comando2);
			
				try {
					
					Process process = pb.start();
					int retorno = process.waitFor();
					
					
					Process process2 = pb2.start();
					int retorno2 = process2.waitFor();
					
					
					
					System.out.println("La ejecución de "+ Arrays.toString(args) +" devuelve "+ retorno);
					} catch (IOException ex) {
						System.err.println("Excepción de E/S");
						System.exit(-1);
					} catch (InterruptedException ex) {
						System.err.println("El proceso hijo finalizó de forma incorrecta");
					}
		}		
}