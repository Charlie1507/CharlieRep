<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.silva.app.p3cams.models.*" %>

<%
  List<Duenio> duenios =  (List<Duenio>) request.getAttribute("duenios");
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
        <!-- Agregar más categorías según sea necesario -->
    </nav>



    <div class="container">
        <h1>Lista de dueños</h1>
        <a href="<%=request.getContextPath()%>/duenios/alta" class="btn btn-success">Alta Dueño</a><br>
        <br>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <% for(Duenio c: duenios) { %>
                    <tr>
                        <td><%=c.getId()%></td>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getApPaterno()%></td>
                        <td><%=c.getApMaterno()%></td>
                        <td><a href="<%=request.getContextPath()%>/duenios/detalle?id=<%=c.getId()%>" class="btn-success">Detalle</a></td>
                        <td><a href="<%=request.getContextPath()%>/duenios/editar?id=<%=c.getId()%>" class="btn-primary">Editar</a></td>
                        <td><a href="<%=request.getContextPath()%>/duenios/eliminar?id=<%=c.getId()%>" class="btn-danger">Eliminar</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>



    <script>

    </script>

</body>
</html>