<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"  %>
<%@page import="pool.poolDAO"%>    
<%@ page import="pool.Pool" %>
<%@ page import="apoio.DAO" %> 
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


<script type="text/javascript">

	function apagar(id) {
		if(window.confirm("Deseja realmente apagar?"))
			window.location = '../Pool?delete='+id;
	}

</script> 	
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
                    <li role="presentation" class="active"><a href="../coin/coins.jsp">Coins</a></li>
                    <li role="presentation"><a href="pools.jsp">Pools</a></li>
                    <li role="presentation"><a href="#">Sistemas</a></li>
                    <li style="text-align: float" ><a href='/grupominer3x/login.jsp?msg=logoff'>Sair</a></li>
                    
                </ul>
                
        </div>
        
        <form action="../Pool" method="get">

 <div style="width: 50%'" class="form-group"><input type="text" vale='<% if(request.getParameter("nome") != null)out.println(request.getParameter("nome")); %>' name="nome" placeholder="Filtrar por nome:" class="form-control" /><input type="hidden" name="Filtrar" placeholder="Filtrar por nome:" required="" class="form-control" /><button type="submit" value="Filtrar" class="btn btn-primary">Pesquisar</button></div>
</form>
        
</div>
</nav>
</div><br><center><h3>Seja bem vindo - <% HttpSession sessao = request.getSession(); %><% if (sessao.getAttribute("usuario") == null) {
	
	
	
} else { out.println(sessao.getAttribute("usuario")); } %> </h3></center>
<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button style="align-content: left;" type="button" target="inewcoin" class="btn btn-primary">Nova moeda</button> -->
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button style="align-content: left;" type="button" class="btn btn-primary"><a href="newpool.jsp" style="color: white;" >Nova pool</a></button>
<% if (request.getParameter("msg") != null) {

	 } 


%>
	
	
	
<hr>


<table class="table table-bordered">
  <thead>
    <tr>
    
      <th scope="col">id</th>
      <th scope="col">nome</th>
      <th scope="col">link</th>
      <th scope="col">software</th>
      <th scope="col">commando</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
 <% 
    

    poolDAO dao = new poolDAO();  
    List<Pool>lista = null;
    
    if(request.getParameter("nome")!=null){
    	
    	lista = dao.exibir_by_name(request.getParameter("nome"));
    	
    }else {
    	lista = dao.exibir();
    }
    
    for(Pool pool: lista){
  		  
    	
    %>
  </thead>
  <tbody>
    <tr>
      <td><%=pool.getId() %></td>
      <td><%=pool.getNome() %></td>
	  <td><%=pool.getLink() %></td>
	  <td><%=pool.getSoftware()%></td>
	  <td><%=pool.getCommando()%></td>
      <td><button type="button" class="btn btn-success"><a style="color: white;" href="../pool/editpool.jsp?id=<% out.println(pool.getId()); %>">Editar</a></button></td>
      <td><button type="button" class="btn btn-danger"><a style="color: white;" href="#" onclick="apagar('<%=pool.getId() %>')" >Excluir</a></button>
	</td>
    </tr>
    
    <%
						
  	 }
		%>
    
    
  </tbody>
</table>

<!-- <iframe height="90%" width="100%" src="listcoin.jsp" name="inewcoin" ></iframe>-->

</div>
</body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>