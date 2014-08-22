<%-- 
    Document   : Person
    Created on : 21-ago-2014, 20:48:06
    Author     : Andres y Angiee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos Persona</h1>
        <form action="Guardar" method="POST">
            <span>Identificación</span>
            <input type="text" name="id"/>
            <span>Nombre</span>
            <input type="text" name="nombre"/>
            <span>Teléfono</span>
            <input type="text" name="telefono"/>
            <input type="submit" value="Enviar" name="enviar"/>
            
        </form>
    </body>
</html>
