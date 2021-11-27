package br.gov.ac.sefaz.treinamento.jdbc.factory;

//spring.datasource.driverClassName=org.postgresql.Driver
//spring.datasource.url=jdbc:postgresql://localhost:5432/my_db
//spring.datasource.username=postgres
//spring.datasource.password=postgres
//
//spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
//spring.jpa.generate-ddl=true
//spring.jpa.show-sql=true
//spring.jpa.hibernate.ddl-auto=create

public class JdbcFactory {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL_DATABASE = "jdbc:postgresql://localhost:15432/my_db";
    private static final String DRIVER_CLAS = "org.postgresql.Driver";

}
