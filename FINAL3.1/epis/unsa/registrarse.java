package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class registrarse extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/registrarse.jsp");
		rd.include(request, response);
					
	}

}