package beans;


import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Cuenta {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String usuario;
	@Persistent
	private String contrase�a;
			
	public Cuenta() {}
	public Cuenta(String us,String ct) {
		usuario=us;
		contrase�a=ct;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String us) {
		usuario=us;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setcontrasse�a(String ct) {
		contrase�a=ct;
	}
	public Key getKey() {
		return key;
	}
	
	@Override
	public String toString() {
		String resp = usuario + " : " + contrase�a;  
		return resp;
	}
}
