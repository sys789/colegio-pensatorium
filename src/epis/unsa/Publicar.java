package epis.unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Publicar extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String autor = req.getParameter("autor");
		String asunto = req.getParameter("asunto");
		String datos = req.getParameter("datos");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Noticia p = new Noticia(autor,asunto,datos);
		try{
			pm.makePersistent(p);
			resp.getWriter().println("Datos grabados correctamente.");
			resp.sendRedirect("/getList2");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, vuelva a intentarlo.");
			resp.sendRedirect("/index.jsp");
		}finally{
			pm.close();
		}
	}
}
