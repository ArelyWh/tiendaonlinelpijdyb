<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>No encontrado</title>
<link rel="stylesheet" type="text/css" href="/css/screen_yellow.css" media="screen, tv, projection" />
</head>

<body>
<!-- Contenedor principal-->
<div id="siteBox">

	<!--Cabecera-->
    <%@include file="/WEB-INF/include/header.jsp" %>


  <!-- Contenido de la pagina -->
  <div id="content">

  <!-- Menu Izquiero -->
  <%@include file="/WEB-INF/include/menu.jsp" %>

    <!-- Contenido de la columna derecha -->
    <div id="contentRight">
        <p>
            <span class="header">Error 404. No encontrado</span>
            <img src="/images/icons/alert.png" alt="alerta" align="left" />
            <br />
            <br />
            No se ha encontrado el recurso solicitado. Por favor, revise su petici&oacute;n.
            <br />
            <br />
            <a href="/index.jsp">Volver a la p&aacute;gina de inicio</a>
            <br /><br /><br /><br /><br /><br /><br />
        </p>
      <!-- Crea las esquinas redondeadas abajo -->
      <img src="/images/template/corner_sub_bl.gif" alt="bottom corner" class="vBottom"/>

    </div>
</div>

<!-- Pie de pagina -->
<%@include file="/WEB-INF/include/footer.jsp" %>

</div>

</body>
</html>

<%! String menuInicio = ""; %>
<%! String menuProductos = ""; %>
<%! String menuLogin = ""; %>
<%! String menuPreferencias = ""; %>
<%! String menuAbout = ""; %>