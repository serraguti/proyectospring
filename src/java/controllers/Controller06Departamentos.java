package controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Departamento;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryDepartamentos;

public class Controller06Departamentos implements Controller {

    RepositoryDepartamentos repo;

    public Controller06Departamentos() {
        this.repo = new RepositoryDepartamentos();
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1)
            throws Exception {
        ModelAndView mv = new ModelAndView("web06departamentos");
        List<Departamento> departamentos = this.repo.getDepartamentos();
        mv.addObject("DEPARTAMENTOS", departamentos);
        return mv;
    }
}
