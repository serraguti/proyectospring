package controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Coche;
import models.Conductor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller07ObjetosContainer implements Controller {

    //EL METODO GETBEAN ES ESTANDAR, LO QUE QUIERE DECIR QUE
    //PUEDE DEVOLVER UN COCHE, UNA PERSONA O UN GATITO,
    //CUALQUIER CLASE
    private Object getBean(String id, ServletContext servlet) {
        //NECESITAMOS EL CONTEXTO DE LA APLICACION PARA EXTRAER
        //LOS OBJETOS DEL CONTAINER
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        //RECUPERAMOS LA CLASE POR EL ID DEL BEAN
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web07objetoscontainer");
        //RECUPERAMOS EL COCHE DE FORMA EXPLICITA
        Coche car = (Coche) this.getBean("car", hsr.getServletContext());
        mv.addObject("CAR", car);
        Conductor driver = (Conductor) this.getBean("driver", hsr.getServletContext());
        mv.addObject("DRIVER", driver);
        return mv;
    }
}
