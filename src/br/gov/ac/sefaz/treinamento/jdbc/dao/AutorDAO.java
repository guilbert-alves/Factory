package br.gov.ac.sefaz.treinamento.jdbc.dao;

import br.gov.ac.sefaz.treinamento.jdbc.factory.JdbcFactory;
import br.gov.ac.sefaz.treinamento.jdbc.model.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutorDAO {

    public static final String SQL_INSERT = "INSERT INTO autor (id, nome, idade, nascimento, comentario) VALUES(?, ?, ?, ?, ?)";

    public static final String SQL_LIST_ALL = "SELECT * FROM autor";
    public static final String SQL_FIND_BY_Id = "SELECT * FROM autor WHERE id = ?";

    public boolean salvar(Autor autor) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new JdbcFactory().criarConexao();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, autor.getId());
            ps.setString(2, autor.getNome());
            ps.setInt(3, autor.getIdade());
            ps.setDate(4, Date.valueOf(autor.getNascimento()));
            ps.setString(5, autor.getComentario());
            ps.execute();
            ps.close();
            conn.close();
            System.out.println("autor ".concat(autor.getNome()).concat(" salvo com sucesso!"));

        } catch (SQLException e) {
            System.out.println("Erro ao salvar autor: ".concat(e.getMessage()));
        }


        return false;
    }

    public List<Autor> listarAutores() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new JdbcFactory().criarConexao();
            ps = conn.prepareStatement(SQL_LIST_ALL);
            rs = ps.executeQuery();
            List<Autor> resultado = new ArrayList<>();
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("ID"));
                autor.setNome(rs.getString("NOMe"));
                autor.setIdade(rs.getInt("IDADE"));
                autor.setNascimento(rs.getDate("NASCIMENTO").toLocalDate());
                autor.setComentario(rs.getString("COMENTARIO"));
                resultado.add(autor);
            }
            conn.close();
            ps.close();
            rs.close();
            return resultado;


        } catch (SQLException e) {
            System.out.println("Erro ao slavar autor: ".concat(e.getMessage()));
            return Collections.emptyList();
        }

    }

    public Autor prorcuraPorID(Integer id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new JdbcFactory().criarConexao();
            ps = conn.prepareStatement(SQL_FIND_BY_Id);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Autor autor = null;

            if (rs.next()) {
                autor = new Autor();
                autor.setId(rs.getInt("ID"));
                autor.setNome(rs.getString("NOMe"));
                autor.setIdade(rs.getInt("IDADE"));
                autor.setNascimento(rs.getDate("NASCIMENTO").toLocalDate());
                autor.setComentario(rs.getString("COMENTARIO"));
            }
            conn.close();
            ps.close();
            rs.close();
            return autor;

        } catch (SQLException e) {
            System.out.println("Erro ao slavar autor: ".concat(e.getMessage()));
            return null;
        }

    }
}
