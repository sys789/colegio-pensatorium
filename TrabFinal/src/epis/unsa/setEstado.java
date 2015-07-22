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
public class setEstado extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Alumno.class);
		
		PrintWriter out = resp.getWriter();
		
		String opcion=req.getParameter("opcion");
		String[]meses=req.getParameterValues("meses");
		
		HttpSession sesion=req.getSession();
		String us=(String)sesion.getAttribute("variable");
		
		List<Alumno> alumnos = (List<Alumno>) q.execute();
		
		try{
		int i=0;
		for(i=0;i<alumnos.size();i++){
			
			if(us.equals(alumnos.get(i).getCuenta().getUsuario())){
				if(opcion.equals("ninguna")){
					alumnos.get(i).setEstado(0);
					if(meses!=null && meses.length>0){
						for(int k=0;k<meses.length;k++){
							alumnos.get(i).getPension(meses[k]).setMonto(200);
							alumnos.get(i).getPension(meses[k]).setSaldo(200);					
						}							
					}
				}
				if(opcion.equals("media")){
					alumnos.get(i).setEstado(1);
					if(meses!=null && meses.length>0){
						for(int k=0;k<meses.length;k++){
							alumnos.get(i).getPension(meses[k]).setMonto(100);
							alumnos.get(i).getPension(meses[k]).setSaldo(100);;
						}							
					}
				}
				if(opcion.equals("completa")){
					alumnos.get(i).setEstado(2);
					if(meses!=null && meses.length>0){
						for(int k=0;k<meses.length;k++){
							alumnos.get(i).getPension(meses[k]).setMonto(0);
							alumnos.get(i).getPension(meses[k]).setSaldo(0);
						}							
					}
				}
				
			break;
			}
		}
		req.setAttribute("alumno", alumnos.get(i));
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/realizado2.jsp");		
		rd.include(req, resp);
		
		}
		catch(Exception e){
			System.out.println(e);
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/realizado2.jsp");
			rd.include(req, resp);
		}finally{
			pm.close();
		}
		
	}
}

