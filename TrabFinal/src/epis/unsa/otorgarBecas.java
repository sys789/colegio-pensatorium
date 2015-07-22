package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class otorgarBecas extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession sesion=request.getSession();
				
		if(sesion.getAttribute("nombre")!=null){
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/ingresarCodigo.jsp");
			rd.include(request, response);
			
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/noSesion.jsp");
			rd.include(request, response);
		}
					
	}

}