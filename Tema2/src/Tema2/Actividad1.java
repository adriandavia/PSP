package Tema2;

import java.util.Scanner;

public class Actividad1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce el numero: ");
		int num = scanner.nextInt();
		
		FibonacciThread hilo = new FibonacciThread (num);
		hilo.start();
	}
}

class FibonacciThread extends Thread{
	public int numero;
	public FibonacciThread(int numero){
		this.numero=numero;		
	}
	
	public void run(){
		int n1 = 0;
		int n2 = 1;
		int suma = 0;
		int cont = 2;
		
		if (numero == 1){
			System.out.print(n1);
		}
		if(numero == 2){
			System.out.print(n1 + " " + n2);
		}
		if(numero > 2){
			System.out.print(n1 + " " + n2 + " ");
			for (int i = 0; i <= numero; i++){
				if (cont < numero){
					suma = n1 + n2;
					System.out.print(suma + " ");
					cont++;
					if (cont < numero){
						n1 = n2 + suma;
						cont++;
						System.out.print(n1 + " ");
						if (cont < numero){
							n2 = suma + n1;
							System.out.print(n2 + " ");
							cont++;
						}
					}
				}			
				
			}
		}
		
	}
	
}