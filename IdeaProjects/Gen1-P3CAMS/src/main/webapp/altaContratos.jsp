<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.silva.app.p3cams.models.*"%>
<%@page import="com.silva.app.p3cams.models.enums.*"%>
<%@page import="com.google.gson.Gson" %>


<%
  Map<String, String> errores=(Map<String,String>) request.getAttribute("errores");
  List<Duenio> duenios =  (List<Duenio>) request.getAttribute("duenios");
  List<Inquilino> inquilinos =  (List<Inquilino>) request.getAttribute("inquilinos");
  List<Propiedad> propiedades =  (List<Propiedad>) request.getAttribute("propiedades");
%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inmobiliaria</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>




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
                <h1 class="mb-4">Formulario Alta Contrato</h1>
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
                    <form action="<%=request.getContextPath()%>/contratos/alta" method="post">

                        <div class="mb-3">
                            <label for="propiedadId" class="form-label text-white">Propiedad</label>
                            <select name="propiedadId" id="propiedadId" class="form-control">
                                <option selected="true" disabled="disabled">---Seleccione---</option>
                                <%
                                    for (Propiedad c : propiedades) {
                                %>
                                    <option value="<%= c.getId() %>"><%= c.getDireccion() %></option>
                                <%
                                    }
                                %>
                            </select>
                            <% if (errores != null && errores.containsKey("propiedadId")) { %>
                                <span class='text-danger'><%= errores.get("propiedadId") %></span>
                            <% } %>
                        </div>


                        <div class="mb-3">
                            <label for="duenioId" class="form-label text-white">Dueño</label>
                            <select name="duenioId" id="duenioId" class="form-control">
                                <option selected="true" disabled="disabled">---Seleccione---</option>
                                <%
                                    for (Duenio c : duenios) {
                                %>
                                    <option value="<%= c.getId() %>"><%= c.getNombre() %> <%= c.getApPaterno() %> <%= c.getApMaterno() %></option>
                                <%
                                    }
                                %>
                            </select>
                            <% if (errores != null && errores.containsKey("duenioId")) { %>
                                <span class='text-danger'><%= errores.get("duenioId") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label for="inquilinoId" class="form-label text-white">Inquilino</label>
                            <select name="inquilinoId" id="inquilinoId" class="form-control">
                                <option selected="true" disabled="disabled">---Seleccione---</option>
                                <%
                                    for (Inquilino c : inquilinos) {
                                %>
                                    <option value="<%= c.getId() %>"><%= c.getNombre() %> <%= c.getApPaterno() %> <%= c.getApMaterno() %></option>
                                <%
                                    }
                                %>
                            </select>
                            <% if (errores != null && errores.containsKey("inquilinoId")) { %>
                                <span class='text-danger'><%= errores.get("inquilinoId") %></span>
                            <% } %>
                        </div>


                        <div class="mb-3">
                            <label for="duracion" class="form-label text-white">Duracion</label>
                            <input type="text" name="duracion" id="duracion" class="form-control" value="${param.duracion}">
                            <% if (errores != null && errores.containsKey("duracion")) { %>
                                <span class='text-danger'><%= errores.get("duracion") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label for="tipoContrato" class="form-label text-white">Inquilino</label>
                            <select name="tipoContrato" id="tipoContrato" class="form-control">
                                <option selected="true" disabled="disabled">---Seleccione---</option>
                                <option value="Renta">Renta</option>
                                <option value="Venta">Venta</option>
                            </select>
                            <% if (errores != null && errores.containsKey("tipoContrato")) { %>
                                <span class='text-danger'><%= errores.get("tipoContrato") %></span>
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


        <script>


        </script>
</body>
</html>