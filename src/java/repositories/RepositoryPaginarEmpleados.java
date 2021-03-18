package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Empleado;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryPaginarEmpleados {

    DriverManagerDataSource dataSource;

    public RepositoryPaginarEmpleados(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    //AYER HICIMOS UNA CONSULTA CON TODOS LOS DEPARTAMENTOS
    //POR LO QUE EL NUMERO DE REGISTROS ERA EL SIZE DE TODOS
    //AQUI NECESITAMOS SABER CUANTOS REGISTROS EXISTEN
    public int getNumeroRegistros() throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select count(emp_no) as registros from emp";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int registros = rs.getInt("REGISTROS");
        rs.close();
        cn.close();
        return registros;
    }

    //QUE TIPO DE CONSULTA VAMOS A REALIZAR AQUI????
    //VAMOS A BUSCAR 5 REGISTROS
    public List<Empleado> getEmpleados(int posicion) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "SELECT * FROM "
                + " (SELECT EMPLEADOS.*, ROWNUM POSICION FROM "
                + "(SELECT * FROM EMP ORDER BY APELLIDO) "
                + " EMPLEADOS WHERE ROWNUM < ?) WHERE POSICION >= ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, (posicion + 5));
        pst.setInt(2, posicion);
        ResultSet rs = pst.executeQuery();
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMP_NO");
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("OFICIO");
            int salario = rs.getInt("SALARIO");
            int departamento = rs.getInt("DEPT_NO");
            Empleado emp = new Empleado(id, apellido, oficio, salario, departamento);
            empleados.add(emp);
        }
        rs.close();
        cn.close();
        return empleados;
    }

}
