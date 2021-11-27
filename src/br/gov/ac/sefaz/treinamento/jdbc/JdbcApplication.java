package br.gov.ac.sefaz.treinamento.jdbc;


//spring.datasource.driverClassName=org.postgresql.Driver
//spring.datasource.url=jdbc:postgresql://localhost:5432/my_db
//spring.datasource.username=postgres
//spring.datasource.password=postgres
//
//spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
//spring.jpa.generate-ddl=true
//spring.jpa.show-sql=true
//spring.jpa.hibernate.ddl-auto=create

import br.gov.ac.sefaz.treinamento.jdbc.factory.JdbcFactory;

import java.sql.Connection;

public class JdbcApplication {

    public static void main(String[] args) {
        JdbcFactory jdbcFactory = new JdbcFactory();
        Connection conn = jdbcFactory.criarConexao();

    }

}
