package net.daw.control;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.daw.bean.IOlUl;
import net.daw.bean.Table;

/**
 *
 * @author rafael aznar
 */
public class Control extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException, Exception {

        try ( PrintWriter out = response.getWriter()) {
            String ob = request.getParameter("ob");
            String op = request.getParameter("op");
            if (("".equalsIgnoreCase(ob) && "".equalsIgnoreCase(op)) || (ob == null && op == null)) {
                response.setContentType("application/json;charset=UTF-8");
                Gson gson = JsonGson.getGson();
                String data = gson.toJson("Object or Operation Error");
                out.print(data);
                out.flush();
            } else {
                if (request.getParameter("ob").equals("user")) {
                    if (request.getParameter("op").equals("login")) {
                        response.setContentType("application/json;charset=UTF-8");
                        if (request.getParameter("username").equals("daw") && request.getParameter("password").equalsIgnoreCase("ausias")) {
                            HttpSession oSession = request.getSession();
                            oSession.setAttribute("usuario", request.getParameter("username"));
                            Gson gson = JsonGson.getGson();
                            String data = gson.toJson("Welcome");
                            out.print(data);
                            out.flush();
                        } else {
                            Gson gson = JsonGson.getGson();
                            String data = gson.toJson("Wrong password");
                            out.print(data);
                            out.flush();
                        }
                    }
                }
                if (request.getParameter("ob").equals("user")) {
                    if (request.getParameter("op").equals("check")) {
                        response.setContentType("application/json;charset=UTF-8");
                        Gson gson = JsonGson.getGson();
                        String data = gson.toJson(request.getSession().getAttribute("usuario"));
                        out.print(data);
                        out.flush();
                    }
                }
                if (request.getParameter("ob").equals("user")) {
                    if (request.getParameter("op").equals("secret")) {
                        response.setContentType("application/json;charset=UTF-8");
                        Gson gson = JsonGson.getGson();
                        String data = "";
                        if (request.getSession().getAttribute("usuario").equals("daw")) {
                            data = "KPD" + RandomGenerator.randInt(1000, 10000) + "ZX" +  RandomGenerator.randInt(1000, 10000);
                        } else {
                            data = "ERROR";
                        }
                        out.print(gson.toJson(data));
                        out.flush();
                    }
                }
                if (request.getParameter("ob").equals("user")) {
                    if (request.getParameter("op").equals("logout")) {
                        response.setContentType("application/json;charset=UTF-8");
                        HttpSession oSession = request.getSession();
                        oSession.invalidate();
                        Gson gson = JsonGson.getGson();
                        String data = gson.toJson("No active session");
                        out.print(data);
                        out.flush();
                    }
                }
                if (request.getParameter("ob").equals("table")) {
                    if (request.getParameter("op").equals("get")) {
                        response.setContentType("application/json;charset=UTF-8");
                        int ancho = RandomGenerator.randInt(3, 13);
                        int alto = RandomGenerator.randInt(3, 20);
                        Table t = JsonMaker.getTable(ancho, alto);
                        Gson gson = JsonGson.getGson();
                        String data = gson.toJson(t);
                        out.print(data);
                        out.flush();
                    }
                }
                if (request.getParameter("ob").equals("list")) {
                    if (request.getParameter("op").equals("get")) {
                        int maxniveles = Integer.parseInt(request.getParameter("maxniveles"));
                        response.setContentType("application/json;charset=UTF-8");
                        IOlUl t = null;
                        int alto = RandomGenerator.randInt(3, 10);
                        int profundo = RandomGenerator.randInt(2, maxniveles);
                        if (RandomGenerator.randInt(0, 1) == 0) {
                            t = JsonMaker.getOl(alto, profundo);
                        } else {
                            t = JsonMaker.getUl(alto, profundo);
                        }
                        Gson gson = JsonGson.getGson();
                        String data = gson.toJson(t);
                        out.print(data);
                        out.flush();
                    }
                }
                if (request.getParameter("ob").equals("form")) {
                    if (request.getParameter("op").equals("get")) {
                        int num = Integer.parseInt(request.getParameter("num"));
                        response.setContentType("application/json;charset=UTF-8");
                        JsonFormMaker oJsonmaker = new JsonFormMaker();
                        out.print(oJsonmaker.getForm(num));
                        out.flush();
                    }
                }

                if ((request.getParameter("ob") == null) || (request.getParameter("op") == null)) {
                    getServletContext().getRequestDispatcher("/index.html").forward(request, response);
                }
            }
        } catch (Exception ex) {
            response.setContentType("application/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(ex.getMessage());
            out.println("--------");
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
