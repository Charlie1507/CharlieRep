<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>


<%
  Map<String, String> errores=(Map<String,String>) request.getAttribute("errores");
%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inmobiliaria</title>

    <!-- Enlace a Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: url(https://canalhogar.com/wp-content/uploads/2023/10/25-planos-y-Disenos-de-Casas-de-2-Pisos-Modernas-800x600.jpg) fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        header {
            background-color: #F39C12;
            padding: 10px;
            text-align: center;
            color: white;
            font-size: 24px;
        }

        nav {
            background-color: #FFC300;
            text-align: center;
            padding: 10px;
        }

        nav a {
            color: #A52A2A;
            padding: 10px 20px;
            text-decoration: none;
            font-size: 18px;
            margin: 0 10px;
        }

        nav a:hover {
            background-color: #FF7043;
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
            background-color: #FFD700;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
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

        .alert-danger {
            mx-5: px-5;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .btn-success {
            background-color: #32CD32;
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


    <div class="container mt-5">
        <div class="row">
            <div class="col-12">
                <h1 class="mb-4">Formulario Alta Dueño</h1>
            </div>
        </div>

        <% if (errores != null && errores.size() > 0) { %>
            <ul class="alert alert-danger mx-5 px-5">
                <% for (String error : errores.values()) { %>
                    <li><%= error %></li>
                <% } %>
            </ul>
        <% } %>

            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <form action="<%=request.getContextPath()%>/duenios/alta" method="post">

                        <div class="mb-3">
                            <label for="nombre" class="form-label text-white">Nombre</label>
                            <input type="text" name="nombre" id="nombre" class="form-control" value="${param.nombre}">
                            <% if (errores != null && errores.containsKey("nombre")) { %>
                                <span class='text-danger'><%= errores.get("nombre") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label for="apPaterno" class="form-label text-white">Apellido Paterno</label>
                            <input type="text" name="apPaterno" id="apPaterno" class="form-control" value="${param.apPaterno}">
                            <% if (errores != null && errores.containsKey("apPaterno")) { %>
                                <span class='text-danger'><%= errores.get("apPaterno") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label for="apMaterno" class="form-label text-white">Apellido Materno</label>
                            <input type="text" name="apMaterno" id="apMaterno" class="form-control" value="${param.apMaterno}">
                            <% if (errores != null && errores.containsKey("apMaterno")) { %>
                                <span class='text-danger'><%= errores.get("apMaterno") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label for="telefono" class="form-label text-white">Telefono</label>
                            <input type="text" name="telefono" id="telefono" class="form-control" value="${param.telefono}">
                            <% if (errores != null && errores.containsKey("telefono")) { %>
                                <span class='text-danger'><%= errores.get("telefono") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label for="cuenta" class="form-label text-white">Cuenta</label>
                            <input type="text" name="cuenta" id="cuenta" class="form-control" value="${param.cuenta}">
                            <% if (errores != null && errores.containsKey("cuenta")) { %>
                                <span class='text-danger'><%= errores.get("cuenta") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <!-- Scripts de Bootstrap (jQuery y Popper.js) -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>