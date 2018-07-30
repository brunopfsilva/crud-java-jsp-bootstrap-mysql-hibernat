package coin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import apoio.Common;
import coin.Coin;
import coin.coinDAO;


@WebServlet(name = "Coin", urlPatterns = { "/Coin" })
public class CoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		if(request.getParameter("delete")!= null) {
			
			Coin coin = new Coin();
			coin.setId(Integer.parseInt(request.getParameter("delete")));
			
			coinDAO dao = new coinDAO();
			dao.deleteCoin(coin);
			
		    response.sendRedirect(Common.url_coin);

		}else if(request.getParameter("Filtrar") != null) {
			
			
			String nome = request.getParameter("nome");
			coinDAO dao = new coinDAO();
			dao.exibir_by_name(nome);
			
			response.sendRedirect(Common.url_coin+"?nome="+nome);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		if(request.getParameter("salvarCoin")!= null) {
			
			String nome = request.getParameter("nome");
			String link = request.getParameter("link");
			String wallet = request.getParameter("wallet");
			
			 Coin coin = new Coin();
			   
			   coin.setNome(nome);
			   coin.setLink(link);
			   coin.setWallet(wallet);
			   coinDAO dao = new coinDAO();
			   
			   dao.salvarCoin(coin); 

			   response.sendRedirect(Common.url_coin);
			   
		}else if(request.getParameter("atualizarCoin")!= null) {

			String id = request.getParameter("id");
			
			Coin coin = new Coin();
			coinDAO dao = new coinDAO();
			coin.setId(Integer.parseInt(id));
			coin.setNome(request.getParameter("nome"));
			coin.setLink(request.getParameter("link"));
			coin.setWallet(request.getParameter("wallet"));

			dao.updateCoin(coin);
			
		    response.sendRedirect(Common.url_coin);

			
		}
		
	}
		
	}


