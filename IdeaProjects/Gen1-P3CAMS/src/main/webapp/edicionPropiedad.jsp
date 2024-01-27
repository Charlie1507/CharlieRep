<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.silva.app.p3cams.models.*" %>

<%
  Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
  Propiedad propiedad =  (Propiedad) request.getAttribute("propiedad");
  Boolean estado = propiedad.getDisponibilidad();
   String disponible = estado == true ? "checked" : "";
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
            <form action="<%=request.getContextPath()%>/propiedades/editar" method="post" class="mt-4">
                <input type="hidden" name="id" value="<%=propiedad.getId()%>">
                <table class="table">

                    <tr>
                        <td><label for="direccion" class="form-label text-white">Direccion</label></td>
                        <td>
                            <input type="text" name="direccion" id="direccion" class="form-control" value="<%=propiedad.getDireccion() !=null ? propiedad.getDireccion(): ""%>" readonly>
                            <% if (errores != null && errores.containsKey("direccion")) { %>
                                <span class='text-danger'><%= errores.get("direccion") %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="duenioId" class="form-label text-white">Dueño</label></td>
                        <td>
                            <input type="text" name="duenioId" id="duenioId" class="form-control" value="<%=propiedad.getDuenioId() !=null ? propiedad.getDuenioId(): ""%>">
                            <% if (errores != null && errores.containsKey("duenioId")) { %>
                                <span class='text-danger'><%= errores.get("duenioId") %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="tipoPropiedad" class="form-label text-white">Tipo de propiedad</label></td>
                        <td>
                            <input type="text" name="tipoPropiedad" id="tipoPropiedad" class="form-control" value="<%=propiedad.getTipoPropiedad() !=null ? propiedad.getTipoPropiedad(): ""%>" readonly>
                            <% if (errores != null && errores.containsKey("tipoPropiedad")) { %>
                                <span class='text-danger'><%= errores.get("tipoPropiedad") %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="precio" class="form-label text-white">Precio</label></td>
                        <td>
                            <input type="text" name="precio" id="precio" class="form-control" value="<%=propiedad.getPrecio() !=null ? propiedad.getPrecio(): ""%>">
                            <% if (errores != null && errores.containsKey("precio")) { %>
                                <span class='text-danger'><%= errores.get("precio") %></span>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="" class="form-label text-white">Disponibilidad</label></td>
                        <td>

                            <input type="checkbox" name="disponibilidad" id="disponibilidad" class="form-check-input" value="1" <%=disponible%> >
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