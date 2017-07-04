<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>PlayList</title>
</head>
<body>
	<%@ include file="/paginas/nav.jsp"%>
	<%
		//if (session.getAttribute("log") == null) {
			%>
		<!--<jsp:include page="/paginas/login.jsp" />-->
			<%
		//} else if(request.getSession().getAttribute("log") == "0"){
			%>
			<!--<jsp:include page="/paginas/login.jsp">
		        <jsp:param name="log" value="0"/>
		    </jsp:include>-->
			<%
		//} //else {
			if (request.getParameter("pag") != null) {
				if (request.getParameter("pag").equals("playlist")) {
				    %>  <jsp:include page="/paginas/playlist.jsp" /> <%
				} else if (request.getParameter("pag").equals("users")) {
				    %>  <jsp:include page="/paginas/user.jsp" /> <%
				} else if (request.getParameter("pag").equals("musicas")) {
					%>  <jsp:include page="/paginas/musica.jsp" /><% 
				} else if (request.getParameter("pag").equals("album")){
					%>  <jsp:include page="/paginas/album.jsp" /><%
				} else if (request.getParameter("pag").equals("genero")){
					%>  <jsp:include page="/paginas/genero.jsp" /><%
				} else if (request.getParameter("pag").equals("artista")){
					%>  <jsp:include page="/paginas/artista.jsp" /><% 
				} else if (request.getParameter("pag").equals("autor")){
					%>  <jsp:include page="/paginas/autor.jsp" /><%
				} else if (request.getParameter("pag").equals("funcao")){
					%>  <jsp:include page="/paginas/funcao.jsp"/><%
				}
			} else {
				%>
				<jsp:include page="/index.jsp" />
				<%
			}
		//}
	%>
</body>
</html>