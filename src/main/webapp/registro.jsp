<%-- 
    Document   : registro
    Created on : 5/05/2025, 8:26:05 a. m.
    Author     : SENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class = "container">
        <h1>Registro de Usuario</h1>
      
        <% if (request.getAttribute("mensaje") != null) { %>
            <div class="message">
                <%= request.getAttribute("mensaje") %>
            </div>
        <% } %>
        
        <form action="registro" method="POST">
            <!-- Campos del formulario -->
        </form>
    </div>
</body>
</html>
