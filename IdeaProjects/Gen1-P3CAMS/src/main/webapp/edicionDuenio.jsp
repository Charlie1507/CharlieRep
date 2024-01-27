<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.silva.app.p3cams.models.*" %>

<%
  Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
  Duenio duenio =  (Duenio) request.getAttribute("duenio");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inmobiliaria</title>

    <style>
        body {
            background: url(https://canalhogar.com/wp-content/uploads/2023/10/25-planos-y-Disenos-de-Casas-de-2-Pisos-Modernas-800x600.jpg) fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        header {
            background-color: #F39C12; /* Naranja oscuro */
            padding: 10px;
            text-align: center;
            color: white;
            font-size: 24px;
        }

        nav {
            background-color: #FFC300; /* Amarillo dorado */
            text-align: center;
            padding: 10px;
        }

        nav a {
            color: #A52A2A; /* Rojo marrón */
            padding: 10px 20px;
            text-decoration: none;
            font-size: 18px;
            margin: 0 10px;
        }

        nav a:hover {
            background-color: #FF7043; /* Salmón claro al pasar el mouse */
            color: white;
            border-radius: 5px;
        }

        .dropdown {
            display: inline-block;
            align-items: center;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #FFD700; /* Amarillo dorado */
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .container {
            text-align: left;
            padding: 20px;
            margin: 0 auto;
            max-width: 1200px;
        }

        h1 {
            font-size: 40px;
            margin: 10px 0;
            color: #F5F5DC;
        }

        #agregarDuenio {
            font-size: 25px;
            margin: 10px;
            padding: 5px 10px;
            color: #FFF;
            background-color: #32CD32; /* Verde lima */
            text-decoration: none;
            border-radius: 5px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.8);
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #A52A2A; /* Rojo Marrón */
            color: white;
        }

        .btn-success {
            background-color: #FFA07A; /* Salmón claro */
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 5px;
        }

        .btn-primary {
            background-color: #FF4500; /* Naranja rojizo */
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 5px;
        }

        .btn-danger {
            background-color: #FF6347; /* Tomate claro */
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>



    <body>

    <header>
        <img src="https://www.camaltec.es/wp-content/uploads/2016/11/URBAN-LOGO-FINAL-1.png"  height="50" >
    </header>

    <nav>
        <div class="dropdown">
            <a href="#">Contratos</a>
            <div class="dropdown-content">
                <br>
                <a href="<%=request.getContextPath()%>/contratos/listar">Ver contratos</a> <br>
                <br>
                <a href="<%=request.getContextPath()%>/contratos/alta">Dar de alta</a> <br>
                <br>
            </div>
        </div>

        <div class="dropdown">
            <a href="#">Propiedades</a>
            <div class="dropdown-content">
                <br>
                <a href="<%=request.getContextPath()%>/propiedades/listar">Ver propiedades</a> <br>
                <br>
                <a href="<%=request.getContextPath()%>/propiedades/alta">Dar de alta</a> <br>
                <br>
            </div>
        </div>

        <div class="dropdown">
            <a href="#">Inquilinos</a>
            <div class="dropdown-content">
                <br>
                <a href="<%=request.getContextPath()%>/inquilinos/listar">Ver inquilinos</a> <br>
                <br>
                <a href="<%=request.getContextPath()%>/inquilinos/alta">Dar de alta </a> <br>
                <br>
            </div>
        </div>

        <div class="dropdown">
            <a href="#">Dueños</a>
            <div class="dropdown-content">
                <br>
                <a href="<%=request.getContextPath()%>/duenios/listar">Ver dueños</a> <br>
                <br>
                <a href="<%=request.getContextPath()%>/duenios/alta">Dar de alta </a> <br>
                <br>
            </div>
        </div>

        <div class="dropdown">
            <a href="#">Mantenimientos</a>
            <div class="dropdown-content">
                <br>
                <a href="<%=request.getContextPath()%>/mantenimientos/listar">Ver mantenimientos</a> <br>
                <br>
                <a href="<%=request.getContextPath()%>/mantenimientos/alta">Dar de alta </a> <br>
                <br>
            </div>
        </div>

    </nav>


        <div class="col-md-8 offset-md-2">
            <form action="<%=request.getContextPath()%>/duenios/editar" method="post" class="mt-4">
                <input type="hidden" name="id" value="<%=duenio.getId()%>">
                <table class="table">
                    <tr>
                        <td><label for="nombre" class="form-label text-white">Nombre</label></td>
                        <td>
                            <input type="text" name="nombre" id="nombre" class="form-control" value="<%=duenio.getNombre() !=null ? duenio.getNombre(): ""%>">
                            <% if (errores != null && errores.containsKey("nombre")) { %>
                                <span class='text-danger'><%= errores.get("nombre") %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="apPaterno" class="form-label text-white">Apellido Paterno</label></td>
                        <td>
                            <input type="text" name="apPaterno" id="apPaterno" class="form-control" value="<%=duenio.getApPaterno() !=null ? duenio.getApPaterno(): ""%>">
                            <% if (errores != null && errores.containsKey("apPaterno")) { %>
                                <span class='text-danger'><%= errores.get("apPaterno") %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="apMaterno" class="form-label text-white">Apellido Materno</label></td>
                        <td>
                            <input type="text" name="apMaterno" id="apMaterno" class="form-control" value="<%=duenio.getApMaterno() !=null ? duenio.getApMaterno(): ""%>">
                            <% if (errores != null && errores.containsKey("apMaterno")) { %>
                                <span class='text-danger'><%= errores.get("apMaterno") %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="telefono" class="form-label text-white">Teléfono</label></td>
                        <td>
                            <input type="text" name="telefono" id="telefono" class="form-control" value="<%=duenio.getTelefono() !=null ? duenio.getTelefono(): ""%>">
                            <% if (errores != null && errores.containsKey("telefono")) { %>
                                <span class='text-danger'><%= errores.get("telefono") %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="cuenta" class="form-label text-white">Cuenta</label></td>
                        <td>
                            <input type="text" name="cuenta" id="cuenta" class="form-control" value="<%=duenio.getCuenta() !=null ? duenio.getCuenta(): ""%>">
                            <% if (errores != null && errores.containsKey("cuenta")) { %>
                                <span class='text-danger'><%= errores.get("cuenta") %></span>
                            <% } %>
                        </td>
                    </tr>
                </table>

                <div class="mb-3">
                    <button type="submit" class="btn btn-success">Guardar</button>
                </div>

            </form>
        </div>


    </body>
    </html>