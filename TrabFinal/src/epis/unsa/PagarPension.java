package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import beans.Alumno;
import beans.Pension;
import beans.Recibo;

@SuppressWarnings("serial")
public class PagarPension extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Alumno.class);
		
		PrintWriter out = resp.getWriter();
		
		String mes=req.getParameter("mes");
		String monto=req.getParameter("monto");
		double mont=Double.parseDouble(monto);
		
		HttpSession sesion=req.getSession();
		String us=(String)sesion.getAttribute("variable");
		sesion.setAttribute("mes", mes);
		
		List<Alumno> alumnos = (List<Alumno>) q.execute();
		
		try{
		int i=0;
		for(i=0;i<alumnos.size();i++){
			
			if(us.equals(alumnos.get(i).getCuenta().getUsuario())){	
				for(int j=0;j<alumnos.get(i).getPensiones().size();j++){
					if(mes.equals(alumnos.get(i).getPensiones().get(j).getMes())){
						
						if(alumnos.get(i).getPensiones().get(j).getSaldo()==0){
							RequestDispatcher rd2 = req.getRequestDispatcher("WEB-INF/jsp/errormes.jsp");
							rd2.forward(req, resp);
						}
						else{						
						if(mont>alumnos.get(i).getPensiones().get(j).getSaldo() || mont<0){
							RequestDispatcher rd3 = req.getRequestDispatcher("WEB-INF/jsp/errormonto.jsp");
							rd3.include(req, resp);
						}
						else{
							
								String c=alumnos.get(i).getCuenta().getUsuario();
								String n=alumnos.get(i).getNombre()+" "+alumnos.get(i).getApellido();								
						        String concep="Pago mes: "+alumnos.get(i).getPensiones().get(j).getMes();
						        double mo=alumnos.get(i).getPensiones().get(j).getSaldo();
						        double can=mont;
						        double sal=mo-can;						    
						        
						        final Recibo r=new Recibo(c,n,concep,mo,can,sal);
						        						     
						        alumnos.get(i).getPensiones().get(j).setSaldo(alumnos.get(i).getPensiones().get(j).getSaldo()-mont);
						        alumnos.get(i).addRecibo(r);	
						        						     
						        pm.makePersistent(r);
						        
						break;
						}
						}
					}
				}
				
			break;
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/realizado.jsp");
		rd.include(req, resp);
		}
		catch(Exception e){
			System.out.println(e);
			RequestDispatcher rd7=req.getRequestDispatcher("WEB-INF/jsp/deudas.jsp");
			rd7.include(req, resp);
		}finally{
			pm.close();
		}
		
	}
}

