package beans;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.util.*;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Alumno {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private int estado;
	@Persistent
	private String codigo;
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
	@Persistent
	private ArrayList<Recibo> recibos;
	
	public Alumno(String n, String ap, String cr, String gr,String sx, String usuario,String contraseña) {
		super();
		estado=0;
		codigo=usuario;
		nombre =n;
		apellido =ap;
		correo=cr;
		grado=gr;
		sexo=sx;
		cuenta=new Cuenta(usuario,contraseña);
		pensiones=new ArrayList<Pension>();
		this.renovPensiones(pensiones);
		recibos=new ArrayList<Recibo>();
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
	public String getCodigo(){
		return this.codigo;
	}
	public void setCodigo(String co){
		this.codigo=co;
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
	public Pension getPension(String m){
		int i=0;
		Pension p=new Pension();
		for(i=0;i<pensiones.size();i++){
			if(pensiones.get(i).getMes().equals(m))
				p=pensiones.get(i);
		}
		return p;
	}
	
	public void addRecibo(Recibo rec){
		Recibo nuevo=rec;
		this.recibos.add(nuevo);
	}
	public ArrayList<Recibo> getRecibos(){
		return recibos;
	}
	public void setRecibos(ArrayList<Recibo> r){
		this.recibos=r;
	}
	public void setEstado(int es){
		this.estado=es;
	}
	public int getEstado(){
		return this.estado;
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
