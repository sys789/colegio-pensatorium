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
public class generarRecibo extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Alumno.class);
		
		PrintWriter out = resp.getWriter();
		
		HttpSession sesion=req.getSession();
		
		String us=(String)sesion.getAttribute("variable");
		String mes=(String)sesion.getAttribute("mes");
		
		List<Alumno> alumnos = (List<Alumno>) q.execute();
		
		try{
			int i=0;
			for(i=0;i<alumnos.size();i++){				
				if(us.equals(alumnos.get(i).getCuenta().getUsuario())){
					for(int j=0;j<alumnos.get(i).getPensiones().size();j++){
						if(mes.equals(alumnos.get(i).getPensiones().get(j).getMes())){
							req.setAttribute("alumno", alumnos.get(i));
							req.setAttribute("recibo", alumnos.get(i).getRecibos().get(alumnos.get(i).getRecibos().size()-1));
							req.setAttribute("pension", alumnos.get(i).getPensiones().get(j));
							break;
						}
					}
					
				}
		
			}
			
			RequestDispatcher rd3 = req.getRequestDispatcher("WEB-INF/jsp/recibos.jsp");
			rd3.include(req, resp);
		}
		catch(Exception e){
			System.out.println(e);
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/recibos.jsp");
			rd.include(req, resp);
		}finally{
			pm.close();
		}
		
	}
}

