package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class Controller16MultiAction extends MultiActionController {

    public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        return mv;
    }

    public ModelAndView alta(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        mv.addObject("MENSAJE", "Has entrado en action ALTA");
        return mv;
    }

    public ModelAndView baja(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        mv.addObject("MENSAJE", "Has entrado en action BAJA");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView operar(HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web16multiaction");
        //LOS VALORES VIENEN A LA FUERZA PORQUE TENEMOS REQUIRED
        String dato1 = request.getParameter("numero1");
        String dato2 = request.getParameter("numero2");
        int num1 = Integer.parseInt(dato1);
        int num2 = Integer.parseInt(dato2);
        String tipo = request.getParameter("tipooperacion");
        if (tipo.equalsIgnoreCase("sumar")) {
            int suma = num1 + num2;
            mv.addObject("MENSAJE", "La suma de " + num1 + " + "
                    + num2 + " es " + suma);
        } else {
            int multiplicar = num1 * num2;
            mv.addObject("MENSAJE", "La multiplicación de " + num1
                    + " * " + num2
                    + " es " + multiplicar);
        }
        return mv;
    }
}
