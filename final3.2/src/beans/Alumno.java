package beans;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.util.*;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
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
	private ArrayList<Pension> pensiones;
	
	public Alumno(String n, String ap, String cr, String gr,String sx, String usuario,String contraseña) {
		super();
		nombre =n;
		apellido =ap;
		correo=cr;
		grado=gr;
		sexo=sx;
		cuenta=new Cuenta(usuario,contraseña);
		pensiones=new ArrayList<Pension>();
		this.renovPensiones(pensiones);
	}
	
	public void renovPensiones(ArrayList<Pension>p){
		p.add(new Pension("Marzo"));
		p.add(new Pension("Abril"));
		p.add(new Pension("Mayo"));
		p.add(new Pension("Junio"));
		p.add(new Pension("Julio"));
		p.add(new Pension("Agosto"));
		p.add(new Pension("Septiembre"));
		p.add(new Pension("Octubre"));
		p.add(new Pension("Noviembre"));
		p.add(new Pension("Diciembre"));
		
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
	public ArrayList<Pension> getPensiones(){
		return pensiones;
	}
	public void setPensiones(ArrayList<Pension> p){
		this.pensiones=p;
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
