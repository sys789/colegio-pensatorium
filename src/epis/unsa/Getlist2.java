package epis.unsa;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@SuppressWarnings("serial")
	public class Getlist2 extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			//resp.setContentType("text/plain");
			
			final PersistenceManager pm = PMF.get().getPersistenceManager();
			final Query q = pm.newQuery(Noticia.class);
			
			if( req.getParameter("autor")!=null ){
				
				String color = req.getParameter("autor");
				//q.setOrdering("key ascending");
				q.setOrdering("key descending");
				q.setRange(0, 10);
				q.setFilter("autor == colorParam");
				q.declareParameters("String colorParam");
				
				try{
					
					@SuppressWarnings("unchecked")
					List<Noticia> personas = (List<Noticia>) q.execute(color);
					req.setAttribute("personas", personas);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/noticias.jsp");
					rd.forward(req, resp);
				
				}catch(Exception e){
					System.out.println(e);
				}finally{
					q.closeAll();
					pm.close();
				}
				
			}else {
				q.setOrdering("key descending");
				q.setRange(0, 10);
				
						 
				try{
					@SuppressWarnings("unchecked")
					List<Noticia> personas = (List<Noticia>) q.execute();
					if( personas.isEmpty() ){
						pm.makePersistent(new Noticia("severus","matriculas","estimados alumnos"));
					}
					req.setAttribute("personas", personas);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/noticias.jsp");
					rd.forward(req, resp);
				}catch(Exception e){
					System.out.println(e);
				}finally{
					q.closeAll();
					pm.close();
				}
			}			
		}
	}

	