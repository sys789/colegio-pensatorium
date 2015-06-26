package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Ingresar extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		/*String us = req.getParameter("usuario");
		String pw = req.getParameter("passw");
				
		Cuenta profSeverus = new Cuenta("severus","1234");
		Cuenta profAlbus = new Cuenta("albus","6789");
		Cuenta secreYayita = new Cuenta("yayita","condorito123");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			
			
		}catch(Exception e){
			
			System.out.println(e);
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html");
			resp.getWriter().println("Ocurrio un error, <a href='inicio.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
		*/
		resp.setContentType("text/plain");
		String us = req.getParameter("usuario");
		String pw = req.getParameter("passw");
		
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		if(us.equals("severus")&&pw.equals("1234")){
			resp.getWriter().println("bienevenido profesor Severus Snape");
			resp.sendRedirect("/bienvenidoP.jsp");
		}
		if(us.equals("albus")&&pw.equals("6789")){
			resp.getWriter().println("bienevenido profesor Albus");
			resp.sendRedirect("/bienvenidoP.jsp");
		}
		if(us.equals("yayita")&&pw.equals("condorito123")){
			resp.getWriter().println("bienevenido secretaria yayita");
			resp.sendRedirect("/bienvenidoS.jsp");
		}
		
		try{
			
			
			/*if(us==cuenta.getUsuario()&&pw==cuenta.getContrasea()){
				resp.getWriter().println("bienevenido alumno"+cuenta.getUsuario());
				resp.sendRedirect("/bienvenidoA.jsp");
			}*/
			
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurriñ un error, vuelva a intentarlo.");
			resp.sendRedirect("/index.jsp");
		}finally{
			pm.close();
		}
	}
}