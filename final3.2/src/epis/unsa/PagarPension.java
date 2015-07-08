package epis.unsa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import beans.Alumno;
import beans.Pension;

@SuppressWarnings("serial")
public class PagarPension extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query q = pm.newQuery(Alumno.class);
		
		PrintWriter out = resp.getWriter();
		
		String mes=req.getParameter("mes");
		String monto=req.getParameter("monto");
		double mont=Double.parseDouble(monto);
		
		HttpSession sesion=req.getSession();
		String a=(String)sesion.getAttribute("variable");
		
		List<Alumno> alumnos = (List<Alumno>) q.execute();
		
		for(int i=0;i<alumnos.size();i++){
			if(a.equals(alumnos.get(i).getNombre())){
				
				for(int j=0;j<alumnos.get(i).getPensiones().size();j++){
					if(mes.equals(alumnos.get(i).getPensiones().get(j).getMes())){
						alumnos.get(i).getPensiones().get(j).setCancelado(mont);
						break;
					}
				}
				
			break;
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/realizado.jsp");
		rd.forward(req, resp);
		/*
		Alumno al=(Alumno)req.getAttribute("alumno");
		String mes = req.getParameter("mes");
		String monto = req.getParameter("monto");
		double mont=Double.parseDouble(monto);
		ArrayList<Pension>pens=al.getPensiones();
		
		try{
			for(int i=0;i<pens.size();i++){
				if(mes.equals(pens.get(i).getMes())){
					pens.get(i).setCancelado(mont);
					break;
				}
			}
				
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/deudas.jsp");
			rd.forward(req, resp);
			
		}catch(Exception e){
			System.out.println(e);
			RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/jsp/error.jsp");
			rd.forward(req, resp);
		
		}finally{
			out.close();
		}
		*/
	}
}

