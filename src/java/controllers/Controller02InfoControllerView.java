package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Persona;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller02InfoControllerView implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        String mensaje = "Mi primer parametro con Spring!!!";
        ModelAndView mv = new ModelAndView("web02infocontrollerview");
        //PARA AÑADIR INFORMACION SE UTILIZA EL METODO
        //.addObject("KEY", "VALUE")
        mv.addObject("mensaje", mensaje);
        String html = "<h1 style='color:red'>Codigo HTML</h1>";
        mv.addObject("html", html);
        Persona persona = new Persona("Lucia", "lucia@gmail.com", 17);
        mv.addObject("PERSONA", persona);
        return mv;
    }
}
