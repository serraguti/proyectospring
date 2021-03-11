package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller13ContadorSession implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web13contadorsession");
        String dato = hsr.getParameter("incremento");
        if (dato != null) {
            int contador = 1;
            //EL CONTADOR SERA 1, PERO SOLAMENTE LA PRIMERA VEZ
            //LUEGO TENDRA EL VALOR QUE HEMOS ALMACENADO EN SESSION
            //NECESITAMOS SABER SI EXISTE ALGO EN SESSION O NO....
            //RECUPERAMOS EL OBJETO SESSION DEL REQUEST (hsr)
            if (hsr.getSession().getAttribute("CONTADOR") != null) {
                //TENEMOS YA ALGO PREVIAMENTE ALMACENADO COMO CONTADOR
                contador = (int) hsr.getSession().getAttribute("CONTADOR");
            }
            //INCREMENTAMOS EL CONTADOR, YA SEA DESDE 1 O DESDE OTRO VALOR
            //QUE TENGAMOS ALMACENADO PREVIAMENTE
            contador += 1;
            //DEBEMOS GUARDAR EN SESSION EL NUEVO VALOR DEL CONTADOR
            hsr.getSession().setAttribute("CONTADOR", contador);
            mv.addObject("CONTADOR", contador);
        }
        return mv;
    }
}
