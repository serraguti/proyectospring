package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import models.Departamento;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class RepositoryDepartamentosContainer {

    //EL REPOSITORY, PARA PODER TRABAJAR, NECESITA UN DriverManagerDataSource
    private DriverManagerDataSource datasource;

    //EL CONTAINER NOS DARA EL DATASOURCE MEDIANTE EL CONSTRUCTOR
    //Y ASI ESE OBJETO PERMANECERA PRIVATE
    public RepositoryDepartamentosContainer(DriverManagerDataSource datasource) {
        this.datasource = datasource;
    }

    //PARA QUE EL CONTROLADOR NOS MANDE UN DRIVERMANAGER, QUE TENEMOS
    //QUE HACER CON LA PROPIEDAD DE ARRIBA?
    public Departamento buscarDepartamento(int id) throws SQLException {
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
}
