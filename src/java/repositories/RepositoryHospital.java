package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Hospital;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryHospital {

    private DriverManagerDataSource dataSource;

    public RepositoryHospital(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    public List<Hospital> getHospitales() throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from hospital";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Hospital> hospitales
                = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("HOSPITAL_COD");
            String nombre = rs.getString("NOMBRE");
            String direccion = rs.getString("DIRECCION");
            String tlf = rs.getString("TELEFONO");
            int camas = rs.getInt("NUM_CAMA");
            Hospital hospital = new Hospital(id, nombre, direccion, tlf, camas);
            hospitales.add(hospital);
        }
        rs.close();
        cn.close();
        return hospitales;
    }
}
