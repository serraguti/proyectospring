package controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.GrandSlam;
import models.Tenista;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller09Tenista implements Controller {

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web09tenista");
        Tenista tenista = (Tenista) this.getBean("tenista", hsr.getServletContext());
        mv.addObject("TENISTA", tenista);
        GrandSlam slam = (GrandSlam) this.getBean("grandslam", hsr.getServletContext());
        mv.addObject("GRANDSLAM", slam);
        return mv;
    }

}
