<%-- 
    Document   : formulario
    Created on : 20-ago-2014, 19:08:33
    Author     : Angiee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos personales</h1>
        
        <form action="Servlet1" method="POST">
            <span>Nombre</span>
            <input type="text" name="Nombre"/>
            <span>Teléfono</span>
            <input type="text" name="Edad"/>
            <input type="submit" name="Enviar" value="Enviar"/>
        </form>
    </body>
</html>
