package epis.unsa;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Alumno {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String nombre;
	@Persistent
	private String apellido;
	@Persistent
	private String correo;
	@Persistent
	private String grado;
	@Persistent
	private String sexo;
	@Persistent
	private Cuenta cuenta;
	@Persistent
	private Pensiones pension;
	
	public Alumno(String n, String ap, String cr, String grado,String sx, String usuario,String contraseña) {
		super();
		nombre =n;
		apellido =ap;
		correo=cr;
		sexo=sx;
		cuenta=new Cuenta(usuario,contraseña);
		pension=new Pensiones();
	}

	public String getNombre() {
		return nombre;
	}

	public void setName(String n) {
		nombre=n;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String ap) {
		apellido =ap;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String cr) {
		correo=cr;
	}
	public String getGrado() {
		return grado;
	}

	public void setGrado(String gr) {
		grado=gr;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sx) {
		sexo=sx;
	}
	public Cuenta getCuenta(){
		return cuenta;
	}
	public void setCuenta(String us,String ct){
		cuenta.setUsuario(us);
		cuenta.setcontrasseña(ct);
	}
	public Pensiones getPension(){
		return pension;
	}
	
	public Key getKey() {
		return key;
	}
	
	@Override
	public String toString() {
		String resp = nombre + " : " + apellido + " : " + correo + " : " + sexo;  
		return resp;
	}
}
