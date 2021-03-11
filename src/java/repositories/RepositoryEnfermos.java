package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Enfermo;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryEnfermos {

    private DriverManagerDataSource dataSource;

    public RepositoryEnfermos(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    public List<Enfermo> getEnfermos() throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from enfermo";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Enfermo> enfermos = new ArrayList<>();
        while (rs.next()) {
            int inscripcion = rs.getInt("INSCRIPCION");
            String apellido = rs.getString("APELLIDO");
            String direccion = rs.getString("DIRECCION");
            String sexo = rs.getString("SEXO");
            Enfermo enf = new Enfermo(inscripcion, apellido, direccion, sexo);
            enfermos.add(enf);
        }
        rs.close();
        cn.close();
        return enfermos;
    }

    public void eliminarEnfermo(int inscripcion) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "delete from enfermo where inscripcion=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, inscripcion);
        pst.executeUpdate();
        cn.close();
    }
}
