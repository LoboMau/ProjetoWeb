<%-- 
    Document   : 
    Created on : Aug 22, 2011, 9:51:32 PM
    Author     : LoboMau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de  Usuários</title>
        <link rel="stylesheet" type="text/css" href="Css/estilo.css" media="all" >
        
    </head>
    <body>
        <table border="1">
            <td><a href="usuarioinfo.jsp">Usuario</a></td>
            <td><a href="usuario.jsp">Lista de  Usuários</a></td>            
        </table>
        <br />
        <h3>Lista de Usuários</h3>
        <br />
        <table border="1">
            <th>Usuario ID</th>
            <th>Nome</th>
            <th>Apelido</th>
            <th>Email</th>
            <td>Senha</td>
            <c:forEach items="${requestScope.list}" var="usuario">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/GetUsuario?id=${usuario.id_usuario}">${usuario.id_usuario}</a></td>
                    <td>${usuario.nome}</td>
                    <td>${usuario.apelido}</td>
                    <td>${usuario.email}</td>
                    <td>${usuario.senha}</td>
                  
                </tr>
            </c:forEach>                 
        </table>
    </body>
</html>
