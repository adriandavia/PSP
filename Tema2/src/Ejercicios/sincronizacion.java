package Ejercicios;

public class sincronizacion extends Thread {
    public int inicio=0;
    static private sincronizacion hilo1 = new sincronizacion();
    static private sincronizacion hilo2;
    private int contador1;
      
    public void run(){
        System.out.println("ejecutando metodo run");
        System.out.println("hilo1 se llama "+this.getName());

        if (Thread.currentThread().getName().equals("hilo1")){
            System.out.println("pasando el if");
        if(inicio <=10){
            System.out.println("entrando en el while");
            for(int i=0; inicio<10;i++){
            contador1 = inicio++;     
            }
            
            System.out.println("Ahora inicio vale "+inicio);
            
            
            try {
            	hilo2.interrupt();
            	hilo2.join();
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
                      
                              
            }
       
        }else{
        	
        	try {
            	hilo1.join();
            } catch (InterruptedException e) {
            	
            	for(int j=0; inicio>5;j--){
                    contador1=inicio--;
                    }
            	
            	
            }
        	System.out.println("Al final del proceso vale "+inicio);
        }
                  
    }
    
    public static void main(String[] args) {
  
    hilo1.setName("hilo1");
    hilo2 = new sincronizacion();
    hilo2.setName("hilo2");
    System.out.println("hilo1 empezando");
    hilo1.start();
   
    System.out.println("hilo2 empezando");   
    hilo2.start();
    
    try {
        hilo1.join();
        hilo2.join();
        System.out.println("hilo1 esperando");
    }catch (InterruptedException e) {
        System.out.println("hilo1 no esta esperando");
    }
  
    }
}  	


