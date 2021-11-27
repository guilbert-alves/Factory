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

import br.gov.ac.sefaz.treinamento.jdbc.dao.AutorDAO;


public class JdbcApplication {

    public static void main(String[] args) {

//        Autor autor = new Autor();
//        autor.setId(2);
//        autor.setNome("Guilbert 2");
//        autor.setIdade(20);
//        autor.setNascimento(LocalDate.of(2000, 12, 6));
//        autor.setComentario("meu primeiro insert com jdbc");

        AutorDAO dao = new AutorDAO();
        dao.listarAutores().forEach(System.out::println);
        System.out.println(dao.prorcuraPorID(2));

    }

}
