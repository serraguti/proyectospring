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
import repositories.RepositoryEmpleados;

public class Controller14AlmacenarSalario implements Controller {

    RepositoryEmpleados repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web14almacenarsalario");
        String dato = hsr.getParameter("salario");
        if (dato != null) {
            int salario = Integer.parseInt(dato);
            int sumasalarial = 0;
            //PREGUNTAMOS SI EXISTE ALGO EN SESSION
            if (hsr.getSession().getAttribute("SUMASALARIAL") != null) {
                //RECUPERAMOS LA SUMA SALARIAL
                sumasalarial = (int) hsr.getSession().getAttribute("SUMASALARIAL");
            }
            sumasalarial += salario;
            //ALMACENAMOS LOS NUEVOS DATOS EN SESSION
            hsr.getSession().setAttribute("SUMASALARIAL", sumasalarial);
            mv.addObject("SALARIO", salario);
        }

        this.repo = (RepositoryEmpleados) this.getBean("repositoryempleados",
                hsr.getServletContext());
        List<Empleado> empleados = this.repo.getEmpleados();
        mv.addObject("EMPLEADOS", empleados);
        return mv;
    }

}
