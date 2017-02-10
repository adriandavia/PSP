import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Servidor {
	public static void main(String[] args) {
		System.out.println("Arrancando el servidor...");
		try{
			InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 5555);
			DatagramSocket datagramSocket = new DatagramSocket(inetSocketAddress);
			
			while (datagramSocket != null){
				try{
					System.out.println("Esperando opción...");
					
					byte[] buffer = new byte[32];
					DatagramPacket datagramPacket = new DatagramPacket(buffer, 32);
					datagramSocket.receive(datagramPacket);
					
					String mensaje = new String(datagramPacket.getData());
					
					InetAddress ineAddress = datagramPacket.getAddress();
					int clientPort = datagramPacket.getPort();
					
					System.out.println("Mensaje recibido desde: " + ineAddress +", puerto " + clientPort);
					
					if (mensaje.contains("agend")){
						BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/adrian/workspace/ServidorClienteTelefonos/src/telefonos.txt"));
						String mensaje2;
						DatagramPacket datagramPacket2;
						while ((mensaje2 = bufferedReader.readLine()) != null){
							DatagramSocket datagramSocket2 = new DatagramSocket();
							datagramPacket2 = new DatagramPacket(mensaje2.getBytes(),mensaje2.getBytes().length, ineAddress, clientPort);
							datagramSocket2.send(datagramPacket2);
							datagramSocket2.close();
						}
						DatagramSocket datagramSocket2 = new DatagramSocket();
						mensaje2 = "fin";
						datagramPacket2 = new DatagramPacket(mensaje2.getBytes(), mensaje2.getBytes().length, ineAddress, clientPort);
						datagramSocket2.send(datagramPacket2);
						datagramSocket2.close();
						
					}else{
						System.out.println("Guardando " + mensaje + "en la lista...");
						try{
							BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/adrian/workspace/ServidorClienteTelefonos/src/telefonos.txt", true));
							bufferedWriter.write(mensaje);
							bufferedWriter.newLine();
							bufferedWriter.close();
						}catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println("Mensaje guardado con exito.");
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}catch (SocketException e) {
			e.printStackTrace();
		}
		
	}
}
