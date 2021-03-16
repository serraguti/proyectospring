package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class Controller17MultiAccionesMates extends MultiActionController {

    public ModelAndView start(HttpServletRequest request,
            HttpServletResponse reponse) {
        ModelAndView mv = new ModelAndView("web17multiaccionesmates");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView tablamultiplicar(HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web17multiaccionesmates");
        String dato = request.getParameter("numero");
        int numero = Integer.parseInt(dato);
        ArrayList<Integer> resultado = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int oper = numero * i;
            resultado.add(oper);
        }
        mv.addObject("NUMEROS", resultado);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView numerospares(HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("web17multiaccionesmates");
        String dato = request.getParameter("numero");
        int numero = Integer.parseInt(dato);
        ArrayList<Integer> resultado = new ArrayList<>();
        for (int i = 1; i <= numero; i++) {
            if (i % 2 == 0) {
                resultado.add(i);
            }
        }
        mv.addObject("NUMEROS", resultado);
        return mv;
    }
}
