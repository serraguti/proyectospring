package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Doctor;
import models.Hospital;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryMultiHospitalDoctores {

    DriverManagerDataSource dataSource;

    public RepositoryMultiHospitalDoctores(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    public List<Hospital> getHospitales() throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from hospital";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Hospital> hospitales = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("HOSPITAL_COD");
            String nombre = rs.getString("NOMBRE");
            String direccion = rs.getString("DIRECCION");
            String tlf = rs.getString("TELEFONO");
            int camas = rs.getInt("NUM_CAMA");
            Hospital h = new Hospital(id, nombre, direccion, tlf, camas);
            hospitales.add(h);
        }
        rs.close();
        cn.close();
        return hospitales;
    }

    public List<Doctor> getDoctoresHospital(int idhospital) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from doctor where hospital_cod=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idhospital);
        ResultSet rs = pst.executeQuery();
        ArrayList<Doctor> doctores = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("DOCTOR_NO");
            String apellido = rs.getString("APELLIDO");
            String especialidad = rs.getString("ESPECIALIDAD");
            int salario = rs.getInt("SALARIO");
            int hospital = rs.getInt("HOSPITAL_COD");
            Doctor doc = new Doctor(id, apellido, especialidad, salario, hospital);
            doctores.add(doc);
        }
        rs.close();
        cn.close();
        if (doctores.isEmpty()) {
            return null;
        } else {
            return doctores;
        }
    }

    public void incrementarSalarioDoctores(int idhospital, int incremento) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "update doctor set salario = salario + ? "
                + " where hospital_cod=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, incremento);
        pst.setInt(2, idhospital);
        pst.executeUpdate();
        cn.close();
    }

    public void eliminarDoctor(int iddoctor) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "delete from doctor where doctor_no=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, iddoctor);
        pst.executeUpdate();
        cn.close();
    }
}
