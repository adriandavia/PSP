import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try {
			
			int opcion;
			String telf;
			Scanner scan = new Scanner(System.in);
			
			DatagramSocket datagramSocket = new DatagramSocket();
			
			do{
				
				System.out.println("------------------ MENU ------------------");
				System.out.println("0. Salir.");
				System.out.println("1. Ver lista de teléfonos.");
				System.out.println("2. Introducir teléfono.");
				System.out.println("------------------------------------------");
				System.out.print("Elige una de las siguientes acciones: ");
				opcion = scan.nextInt();
				
				InetAddress serverAddr = InetAddress.getByName("localhost");
				DatagramPacket datagrama;
				
				switch (opcion) {
				case 0: 
					break;
				case 1:
					System.out.println("Listado de teléfonos: ");
					String mensaje = "agenda";
					datagrama = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length, serverAddr, 5555);
					datagramSocket.send(datagrama);
					
					byte[] buffer = new byte[1000];
					DatagramPacket datagramPacket = new DatagramPacket(buffer, 1000);
					
					String mensaje2 = null;
					do{
						datagramSocket.receive(datagramPacket);
						mensaje2 = new String(datagramPacket.getData());
						if (mensaje2.contains("fin")){
						}else{
							System.out.println(mensaje2);
						}
					}while (!mensaje2.contains("fin"));
					System.out.println("");
					break;
				case 2:
					System.out.print("Introduce nombre y número de telefono: ");
					telf = scan.next();
					datagrama = new DatagramPacket(telf.getBytes(),telf.getBytes().length, serverAddr, 5555);
					datagramSocket.send(datagrama);
					System.out.println("");
					break;

				default:
					break;
				}
			}while(opcion != 0);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}