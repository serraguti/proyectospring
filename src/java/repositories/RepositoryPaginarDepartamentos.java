package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Departamento;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryPaginarDepartamentos {

    DriverManagerDataSource dataSource;

    public RepositoryPaginarDepartamentos(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }

    //NECESITAMOS DOS COSAS:
    //1) RECUPERAR EL NUMERO DE REGISTROS A PAGINAR
    //2) OBJETO QUE QUEREMOS MOSTRAR
    private int numeroRegistros;

    public int getNumeroRegistros() {
        return numeroRegistros;
    }

    //NECESITAMOS UN METODO QUE NOS DEVUELVA EL DATO
    //POR SU POSICION
    public Departamento getDepartamento(int posicion) throws SQLException {
        Connection cn = this.dataSource.getConnection();
        String sql = "select * from dept";
        //NECESITAMOS QUE EL STATEMENT SE PUEDA MOVER ENTRE LAS POSICIONES
        //DEL CURSOR
        Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery(sql);
        //AHORA TENEMOS MOVIMIENTO POR EL CURSOR DE REGISTROS
        //VAMOS AL ULTIMO
        rs.last();
        //ALMACENAMOS EL NUMERO DE REGISTROS
        this.numeroRegistros = rs.getRow();
        //NOS POSICIONAMOS EN LA FILA QUE DESEEMOS
        rs.absolute(posicion);
        //EXTRAEMOS LOS DATOS PARA EL OBJETO
        int id = rs.getInt("DEPT_NO");
        String nombre = rs.getString("DNOMBRE");
        String localidad = rs.getString("LOC");
        Departamento dept = new Departamento(id, nombre, localidad);
        rs.close();
        cn.close();
        return dept;
    }
}
