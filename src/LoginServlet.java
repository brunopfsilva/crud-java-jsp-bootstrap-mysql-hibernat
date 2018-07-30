

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import apoio.Common;



@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		
		String Email = request.getParameter("Email");
		String Senha = request.getParameter("Senha");
	
		
		// cria um novo cookie no sistema doPost
		Cookie ck = new Cookie("login_name", Email);
		ck.setMaxAge(60 * 60 * 24 * 30);// faz o cookie expirar apos um mes
		response.addCookie(ck);

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String SQL = "SELECT * FROM usuario WHERE email = ? and senha = ?";

			try {
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/grupominer3x", "root", "123");
				PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(SQL);
				
				pstm.setString(1,Email);
				pstm.setString(2,Senha);
				
				ResultSet rs = pstm.executeQuery();
				
				if(rs.next()) {
					
					
					
					HttpSession sessao = request.getSession();
					sessao.setAttribute("usuario", rs.getString("nome"));
					pstm.close();
					conn.close();
					response.sendRedirect(Common.URL_HOME);
					
				} else {
					
					pstm.close();
					conn.close();

					response.sendRedirect(Common.URL_LOGIN+"?msg=error");
					
				}
		
				
			}
			catch (SQLException e) {
				out.println("error: "+e.getMessage());
			}
			
			
		} catch (ClassNotFoundException e) {
			out.println("error: "+e.getMessage());
		}
		
	
	
	}

}
