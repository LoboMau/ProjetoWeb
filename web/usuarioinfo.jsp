<%-- 
    Document   : index
   
    Author     : LoboMau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadstro de Usuários</title>
          <link rel="stylesheet" type="text/css" href="Css/estilo.css" media="all" >
    </head>
    <body>
    <center>
        <table border="1">
            <td><a href="usuarioinfo.jsp">Informação sobre Usuário</a></td>
            <td><a href="${pageContext.request.contextPath}/AllUsuario">Lista de Usuários</a></td>            
        </table>
        <br />

        <form action="${pageContext.request.contextPath}/UsuarioServlet" method="POST">
            <table>
                <tr>
                    <td>Usuario ID:</td>
                    <td><input type="text" name="id" value="${usuario.id_usuario}" /></td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome" value="${usuario.nome}" required/></td>
                </tr>
                <tr>
                    <td>Apelido:</td>
                    <td><input type="text" name="apelido" value="${usuario.apelido}" required/></td>
                </tr>
                 <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" value="${usuario.email}" required/></td>
                </tr>
                 <tr>
                    <td>Senha:</td>
                    <td><input type="password" name="senha" value="${usuario.senha}"required /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="Submit" name="operation" value="inserir" />
                    <input type="Submit" name="operation" value="Editar" />
                    <input type="Submit" name="operation" value="Deletar" />
                    <input type="Submit" name="operation" value="Buscar" /></td>
                </tr>                
            </table>
        </form>
    </center>
    </body>
</html>
