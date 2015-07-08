package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Alumno;
import beans.Cuenta;
import beans.Noticia;
import beans.Pensiones;

@SuppressWarnings("serial")
public class RemoveAll extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/plain");		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Alumno.class);
		final Query r = pm.newQuery(Cuenta.class);
		final Query s = pm.newQuery(Pensiones.class);
		final Query t = pm.newQuery(Noticia.class);

			try{
				q.deletePersistentAll();
				r.deletePersistentAll();
				s.deletePersistentAll();
				t.deletePersistentAll();
				/* --------------------------------------------------------
				 */
				//@SuppressWarnings("unchecked")
				//List<Tutorial> tutorials = (List<Tutorial>) q.execute(color);
				//for(Tutorial t: tutorials){
					//pm.deletePersistent(t);
				//}
				/* ---------------------------------------------------------
				 */
				resp.getWriter().println("Se han borrado todos los Tutoriales.");
				resp.sendRedirect("/getList");
			}catch(Exception e){
					System.out.println(e);
					resp.getWriter().println("No se han podido borrar todas personas.");
					resp.sendRedirect("/tutorial?action=show");
			}finally{
				q.closeAll();
				pm.close();
			}				
	}
}
