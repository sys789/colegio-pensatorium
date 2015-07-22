package epis.unsa;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TimeZone;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import beans.*;

@SuppressWarnings("serial")
public class NuevaCuenta extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String us = req.getParameter("usuario");
		String passw = req.getParameter("passw");
		
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Cuenta c = new Cuenta(us,passw);
		try{
			pm.makePersistent(c);
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/nuevaCuenta.jsp");
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
