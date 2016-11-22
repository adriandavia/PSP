package tema1;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ejercicio1 {
	public static void main (String[] args) throws IOException {
		String comando1="ls -la";
        String comando2="tr 'd' 'D'";
        String vacio;       
       
        try {
        
            /**PONEMOS LOS PROCESOS EN MARCHA*/
            Process proceso1= Runtime.getRuntime().exec(comando1);
            Process proceso2= Runtime.getRuntime().exec(comando2);
           
            /**ASIGNAMOS LOS COMANDOS A UN BUFFER PARA VERLOS POR PANTALLA*/
            InputStreamReader entrada1 = new InputStreamReader(proceso1.getInputStream());
            BufferedReader salida1 = new BufferedReader(entrada1);
            
            
           /**SALIDA DEL HIJO1 ES LA ENTRADA DEL HIJO2*/
            OutputStream ous =proceso2.getOutputStream();
            
            /**INSERTAR DATOS EN EL OUTPUTSTREAM*/
            
            PrintStream ps =new PrintStream(ous);
            InputStreamReader entrada2 = new InputStreamReader(proceso2.getInputStream());
            BufferedReader salida2 = new BufferedReader(entrada2);
           
            /**LEEMOS EL BUFFER DEL PROCESO1*/
                while((vacio=salida1.readLine()) !=null) {
                    ps.println(vacio);
                    ps.flush();
                }
               
            /**SI PROCESO 1 A TERMINADO DE LEER, QUE SIGA EL 2*/
                while ((vacio=salida2.readLine()) !=null){
                	System.out.println(vacio);
                }     
               
        } catch (Exception e) {
            System.out.println("error inesperado");
            e.printStackTrace();
        } 
    }
}

