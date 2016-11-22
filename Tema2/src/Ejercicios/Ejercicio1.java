package Ejercicios;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int numero=scan.nextInt();
		
		hilo app = new hilo(numero);
		app.start();
	}
}


class hilo extends Thread{
	public int numero;
	public hilo(int numero){
		this.numero=numero;
	}
	
	public void run(){
		int num1=0;
		int num2=1;
		int suma=0;
		int cont=2;
		
		if (numero==1){
			System.out.println(num1);
		}
		if (numero==2){
			System.out.println(num1+" "+num2);
		}
		/* SI LOS NUMEROS INTRODUCIDOS ES MAYOR QUE 2 **/
		if (numero > 2){
			/* MUESTRA LOS 2 PRIMEROS NUMERO **/
			System.out.println(num1+" "+num2+" ");
			/* RECORREMOS LOS NUMEROS INTRODUCIDOS**/
			for (int i=0; i <=numero; i++){
				/*hace la suma de los numeros anteriores y los va guardando y acumulando**/
				if(cont < numero){
					suma=num1+num2;
					System.out.println(suma +" ");
					cont++;
					if(cont <numero){
						num1=num2+suma;
						cont++;
						System.out.println(num1+" ");
						if(cont < numero){
							num2=suma+num1;
							System.out.println(num2+" ");
							cont++;
						}
					}
				}
			}
		}
	}
}

