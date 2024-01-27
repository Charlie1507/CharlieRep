<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.silva.app.p3cams.models.*"%>
<%@page import="com.silva.app.p3cams.models.enums.*"%>
<%@page import="com.google.gson.Gson" %>


<%
  Map<String, String> errores=(Map<String,String>) request.getAttribute("errores");
  List<Duenio> duenios =  (List<Duenio>) request.getAttribute("duenios");
  TipoPropiedad[] tipos=  (TipoPropiedad[]) request.getAttribute("tipos");
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

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCWeeateTaYGqsHhNcmoDfT7Us-vLDZVPs&amp;sensor=false&amp;language=en"></script>


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
                <h1 class="mb-4">Formulario Alta Propiedad</h1>
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
                    <form action="<%=request.getContextPath()%>/propiedades/alta" method="post">

                        <div class="mb-3">
                            <label for="direccion" class="form-label text-white">Direccion</label>
                            <div class="input-group">
                                <input type="text" name="direccion" id="direccion" class="form-control" value="${param.direccion}">
                                <button class="btn btn-primary" type="button" id="obtenerDireccionBtn" onclick="obtenerDireccionCompleta();">Obtener Dirección</button>
                            </div>
                            <% if (errores != null && errores.containsKey("direccion")) { %>
                                <span class='text-danger'><%= errores.get("direccion") %></span>
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
                            <label for="tipoProp" class="form-label text-white">Tipo de propiedad</label>
                            <select name="tipoProp" id="tipoProp" class="form-control">
                                <option selected="true" disabled="disabled">---Seleccione---</option>
                                <%
                                    for (TipoPropiedad c : tipos) {
                                %>
                                    <option value="<%= c.name() %>"><%= c.name() %></option>
                                <%
                                    }
                                %>
                            </select>
                            <% if (errores != null && errores.containsKey("tipoProp")) { %>
                                <span class='text-danger'><%= errores.get("tipoProp") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label for="precio" class="form-label text-white">Precio</label>
                            <input type="text" name="precio" id="precio" class="form-control" value="${param.precio}">
                            <% if (errores != null && errores.containsKey("precio")) { %>
                                <span class='text-danger'><%= errores.get("precio") %></span>
                            <% } %>
                        </div>

                        <div class="mb-3">
                            <label for="" class="form-label text-white">Disponibilidad</label>
                            <input type="checkbox" name="disponibilidad" id="disponibilidad" class="form-check-input" value="${param.disponibilidad}" checked>
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
            function obtenerDireccionCompleta() {
                // Obtén la dirección del campo de entrada
                var direccion = $("#direccion").val();

                // Llama a la API de Google Maps para obtener la dirección completa
                var geocoder = new google.maps.Geocoder();
                geocoder.geocode({ 'address': direccion }, function (results, status) {
                    if (status === google.maps.GeocoderStatus.OK) {
                        // Actualiza el campo de entrada con la dirección formateada
                        $("#direccion").val(results[0].formatted_address);

                        // Guarda la dirección completa en un segundo plano (puedes enviarla a tu servidor aquí)
                        var direccionCompleta = results[0].formatted_address;
                        console.log("Dirección completa:", direccionCompleta);

                        // Puedes realizar una petición AJAX para guardar la dirección completa en tu servidor aquí

                        // Añade cualquier lógica adicional según tus necesidades

                    } else {
                        console.error("Error al obtener la dirección completa:", status);
                    }
                });
            }

            $(document).ready(function () {
                // Agrega un evento al botón para llamar a la función obtenerDireccionCompleta
                $("#obtenerDireccionBtn").click(function () {
                    obtenerDireccionCompleta();
                });
            });
        </script>
</body>
</html>