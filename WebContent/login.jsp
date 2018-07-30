<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1" errorPage="erro.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<style type="text/css">

    <%@include file="bootstrap/css/bootstrap.css" %>
    <%@include file="bootstrap/css/bootstrap-theme.css" %>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/bootstrap.min.js" ></script>


<title>Tela Login de Usuários</title>
<%  %>
</head>



<body>

<div class="container" >

<div><br><br><br><br><br>
                        <hr>
                        <div class="panel panel-primary">
                        
                        <% if (request.getParameter("msg") != null) {
            				if (request.getParameter("msg").equals("error")) {
            					out.println("<span style='color: red'>Login e senha incorreto!</span>");
            				}else if (request.getParameter("msg").equals("logoff")){
            				
            					session.invalidate();
            					out.println("<span style='color: red'>Deslogado com sucesso!</span>");
                        		}
                        } %>
                        
                            <div class="panel-heading">
                               <h1>Acesso grupo miner 3x</h1>
                            </div>
                            <div 	class="panel-body">
                                
                       <% 				Cookie[] ck = request.getCookies();
												String login_name = "";
				
												if (ck != null) {
						
													for (Cookie cookie : ck) {
														if (cookie.getName().equals("Email")) {
															login_name = cookie.getValue();
														}
						
													}
						
												} 
						%>
                                 
								<form method="post" action="Login" >
								

								
								<input type="email" class="form-control input-lg" id="inputlg" value='<%=login_name%>'  class="form-control" placeholder="Email" name="Email" required="" autofocus="">
								<input type="password" class="form-control input-lg" id="inputlg" class="form-control" placeholder="Senha" name="Senha" required="" autofocus=""><br>
								<button class="btn btn-lg btn-secondary btn-block" type="submit">Logar</button>
								
								</form>

								
								    
                                
                                
                                
                            </div>
                            <div class="panel-footer">
                                Bem vindo
                            </div>
                        </div>
                    </div>
                    </div>

</body>

</html>