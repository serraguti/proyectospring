package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Departamento;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Controller08ContainerDepartamentos implements Controller {

    //COMO VAMOS A UTILIZAR DESDE AQUI EL ORIGEN DE DATOS DIRECTAMENTE
    //NECESITAMOS EL METODO getBean()
    private Object getBean(String id, ServletContext context) {
        ApplicationContext container
                = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        Object bean = container.getBean(id);
        return bean;
    }

    private Departamento buscarDepartamento(int id, ServletContext context) throws SQLException {
        //NECESITAMOS LA CONEXION
        //LA CONEXION NOS LA OFRECE EL OBJETO DATASOURCE DEL CONTAINER
        //RECUPERAMOS EL DATASOURCE DEL CONTAINER
        DriverManagerDataSource datasource
                = (DriverManagerDataSource) this.getBean("dataSourceOracle", context);
        Connection cn = datasource.getConnection();
        String sql = "select * from dept where dept_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            int iddept = rs.getInt("DEPT_NO");
            String nombre = rs.getString("DNOMBRE");
            String localidad = rs.getString("LOC");
            Departamento dept = new Departamento(iddept, nombre, localidad);
            rs.close();
            cn.close();
            return dept;
        }
        rs.close();
        cn.close();
        return null;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView("web08containerdepartamentos");
        String dato = hsr.getParameter("id");
        if (dato != null) {
            int id = Integer.parseInt(dato);
            Departamento dept = this.buscarDepartamento(id, hsr.getServletContext());
            mv.addObject("DEPARTAMENTO", dept);
        }
        return mv;
    }
}
