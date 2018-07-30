<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"  %>
<%@ page import="apoio.Common" %>
<%@ page import="coin.Coin" %>
<%@ page import="coin.coinDAO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<style type="text/css">

    <%@include file="../bootstrap/css/bootstrap.css" %>
    <%@include file="../bootstrap/css/bootstrap-theme.css" %>
</style>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="bootstrap/js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/bootstrap.min.js" ></script>




<title>Dashboard</title>



</head>
<body>

<div class="container">
	
<div class="page-header">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header"><a href='/grupominer3x/dashboard.jsp' class="navbar-brand">Inicio</a><button data-toggle="collapse" data-target="#navcol-1" class="navbar-toggle collapsed"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button></div>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li role="presentation" class="active"><a href="coins.jsp">Coins</a></li>
                    <li role="presentation"><a href="../pool/pools.jsp">Pools</a></li>
                    <li role="presentation"><a href="#">Sistemas</a></li>
                    <li style="text-align: float" ><a href='/grupominer3x/login.jsp?msg=logoff'>Sair</a></li>
                    
                </ul>
                
        </div>
</div>
</nav>
</div><br><center><h3>Seja bem vindo - <% HttpSession sessao = request.getSession(); %><% if (sessao.getAttribute("usuario") == null) {
	response.sendRedirect(Common.URL_LOGIN);
} else { out.println(sessao.getAttribute("usuario")); } %> </h3></center>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button style="align-content: left;" type="button" class="btn btn-primary"><a href="coins.jsp" style="color: white;" >Voltar</a></button>
<% if (request.getParameter("msg") != null) {
	if (request.getParameter("msg").equals("error")) {
		out.println("<span style='color: red'>Login e senha incorreto!</span>");
	}
} %>
	
<hr>



<div class="form-container">

    <form method="post" action="../Coin">
        <h2 class="text-center"><strong>Adicionar</strong> nova coin.</h2>
        <div class="form-group"><input type="hidden" name="salvarCoin" placeholder="Nome" value="salvarCoin" class="form-control" /></div>
        <div class="form-group"><input type="text" name="nome" placeholder="Nome" required="" class="form-control" /></div>
        <div class="form-group"><input type="text" name="link" placeholder="Link" required="" class="form-control" /></div>
        <div class="form-group"><input type="text" name="wallet" placeholder="Wallet" required="" class="form-control" /></div>
        <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Salvar</button></div>
    </form>
    
</div>



</div>
</body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>