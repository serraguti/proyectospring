package controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryEmpleados;

public class Controller15MostrarEmpleados implements Controller {

    RepositoryEmpleados repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web15mostrarempleados");
        String id = hsr.getParameter("eliminar");
        if (id != null) {
            //RECUPERAMOS LA LISTA DE SESSION
            ArrayList<String> listaids = (ArrayList<String>) hsr.getSession().getAttribute("LISTAIDS");
            listaids.remove(id);
            if (listaids.isEmpty()) {
                hsr.getSession().setAttribute("LISTAIDS", null);
            } else {
                hsr.getSession().setAttribute("LISTAIDS", listaids);
            }
        }
        //EN LA PAGINA VAMOS A DIBUJAR LOS EMPLEADOS, NO LA SESSION
        if (hsr.getSession().getAttribute("LISTAIDS") != null) {
            //RECUPERAMOS LA LISTA DE SESSION
            ArrayList<String> listaids = (ArrayList<String>) hsr.getSession().getAttribute("LISTAIDS");
            //RECUPERAMOS EL REPO PARA LOS DATOS
            this.repo = (RepositoryEmpleados) this.getBean("repositoryempleados", hsr.getServletContext());
            List<Empleado> empleados = this.repo.getEmpleadosSession(listaids);
            mv.addObject("EMPLEADOSSESSION", empleados);
        }
        return mv;
    }

}
