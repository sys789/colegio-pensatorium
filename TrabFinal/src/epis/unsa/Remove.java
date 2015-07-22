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
		
		if( req.getParameter("codigo")!=null ){ 
			String codigo = req.getParameter("codigo");
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			final Query q = pm.newQuery(Alumno.class);
			q.setFilter("codigo == colorParam"); 
			q.declareParameters("String colorParam");	
			try{
				q.deletePersistentAll(codigo);
				/* --------------------------------------------------------
				 */
				//@SuppressWarnings("unchecked")
				//List<Persona> personas = (List<Persona>) q.execute(color);
				//for(Persona p: personas){
					//pm.deletePersistent(p);
				//}
				/* ---------------------------------------------------------
				 */
				RequestDispatcher rd=req.getRequestDispatcher("/getList");
				rd.include(req, resp);
			}catch(Exception e){
					System.out.println(e);
					RequestDispatcher rd=req.getRequestDispatcher("inicio.html");
					rd.include(req, resp);
			}finally{
				q.closeAll();
				pm.close();
			}			
		}else {		
			resp.getWriter().println("No se ha especificado el codigo.");
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/inicio.html");
			rd.include(req, resp);
		}	
	}
}

