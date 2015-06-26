package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Registrarse extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String nomb = req.getParameter("nomb");
		String apell = req.getParameter("apell");
		String grado = req.getParameter("grado");
		String corr = req.getParameter("corr");
		String sex = req.getParameter("sex");
		String us = req.getParameter("us");
		String passw = req.getParameter("passw");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Alumno p = new Alumno(nomb,apell,corr,grado,sex,us,passw);
		final Cuenta c = new Cuenta(us,passw);
		try{
			pm.makePersistent(p);
			pm.makePersistent(c);
			resp.getWriter().println("Datos grabados correctamente.");
			resp.sendRedirect("/getList");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, vuelva a intentarlo.");
			resp.sendRedirect("/index.jsp");
		}finally{
			pm.close();
		}
	}
}
