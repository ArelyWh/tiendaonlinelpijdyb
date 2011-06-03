<%@page import="persistencia.PersistenceInterface"%>
<%@page import="beans.Usuario"%>
<div id="contentLeft">
  <p>
        <span class="header">Panel de usuario</span> <br />
  </p>
  <% Usuario actualUser = ((PersistenceInterface)application.getAttribute("persistence")).getUser((String)session.getAttribute("usuario")); %>
  <p>
      <span class="subHeader">Opciones</span>
        <a href="/admin/preferences.jsp" title="Preferencias" class="menuItem">Preferencias</a>
        <% if (actualUser.getPermisos() != 'a'){ %>
        <a href="/admin/salesrecord.jsp" title="Historial de compras" class="menuItem">Hist�rico de compras</a>
        <% } %>
        <a href="/logout" title="Cerrar sesi�n" class="menuItem">Cerrar sesi�n</a>
  </p>
  <% if ( actualUser.getPermisos() == 'a' ){ %>
  <p>
      <span class="subHeader">Administraci�n</span>
      <a href="/admin/administration/user_administration.jsp" title="Administraci�n de usuarios" class="menuItem">Administraci�n de usuarios</a>
      <a href="/admin/administration/products_administration.jsp" title="Administraci�n de productos" class="menuItem">Administraci�n de productos</a>
      <a href="/admin/salesrecord.jsp" title="Registro de ventas" class="menuItem">Hist�rico de ventas</a>
      <a href="/admin/administration/stats.jsp" title="Estad�sticas de ventas" class="menuItem">Estad�sticas de ventas</a>
  </p>
  <% } %>

      <!-- Esquina redondeada en la parte de abajo del men� -->
      <div class="bottomCorner">
        <img src="/images/template/corner_sub_br.gif" alt="bottom corner" class="vBottom"/>
      </div>

    </div>
  