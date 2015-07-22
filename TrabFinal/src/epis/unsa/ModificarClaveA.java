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
public class ModificarClaveA extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String us = req.getParameter("usuario");
		String pwA = req.getParameter("passwA");
		String pwN = req.getParameter("passwN");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//Query es la BD de javaAPI(jdo)
		Query q = pm.newQuery(Cuenta.class);
		
		//final PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try{
			
			
				q.setFilter("usuario == '"+us+"'");
				List<Cuenta> usu = (List<Cuenta>)(q.execute());
				if(usu.size()>=1){//si existe una ocurrencia
					for(int i=0;i<usu.size();i++){
						if(usu.get(i).getContraseña().equals(pwA)){
							//si coincide la contraseña
							usu.get(i).setcontrasseña(pwN);
							RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/confirmarMod.jsp");
							rd.include(req, resp);
							break;
						}
					}
				}		
			
			
		}
		catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrio un error, vuelva a intentarlo.");
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/error.jsp");
			rd.include(req, resp);
		}finally{
			pm.close();
		}
			
	}
}