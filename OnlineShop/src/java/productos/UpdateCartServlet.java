package productos;

import beans.Carrito;
import beans.Producto;
import control.Tools;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.PersistenceInterface;

/**
 *
 * @author Juan Díez-Yanguas Barber
 */
public class UpdateCartServlet extends HttpServlet {

    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Carrito cart = (Carrito) request.getSession().getAttribute("carrito");
        if (cart!=null){
            double precioTotal = 0;
            PersistenceInterface persistencia = (PersistenceInterface) request.getServletContext().getAttribute("persistence");
            Iterator <String> iteradorCodigos = cart.getArticulos().keySet().iterator();
            boolean redirect = false;
            while (iteradorCodigos.hasNext()){
                String cod = iteradorCodigos.next();
                int cant = cart.getArticulos().get(cod);
                Producto prod = persistencia.getProduct(cod);
                if (prod == null){
                    request.setAttribute("resultados", "Carrito actualizado");
                    Tools.anadirMensaje(request, "El producto: " + cod + " no ha sido encontrado y lo hemos eliminado de la cesta");
                    iteradorCodigos.remove();
                    redirect = true;
                }else if (cant > prod.getStock()){
                    request.setAttribute("resultados", "Carrito actualizado");
                    Tools.anadirMensaje(request, "No tenemos unidades suficientes de: <b>" + prod.getNombre() + "</b>. Hemos eliminado el producto de su cesta");
                    iteradorCodigos.remove();
                    redirect = true;
                }else{
                    precioTotal += prod.getPrecio() * cant;
                }
            }
            cart.setPrecio(precioTotal);
            //Si hay cambios en el carrito se avisa y no se redirige
            if (redirect == true){
                request.getRequestDispatcher("/shop/cart.jsp").forward(request, response);
                return;
            }

            //Se va a terminar la compra o al resumen de la compra según corresponda
            if (request.getParameter("buy")!= null && request.getParameter("buy").equals("preBuy")){
                request.getRequestDispatcher("/shop/buy").forward(request, response);
            }else{
                response.sendRedirect("/shop/buycart.jsp");
            }
        }else{
            request.setAttribute("resultados", "Carrito no encontrado");
            Tools.anadirMensaje(request, "No se ha encontrado un carrito en la sesion, es posible que haya caducado la sesión");
            request.getRequestDispatcher("/shop/products.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if (request.getParameter("buy") != null && request.getParameter("buy").equals("preBuy") == true){
            processRequest(request, response);
        }else{
            response.sendError(404);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
