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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcFactory {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL_DATABASE = "jdbc:postgresql://localhost:15432/treinamento";
    private static final String DRIVER_CLAS = "org.postgresql.Driver";

    /**
     * Classe de conexão jdbc com postgres
     */

    public Connection criarConexao(){
        try {
            System.out.println("Iniciando conexão jdbc1");
            Class.forName(DRIVER_CLAS);
            Connection connection = DriverManager.getConnection(URL_DATABASE, USERNAME, PASSWORD);
            System.out.println("Iniciado conexão!");
            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!");
            return null;
        } catch (SQLException e) {
            System.out.println("Sql ERRO:" + e.getMessage());
            return null;
        }
    }

}
