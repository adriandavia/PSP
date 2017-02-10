public class Usuarios {
	private String usuario;
	private int puerto;
	
	public Usuarios(String usuario, int puerto){
		this.usuario = usuario;
		this.puerto = puerto;
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	public int getPuerto(){
		return this.puerto;
	}
}
