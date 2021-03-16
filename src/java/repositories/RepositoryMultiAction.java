package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Departamento;
import models.Empleado;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryMultiAction {

    DriverManagerDataSource dataSource;

    public RepositoryMultiAction(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    public List<Departamento> getDepartamentos() throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from dept";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Departamento> departamentos = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("DEPT_NO");
            String nombre = rs.getString("DNOMBRE");
            String localidad = rs.getString("LOC");
            Departamento dept = new Departamento(id, nombre, localidad);
            departamentos.add(dept);
        }
        rs.close();
        cn.close();
        return departamentos;
    }

    public List<Empleado> getEmpleadosDepartamento(int iddepartamento) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from emp where dept_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, iddepartamento);
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
        if (empleados.isEmpty()) {
            return null;
        }
        return empleados;
    }

    public void eliminarDepartamento(int iddepartamento) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "delete from dept where dept_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, iddepartamento);
        pst.executeUpdate();
        cn.close();
    }
}
