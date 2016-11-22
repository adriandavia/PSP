package Ejercicios1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio1 {
	public static void main(String[] args) {
		
		try {
			String comando ="ifconfig";
		
		Process proceso1 = Runtime.getRuntime().exec(comando);
		
		InputStreamReader entrada1 = new InputStreamReader(proceso1.getInputStream());
        BufferedReader salida1 = new BufferedReader(entrada1);
		
        String line;
        
        while ((line=salida1.readLine()) !=null) {
        		System.out.println(line);
		}
        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
