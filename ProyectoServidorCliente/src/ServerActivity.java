import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class ServerActivity {
	public static String[] usuarios = new String[5];
	public static Socket[] sockets = new Socket[5];
	public static InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.26.114", 5555);
	public static void main(String[] args) {
		System.out.print("Arrancando servidor");
		try {
			ServerSocket serverSocket = new ServerSocket();
			
			serverSocket.bind(inetSocketAddress);
			Usuarios[] usuarios = new Usuarios[5];
			int cont = 0;
			while (cont<5){
				Socket aceptar = serverSocket.accept();
				HiloRecibir hilorecibir = new HiloRecibir(aceptar);
				hilorecibir.start();
				cont++;
				for (int i = 0; i < 5; i++){
					if (sockets[i] == null){
						sockets[i] = aceptar;
					}
				}
				
				System.out.println("Cliente conectado.");
			}
		} catch (Exception e) {
			System.out.println("Imposible conectar con el cliente");
		}
	}
}

class HiloMandar extends Thread{
	private Socket cliente;
	private Mensaje mensaje;
	public HiloMandar(Socket cliente, Mensaje mensaje){
		this.cliente = cliente;
		this.mensaje = mensaje;
	}
	public void run(){
		if (mensaje.getCodigo() == 2){
			
		}else if (mensaje.getCodigo() == 5){
			
		}else if (mensaje.getCodigo() == 6){
			
		}
	}
}
class HiloRecibir extends Thread{
	private Socket cliente;
	public HiloRecibir(Socket cliente){
		this.cliente = cliente;
	}
	
	public void run(){
		do{
			int i = 0;
			try{ 
				ObjectInputStream objectInputStream = new ObjectInputStream(cliente.getInputStream());
				Mensaje mensaje = new Mensaje();
				
				mensaje = (Mensaje)objectInputStream.readObject();
				if (mensaje.getCodigo() == 1){
					Mensaje mensaje2 = new Mensaje(2, mensaje.getUsuario(), " Conectado");
					ServerActivity.usuarios[i] = mensaje.getUsuario();
					i++;
					HiloMandar hiloMandar = new HiloMandar(cliente, mensaje2);
					hiloMandar.start();
				}else if (mensaje.getCodigo() == 3){
					Mensaje mensaje2 = new Mensaje(5, mensaje.getUsuario(), mensaje.getMensaje());
					HiloMandar hiloMandar = new HiloMandar(cliente, mensaje2);
					hiloMandar.start();
				}else {
					System.out.println("Codigo no correcto.");
				}
				for (int a = 0; a < 5; a++){
					if (ServerActivity.sockets[i].isConnected()){
					}else {
						ServerActivity.sockets[i].close();
						ServerActivity.sockets[i]= null;
						Mensaje mensaje4 = new Mensaje(2, ServerActivity.usuarios[i], " Desconectado");
						HiloMandar hiloMandar = new HiloMandar(ServerActivity.sockets[i], mensaje);
						hiloMandar.start();
					}
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}while(true);
	}
}