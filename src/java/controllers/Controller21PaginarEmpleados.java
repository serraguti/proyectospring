package controllers;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryPaginarEmpleados;

public class Controller21PaginarEmpleados implements Controller {

    RepositoryPaginarEmpleados repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web21paginarempleados");
        this.repo = (RepositoryPaginarEmpleados) this.getBean("repositorypaginarempleados", hsr.getServletContext());
        int posicion = 1;
        String dato = hsr.getParameter("posicion");
        if (dato != null) {
            posicion = Integer.parseInt(dato);
        }
        int numeroregistros = this.repo.getNumeroRegistros();
        List<Empleado> empleados = this.repo.getEmpleados(posicion);
        mv.addObject("NUMEROREGISTROS", numeroregistros);
        mv.addObject("EMPLEADOS", empleados);
        return mv;
    }
}
