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
import javax.servlet.http.HttpSession;

import beans.*;

	@SuppressWarnings("serial")
	public class GetListP extends HttpServlet{
		
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			//resp.setContentType("text/plain");
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			final Query q = pm.newQuery(Alumno.class);
			
			HttpSession sesion=req.getSession();
			
			if(sesion.getAttribute("nombre")!=null){
			
			if( req.getParameter("grado")!=null ){
				
				String grado = req.getParameter("grado");
				//q.setOrdering("key ascending");
				q.setOrdering("key descending");
				q.setRange(0, 10);
				q.setFilter("grado == colorParam");
				q.declareParameters("String colorParam");
				
				try{
					
					@SuppressWarnings("unchecked")
					List<Alumno> personas = (List<Alumno>) q.execute(grado);
					req.setAttribute("personas", personas);
					RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/getLIstP.jsp");
					rd.include(req, resp);
				
				}catch(Exception e){
					System.out.println(e);
					resp.getWriter().println("Ocurrio un error, vuelva a intentarlo.");
					RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/error.jsp");
					rd.include(req, resp);
				}finally{
					q.closeAll();
					pm.close();
				}
				
			}else {
				q.setOrdering("key descending");
				q.setRange(0, 10);
						 
				try{
					@SuppressWarnings("unchecked")
					List<Alumno> personas = (List<Alumno>) q.execute();
					req.setAttribute("personas", personas);
					RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/getLIstP.jsp");
					rd.include(req, resp);
				}catch(Exception e){
					System.out.println(e);
					resp.getWriter().println("Ocurrio un error, vuelva a intentarlo.");
					RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/error.jsp");
					rd.include(req, resp);
				}finally{
					q.closeAll();
					pm.close();
				}
			}
			
			}
			else{
				RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/noSesion.jsp");
				rd.forward(req, resp);
			}
				
		}
	}

	