package beans;


import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Noticia {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String autor;
	@Persistent
	private Date fecha;
	@Persistent
	private String asunto;
	@Persistent
	private String datos;
				
	public Noticia() {}
	public Noticia(String au,String as,String d) {
		autor=au;
		asunto=as;
		datos=d; 
		TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
		this.fecha = new Date();
	}
	
	public String getAutor() {
	  return autor;
	}
	public void setAutor(String autor) {
	  this.autor = autor;
	}
	public Date getFecha() {
	  return fecha;
	}
	public void setFecha(Date fecha) {
	  this.fecha = fecha;
	}
	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String a) {
		datos=a;
	}
	public String getDatos() {
		return datos;
	}

	public void setDatos(String d) {
		datos=d;
	}

	
	public Key getKey() {
		return key;
	}
	
	
}
