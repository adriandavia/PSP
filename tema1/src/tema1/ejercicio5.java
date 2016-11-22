package tema1;

import java.io.*;

public class ejercicio5 {
	public static void mai (String [] args) throws IOException{
		if(args.length <= 0) 
		{
		//	
		}
		try{
			
			int appsIniciadas = 0;
			
			Process[] process = new Process[args.length];
			
			for(String cmd:args)
			{
				process[appsIniciadas] = new ProcessBuilder(cmd).start();
				appsIniciadas ++;
				
				System.out.print(cmd +" "+ appsIniciadas);
			}
			
			for (int i=0; i<process.length; i++ )
			{
				process[i].waitFor();
				
			}
			
			System.out.println("Las aplicaciones se han cerrado con exito.");
			
		}catch(IOException | InterruptedException e){}
	}
}