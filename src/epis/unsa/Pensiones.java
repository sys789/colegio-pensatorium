package epis.unsa;

import java.util.ArrayList;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Pensiones {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	
	@Persistent
	private String mes;
	@Persistent
	private final double monto=200;
	@Persistent
	private double cancelado;
	@Persistent
	private double saldo=0;
	@Persistent
	private ArrayList<Pensiones>pensiones;	
	
	
	public Pensiones(String m){
		mes=m;
	}
	public Pensiones() {
		pensiones=new ArrayList<Pensiones>();
		pensiones.add(new Pensiones("Marzo"));
		pensiones.add(new Pensiones("Abril"));
		pensiones.add(new Pensiones("Mayo"));
		pensiones.add(new Pensiones("Junio"));
		pensiones.add(new Pensiones("Julio"));
		pensiones.add(new Pensiones("Agosto"));
		pensiones.add(new Pensiones("Setiembre"));
		pensiones.add(new Pensiones("Octubre"));
		pensiones.add(new Pensiones("Novienbre"));
		pensiones.add(new Pensiones("Diciembre"));
	}

	public double getMonto() {
		return monto;
	}
	public double getCancelado() {
		return cancelado;
	}
	public void setCancelado(double c) {
		cancelado=c;
	}
	public double getSaldo() {
		saldo=monto-cancelado;
		return saldo;
	}
	public void setSaldo(double s) {
		saldo=s;
	}

	
}
