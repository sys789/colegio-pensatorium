package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Alumno;

@SuppressWarnings("serial")
public class getPagos extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	final PersistenceManager pm = PMF.get().getPersistenceManager();
	final Query q = pm.newQuery(Alumno.class);
	PrintWriter out = resp.getWriter();
	
	String us=req.getParameter("codigo");
	HttpSession sesion=req.getSession();
	
	if(sesion.getAttribute("nombre")!=null){
		try {
			@SuppressWarnings("unchecked")
			List<Alumno> alumnos = (List<Alumno>) q.execute();
			int i=0;
			for(i=0;i<alumnos.size();i++){
				if(us.equals(alumnos.get(i).getCuenta().getUsuario())){
					req.setAttribute("alumno", alumnos.get(i));
					RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/ultimospagos.jsp");
					rd.forward(req, resp);
					break;
				}
			}
			if(i==alumnos.size()){
				RequestDispatcher rd2=req.getRequestDispatcher("WEB-INF/jsp/noencontrado.jsp");
				rd2.include(req, resp);
			}
		}finally{ 
			out.close();
		}
		}
	else{
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/noSesion.jsp");
		rd.forward(req, resp);
	}
		
	
	}
}