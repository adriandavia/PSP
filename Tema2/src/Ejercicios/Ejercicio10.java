package Ejercicios;

import java.io.*;

public class Ejercicio10 extends Thread {
	    public static FileWriter fichero;
	   
	    public Ejercicio10(String nom){
	        this.setName(nom);
	    }
	   
	    public void run(){
	        if(this.getName().compareTo("padre")==0) //PARA COMPARAR EL NOMBRE
	            this.titulo();
	        if(this.getName().compareTo("hilo1")==0) //PARA COMPARAR EL NOMBRE
	            this.estrofa1();
	        if(this.getName().compareTo("hilo2")==0) //PARA COMPARAR EL NOMBRE
	            this.estrofa2();
	    }
	   
	     public synchronized void titulo(){
	        try {
	            fichero = new FileWriter ("vetusta.txt");
	            BufferedWriter bw1 = new BufferedWriter(fichero);
	            String titulo="Vetusta Morla - La deriva";
	            bw1.write(titulo);
	            bw1.newLine();           
	            bw1.close();
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }           
	     }
	     
	     public synchronized void estrofa1(){
	         try {   
	                 //PARA SEGUIR AÑADIENDO TEXTO EN UN ARCHIVO, INDICAR LA RUTA DONDE ESTÁ EL DOCUMENTO
	                BufferedWriter bw2 = new BufferedWriter(new FileWriter("/home/mati/Escritorio/PSP/Tema2/vetusta.txt",true));
	                String linea1="He tenido tiempo de desdoblarme";
	                String linea2="y ver mi rostro en otras vidas.";
	                String linea3="Ya tiré la piedra al centro del estanque.";
	                bw2.write(linea1,0,linea1.length());
	                bw2.newLine();
	                bw2.write(linea2,0,linea2.length());
	                bw2.newLine();
	                bw2.write(linea3,0,linea3.length());
	                bw2.newLine();
	                bw2.close();
	            } catch (IOException e) {
	                System.out.println(e.getMessage());
	               
	            }
	           
	        }
	     public synchronized void estrofa2(){
	         try {               
	                BufferedWriter bw3 = new BufferedWriter(new FileWriter("/home/mati/Escritorio/PSP/Tema2/vetusta.txt",true));
	                String linea4="He enterrado cuentos y calendario";
	                String linea5="ya cambié el balón por gasolina.";
	                String linea6="Ha prendido el bosque al incendiar la orilla.";               
	                bw3.write(linea4,0,linea4.length());
	                bw3.newLine();
	                bw3.write(linea5,0,linea5.length());
	                bw3.newLine();
	                bw3.write(linea6,0,linea6.length());
	                bw3.newLine();
	                bw3.close();
	            } catch (IOException e) {
	                System.out.println(e.getMessage());
	               
	            }
	           
	        }
	   
	   
	public static void main(String[] args) {
	    Ejercicio10 padre= new Ejercicio10("padre");//se necesita constructor
	    Ejercicio10 hilo1= new Ejercicio10("hilo1");
	    Ejercicio10 hilo2= new Ejercicio10("hilo2");
	    padre.start();
	    hilo1.start();
	    hilo2.start();
	  
	    //PARA ACTUALIZAR EL ESTADO DEL CONTADOR, LOS HILOS SE TIENE QUE ESPERAR A QUE TERMINEN
	    try{
	        padre.join();
	        hilo1.join();
	        hilo2.join();
	      
	    }catch(Exception e){
	       System.out.println(e.getMessage());
	    }
	}
	}

