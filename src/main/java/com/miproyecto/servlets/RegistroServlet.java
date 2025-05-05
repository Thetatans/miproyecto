/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.miproyecto.servlets;

import com.miproyecto.modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/registro"})

public class RegistroServlet extends HttpServlet {
    
    //metodo para manejar solicitudes post (registrar usuario)
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        //se obtiene los datos del formulario
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //creamos un objeto usuario ocn los datos del furmulario
        Usuario nuevoUsuario = new Usuario (nombre, apellido, email, password);
        
        //obtenemos la sesion http
        HttpSession session = request.getSession();
        
        //recuperamos la lista de usuarios de la sesion (o creamos una nuevA)
        List<Usuario> listaUsuarios = (List<Usuario>) session.getAttribute("listaUsuarios");
        if (listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
            session.setAttribute("listaUsuarios", listaUsuarios);
        }
        
        //agregamos el nuevo usuario a la lista
        listaUsuarios.add(nuevoUsuario);
        
        //agregamos un mensaje de exito
        request.setAttribute("mensaje", "¡Usuario registrado con exito!");
        
        //redirigimos a la pagina de registro
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
        
    }
    
    //Metodo para manejar solicitudes GET (mostrar formulario)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //simplemente reeenviamos a la pagina de registro
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
    }
    
}
