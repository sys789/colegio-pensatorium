package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import beans.Alumno;

@SuppressWarnings("serial")
public class Registrar extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String nomb = req.getParameter("nomb");
		String apell = req.getParameter("apell");
		String grado = req.getParameter("grado");
		String corr = req.getParameter("corr");
		String sex = req.getParameter("sex");
		String us = req.getParameter("us");
		String passw = req.getParameter("passw");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Alumno alumno = new Alumno(nomb,apell,corr,grado,sex,us,passw);
		//final Cuenta c = new Cuenta(us,passw);
		try{
			pm.makePersistent(alumno);
			req.setAttribute("alumno", alumno);
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/nuevoAlumno.jsp");
			rd.include(req, resp);
			
		}catch(Exception e){
			System.out.println(e);
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/error.jsp");
			rd.include(req, resp);
		}finally{
			pm.close();
		}
	}
}
