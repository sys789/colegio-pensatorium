package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class cerrar extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		PrintWriter out = resp.getWriter();
		HttpSession misesion= req.getSession();
		
		misesion.removeAttribute("nombre");
		misesion.invalidate(); //Cierra la sesion
		
		RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(req, resp);
	}
}
