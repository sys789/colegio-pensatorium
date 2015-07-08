package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Alumno;

@SuppressWarnings("serial")
public class Remove extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();	
		
		if( req.getParameter("nomb")!=null ){ 
			String nomb = req.getParameter("nomb");
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			final Query q = pm.newQuery(Alumno.class);
			q.setFilter("nombre == colorParam"); 
			q.declareParameters("String colorParam");	
			try{
				@SuppressWarnings("unchecked")
				Alumno p =(Alumno) q.execute(nomb);
				pm.deletePersistent(p);
				
				
				/* ---------------------------------------------------------
				 */
				RequestDispatcher rd = getServletContext().getRequestDispatcher("WEB-INF/jsp/noticias.jsp");
				rd.include(req, resp);
			}catch(Exception e){
					System.out.println(e);
					resp.getWriter().println("No se han podido borrar personas.");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
					rd.include(req, resp);
			}finally{
				q.closeAll();
				pm.close();
			}			
		}else {		
			resp.getWriter().println("No se ha especificado el color.");
			resp.sendRedirect("WEB-INF/jsp/error.jsp");
		}		
	}
}

