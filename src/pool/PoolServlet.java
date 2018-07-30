package pool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apoio.Common;
import coin.coinDAO;



@WebServlet(name = "Pool", urlPatterns = { "/Pool" })
public class PoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		if(request.getParameter("delete")!= null) {
			
			Pool pool = new Pool();
			pool.setId(Integer.parseInt(request.getParameter("delete")));
			
			poolDAO dao = new poolDAO();
			dao.deletePool(pool);
			
		    response.sendRedirect(Common.url_pool);

		}else if(request.getParameter("Filtrar") != null) {
			
			
			String nome = request.getParameter("nome");
			poolDAO dao = new poolDAO();
			dao.exibir_by_name(nome);
			
			response.sendRedirect(Common.url_pool+"?nome="+nome);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("salvarPool")!= null) {
			
			String nome = request.getParameter("nome");
			String link = request.getParameter("link");
			String software = request.getParameter("software");
			String commando = request.getParameter("commando");
			
			 Pool pool = new Pool();
			   
			   pool.setNome(nome);
			   pool.setLink(link);
			   pool.setSoftware(software);
			   pool.setCommando(commando);
			   poolDAO dao = new poolDAO();
			   
			   dao.salvarPool(pool); 

			   response.sendRedirect(Common.url_pool);
		}else if(request.getParameter("atualizarPool")!= null) {

			String id = request.getParameter("id");
			
			Pool pool = new Pool();
			poolDAO dao = new poolDAO();
			pool.setId(Integer.parseInt(id));
			pool.setNome(request.getParameter("nome"));
			pool.setLink(request.getParameter("link"));
			pool.setSoftware(request.getParameter("software"));
			pool.setCommando(request.getParameter("commando"));

			dao.updatePool(pool);
			
		    response.sendRedirect(Common.url_pool);

			
		}
		
	}

}
