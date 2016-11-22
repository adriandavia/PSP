package Ejercicios1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.BufferedReader;

public class Ejercicio6 {
	public static void main(String[] args) {
		
		try {	
			System.out.println("ESCRIBE LINEAS");
			
			Process hijo1 = new ProcessBuilder("./aleatorios").start();
			
			InputStream entrada = hijo1.getInputStream();
			InputStreamReader entrada2 = new InputStreamReader(entrada); //LECTOR
			BufferedReader salida1 =new BufferedReader(entrada2);
			
			PrintStream ps =new PrintStream(hijo1.getOutputStream());
			
	        BufferedReader salida2 = new BufferedReader(new InputStreamReader(System.in));
	        
			String vacio;
			
			 while((vacio=salida2.readLine()).compareTo("fin") !=0) {
                 ps.println(vacio);
                 ps.flush(); //LIMPIAR EL BUFFER
                 
                 if ((vacio=salida1.readLine()) !=null){
                  	System.out.println(vacio);
                 }	
             }  
			 
			 System.out.println("salida del proceso" + Arrays.toString(args)+ " : ");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	}
}
