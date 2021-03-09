package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Departamento;
import oracle.jdbc.OracleDriver;

public class RepositoryDepartamentos {

    private Connection getConection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn
                = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public List<Departamento> getDepartamentos() throws SQLException {
        Connection cn = this.getConection();
        String sql = "select * from dept";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Departamento> departamentos
                = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("DEPT_NO");
            String nombre = rs.getString("DNOMBRE");
            String localidad = rs.getString("LOC");
            Departamento dept = new Departamento(id, nombre, localidad);
            departamentos.add(dept);
        }
        rs.close();;
        cn.close();
        return departamentos;
    }
}
