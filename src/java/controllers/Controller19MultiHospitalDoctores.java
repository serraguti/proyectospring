package controllers;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Doctor;
import models.Hospital;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import repositories.RepositoryMultiHospitalDoctores;

public class Controller19MultiHospitalDoctores extends MultiActionController {

    RepositoryMultiHospitalDoctores repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    public ModelAndView start(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        System.out.println("start");
        ModelAndView mv = new ModelAndView("web19multihospitaldoctores");
        this.repo = (RepositoryMultiHospitalDoctores) this.getBean("repositorymultihospitaldoctores", request.getServletContext());
        List<Hospital> hospitales = this.repo.getHospitales();
        mv.addObject("HOSPITALES", hospitales);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mostrarDoctores(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        System.out.println("mostrarDoctores");
        ModelAndView mv = new ModelAndView("web19multihospitaldoctores");
        this.repo = (RepositoryMultiHospitalDoctores) this.getBean("repositorymultihospitaldoctores", request.getServletContext());
        List<Hospital> hospitales = this.repo.getHospitales();
        mv.addObject("HOSPITALES", hospitales);
        String dato = request.getParameter("idhospital");
        int id = Integer.parseInt(dato);
        List<Doctor> doctores = this.repo.getDoctoresHospital(id);
        mv.addObject("DOCTORES", doctores);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView incrementarSalarios(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        System.out.println("incrementarSalarios");
        ModelAndView mv = new ModelAndView("web19multihospitaldoctores");
        this.repo = (RepositoryMultiHospitalDoctores) this.getBean("repositorymultihospitaldoctores", request.getServletContext());
        List<Hospital> hospitales = this.repo.getHospitales();
        mv.addObject("HOSPITALES", hospitales);
        String dato = request.getParameter("idhospital");
        int id = Integer.parseInt(dato);
        String datoincremento = request.getParameter("incremento");
        int incremento = Integer.parseInt(datoincremento);
        this.repo.incrementarSalarioDoctores(id, incremento);
        System.out.println("IdHospital: " + id);
        System.out.println("Incremento: " + incremento);
        List<Doctor> doctores = this.repo.getDoctoresHospital(id);
        mv.addObject("DOCTORES", doctores);
        return mv;
    }

    public ModelAndView eliminarDoctor(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        System.out.println("start");
        ModelAndView mv = new ModelAndView("web19multihospitaldoctores");
        this.repo = (RepositoryMultiHospitalDoctores) this.getBean("repositorymultihospitaldoctores", request.getServletContext());
        List<Hospital> hospitales = this.repo.getHospitales();
        mv.addObject("HOSPITALES", hospitales);
        String dato = request.getParameter("iddoctor");
        int iddoctor = Integer.parseInt(dato);
        this.repo.eliminarDoctor(iddoctor);
        String datohospital = request.getParameter("idhospital");
        int idhospital = Integer.parseInt(datohospital);
        List<Doctor> doctores = this.repo.getDoctoresHospital(idhospital);
        mv.addObject("DOCTORES", doctores);
        return mv;
    }
}
