package controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Departamento;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import repositories.RepositoryPaginarDepartamentos;

public class Controller20PaginarDepartamentos implements Controller {

    RepositoryPaginarDepartamentos repo;

    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web20paginardepartamentos");
        this.repo = (RepositoryPaginarDepartamentos) this.getBean("repositorypaginardepartamentos", hsr.getServletContext());
        //AQUI VAMOS A RECUPERAR LA POSICION DEL DEPARTAMENTO QUE NOS MANDEN
        //DESDE LA PAGINA
        String dato = hsr.getParameter("posicion");
        //AL NO ESTAR EN MULTIACTION, DEBEMOS PREGUNTAR SI EXISTE PARAMETRO
        //QUEREMOS MOSTRAR UN DEPARTAMENTO AL INICIAR LA PAGINA?? SI
        //CUAL??? EL PRIMERO
        int posicion = 1;
        if (dato != null) {
            //RECUPERAMOS LA POSICION
            posicion = Integer.parseInt(dato);
        }
        //NOSOTROS RECUPERAREMOS UN DEPARTAMENTO A PARTIR DE LA POSICION
        Departamento departamento = this.repo.getDepartamento(posicion);
        //RECUPERAMOS EL VALOR DEL ULTIMO DESPUES DE LA CONSULTA
        //PORQUE DENTRO DE LA CONSULTA ES DONDE GUARDAMOS numeroRegistros
        int ultimo = this.repo.getNumeroRegistros();
        mv.addObject("ULTIMO", ultimo);
        int siguiente = posicion + 1;
        //COMPROBAMOS QUE NO NOS PASAMOS DEL ULTIMO
        if (siguiente > ultimo) {
            siguiente = ultimo;
        }
        mv.addObject("SIGUIENTE", siguiente);
        int anterior = posicion - 1;
        //DEBEMOS COMPROBAR QUE NO NOS HEMOS PASADO DE LA POSICION HACIA ABAJO
        if (anterior < 1) {
            anterior = 1;
        }
        mv.addObject("ANTERIOR", anterior);
        //AÑADIMOS EL DEPARTAMENTO A LA VISTA
        mv.addObject("DEPARTAMENTO", departamento);
        return mv;
    }
}
