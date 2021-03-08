package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.TablaMultiplicar;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller05TablaMultiplicar implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web05tablamultiplicar");
        String dato = hsr.getParameter("numero");
        if (dato != null) {
            int numero = Integer.parseInt(dato);
            ArrayList<TablaMultiplicar> lista = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                int ope = numero * i;
                TablaMultiplicar t = new TablaMultiplicar(numero + " * " + i, ope);
                lista.add(t);
            }
            mv.addObject("TABLA", lista);
            /*
            String html = "";
            for (int i = 1; i <= 10; i++) {
                int ope = numero * i;
                html += "<tr>";
                html += "<td>" + numero + " * " + i + "</td>";
                html += "<td>" + ope + "</td>";
                html += "</tr>";
            }
            mv.addObject("TABLA", html);
             */
        }
        return mv;
    }
}
