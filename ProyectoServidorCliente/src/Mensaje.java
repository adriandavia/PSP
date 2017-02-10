public class Mensaje {
	private Integer codigo;
	private String usuario;
	private String mensaje;
	
	public Mensaje(Integer codigo, String usuario, String mensaje){
		this.codigo = codigo;
		this.usuario = usuario;
		this.mensaje = mensaje;
	}
	
	public Mensaje(){
	}
	
	public Integer getCodigo(){
		return this.codigo;
	}
	public String getUsuario(){
		return this.usuario;
	}
	public String getMensaje(){
		return this.mensaje;
	}
}
