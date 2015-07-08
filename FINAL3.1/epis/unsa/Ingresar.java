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
public class Ingresar extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String us = req.getParameter("usuario");
		String pw = req.getParameter("passw");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		//Query es la BD de javaAPI(jdo)
		Query q = pm.newQuery(Cuenta.class);
		
		//final PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			if(!us.isEmpty()&&!pw.isEmpty()){
				if(us.equals("severus")&&pw.equals("1234")){
					HttpSession misesion= req.getSession(true);
					misesion.setMaxInactiveInterval(1800);// 30 minutos
					misesion.setAttribute("nombre", us);
					RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/bienvenidoP.jsp");
					rd.include(req, resp);
				
				}
				if(us.equals("albus")&&pw.equals("6789")){
					HttpSession misesion= req.getSession(true);
					misesion.setMaxInactiveInterval(1800);// 30 minutos
					misesion.setAttribute("nombre", us);
					RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/bienvenidoP.jsp");
					rd.include(req, resp);
				}
				if(us.equals("yayita")&&pw.equals("condorito123")){
					HttpSession misesion= req.getSession(true);
					misesion.setMaxInactiveInterval(1800);// 30 minutos
					misesion.setAttribute("nombre", us);
					RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/bienvenidoS.jsp");
					rd.include(req, resp);
				
				}
			
				q.setFilter("usuario == '"+us+"'");
				List<Cuenta> usu = (List<Cuenta>)(q.execute());
				if(usu.size()>=1){//si existe una ocurrencia
					for(int i=0;i<usu.size();i++){
						if(usu.get(i).getContraseña().equals(pw)){
							//si coincide la contraseÃ±a
							HttpSession misesion= req.getSession(true);
							misesion.setMaxInactiveInterval(1800);// 30 minutos
							misesion.setAttribute("nombre", us);
							RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/bienvenidoA.jsp");
							rd.include(req, resp);
							break;
						}
					}
				}
				RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/error.jsp");
				rd.forward(req, resp);
				
			}
			else{
				RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/error.jsp");
				rd.forward(req, resp);
			}
			
			
			
		}
		catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrio un error, vuelva a intentarlo.");
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			rd.forward(req, resp);
		}finally{
			pm.close();
		}
		
	}
}