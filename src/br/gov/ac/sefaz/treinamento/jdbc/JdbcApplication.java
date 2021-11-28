package br.gov.ac.sefaz.treinamento.jdbc;


import br.gov.ac.sefaz.treinamento.jdbc.dao.AutorDAO;
import br.gov.ac.sefaz.treinamento.jdbc.model.Autor;

import java.time.LocalDate;

public class JdbcApplication {

    public static void main(String[] args) {
        AutorDAO dao = new AutorDAO();
//        final Autor antonio = new Autor(1, "Antonio", 29, LocalDate.of(1992, 4, 22), "");
//        final Autor jose = new Autor(2, "Jose", 29, LocalDate.of(1992, 4, 22), "");
//        final Autor maria = new Autor(3, "Maria", 29, LocalDate.of(1992, 4, 22), "");
//        dao.salvar(antonio);
//        dao.salvar(jose);
//        dao.salvar(maria);
//        dao.listarTodos().forEach(System.out::println);
//        Autor maria = dao.procurarPorNome("maria");
//        System.out.println(maria);
//        maria.setComentario("estamos atualizando");
//        dao.update(maria,3);
//        maria = dao.procurarPorNome("maria");
//        System.out.println(maria);

//        dao.listarTodos().forEach(System.out::println);
//        dao.removerPorId(2);
//        dao.listarTodos().forEach(System.out::println);

        dao.listarTodos().forEach(System.out::println);
//        dao.removerTodos();
//        dao.listarTodos().forEach(System.out::println);

    }
}