package repositories;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class RepositoryEmpleados {

    DriverManagerDataSource dataSource;

    public RepositoryEmpleados(DriverManagerDataSource datasource) {
        this.dataSource = datasource;
    }
}
