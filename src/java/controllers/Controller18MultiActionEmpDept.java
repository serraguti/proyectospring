package controllers;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Departamento;
import models.Empleado;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import repositories.RepositoryMultiAction;

public class Controller18MultiActionEmpDept extends MultiActionController {

    RepositoryMultiAction repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    public ModelAndView start(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("web18multiactionempdept");
        this.repo = (RepositoryMultiAction) this.getBean("repositorymultiaction",
                request.getServletContext());
        List<Departamento> departamentos = this.repo.getDepartamentos();
        mv.addObject("DEPARTAMENTOS", departamentos);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView recuperarEmpleados(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("web18multiactionempdept");
        String dato = request.getParameter("iddepartamento");
        int id = Integer.parseInt(dato);
        this.repo = (RepositoryMultiAction) this.getBean("repositorymultiaction", request.getServletContext());
        List<Departamento> departamentos = this.repo.getDepartamentos();
        mv.addObject("DEPARTAMENTOS", departamentos);
        List<Empleado> empleados = this.repo.getEmpleadosDepartamento(id);
        if (empleados != null) {
            mv.addObject("EMPLEADOS", empleados);
        }
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView eliminarDepartamento(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        ModelAndView mv = new ModelAndView("web18multiactionempdept");
        String dato = request.getParameter("iddepartamento");
        int id = Integer.parseInt(dato);
        this.repo = (RepositoryMultiAction) this.getBean("repositorymultiaction", request.getServletContext());
        repo.eliminarDepartamento(id);
        List<Departamento> departamentos = this.repo.getDepartamentos();
        mv.addObject("DEPARTAMENTOS", departamentos);
        return mv;
    }
}
