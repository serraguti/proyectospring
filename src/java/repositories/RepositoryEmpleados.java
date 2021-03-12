package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Empleado;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryEmpleados {

    DriverManagerDataSource dataSource;

    public RepositoryEmpleados(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    public List<Empleado> getEmpleados() throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from emp";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMP_NO");
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("OFICIO");
            int salario = rs.getInt("SALARIO");
            Empleado emp = new Empleado(id, apellido, oficio, salario);
            empleados.add(emp);
        }
        rs.close();
        cn.close();
        return empleados;
    }

    public List<Empleado> getEmpleadosSession(List<String> listaids) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        //DEBEMOS SEPARAR LOS IDS POR COMAS
        String data = "";
        for (String id : listaids) {
            data += id + ",";
        }
        data = data.substring(0, data.lastIndexOf(","));
        String sql = "select * from emp where emp_no in(" + data + ")";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("EMP_NO");
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("OFICIO");
            int salario = rs.getInt("SALARIO");
            Empleado emp = new Empleado(id, apellido, oficio, salario);
            empleados.add(emp);
        }
        rs.close();
        cn.close();
        return empleados;
    }
}
