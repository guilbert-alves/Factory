package br.gov.ac.sefaz.treinamento.jdbc.dao;

import br.gov.ac.sefaz.treinamento.jdbc.factory.JdbcFactory;
import br.gov.ac.sefaz.treinamento.jdbc.model.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutorDAO {

    private static final String SQL_INSERT = "INSERT INTO autor (id, nome, idade, nascimento, comentario) VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_LIST_ALL = "SELECT * FROM autor";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM autor WHERE id = ?";

    private static final String SQL_FIND_BY_NOME = "SELECT * FROM autor WHERE UPPER(nome) like ?";



    public void salvar(Autor autor) {
        try {
            Connection conn = new JdbcFactory().criarConexao();
            PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
            psAutor(autor, ps);
            ps.execute();
            ps.close();
            conn.close();
            System.out.println("Autor ".concat(autor.getNome()).concat(" salvo com sucesso!"));
        } catch (SQLException e) {
            System.err.println("Erro ao salvar autor:  ".concat(e.getMessage()));
        }
    }

    private static final String SQL_UPDATE = "UPDATE autor SET nome = ?, idade = ?, nascimento = ?, comentario = ? where id = ?";

    public void update(Autor autor, Integer id) {
        try {
            Connection conn = new JdbcFactory().criarConexao();
            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, autor.getNome());
            ps.setInt(2, autor.getIdade());
            ps.setDate(3, Date.valueOf(autor.getNascimento()));
            ps.setString(4, autor.getCometario());
            ps.setInt(5, id);
            ps.execute();
            ps.close();
            conn.close();
            System.out.println("Autor ".concat(autor.getNome()).concat(" atualizado com sucesso!"));
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar autor:  ".concat(e.getMessage()));
        }
    }

    public List<Autor> listarTodos() {
        try {
            Connection conn = new JdbcFactory().criarConexao();
            PreparedStatement ps = conn.prepareStatement(SQL_LIST_ALL);
            ResultSet rs = ps.executeQuery();
            List<Autor> resultado = new ArrayList<>();
            while (rs.next()) resultado.add(rsAutor(rs));
            conn.close();
            ps.close();
            rs.close();
            return resultado;
        } catch (SQLException e) {
            System.err.println("Erro ao listar autor:  ".concat(e.getMessage()));
            return Collections.emptyList();
        }
    }

    public Autor procurarPorId(Integer id) {
        try {
            Connection conn = new JdbcFactory().criarConexao();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Autor autor = null;
            if (rs.next()) autor = rsAutor(rs);
            conn.close();
            ps.close();
            rs.close();
            return autor;
        } catch (SQLException e) {
            System.err.println("Erro ao buscar autor:  ".concat(e.getMessage()));
            return null;
        }
    }

    public Autor procurarPorNome(String nome) {
        try {
            Connection conn = new JdbcFactory().criarConexao();
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_NOME);
            ps.setString(1, "%".concat(nome.toUpperCase()).concat("%"));
            ResultSet rs = ps.executeQuery();
            Autor autor = null;
            if (rs.next()) autor = rsAutor(rs);
            conn.close();
            ps.close();
            rs.close();
            return autor;
        } catch (SQLException e) {
            System.err.println("Erro ao buscar autor:  ".concat(e.getMessage()));
            return null;
        }
    }

    private void psAutor(Autor autor, PreparedStatement ps) throws SQLException {
        ps.setInt(1, autor.getId());
        ps.setString(2, autor.getNome());
        ps.setInt(3, autor.getIdade());
        ps.setDate(4, Date.valueOf(autor.getNascimento()));
        ps.setString(5, autor.getCometario());
    }

    private Autor rsAutor(ResultSet rs) throws SQLException {
        Autor autor = new Autor();
        autor.setId(rs.getInt("ID"));
        autor.setNome(rs.getString("NOME"));
        autor.setIdade(rs.getInt("IDADE"));
        autor.setNascimento(rs.getDate("NASCIMENTO").toLocalDate());
        autor.setCometario(rs.getString("COMENTARIO"));
        return autor;
    }

    private static final String SQL_DELETE_BY_ID = "DELETE FROM autor WHERE id ?";

    public void removerPorId(Integer id) {
        try {
            Connection conn = new JdbcFactory().criarConexao();
            PreparedStatement ps = conn.prepareStatement(SQL_DELETE_BY_ID);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            conn.close();
            System.out.println("Autor de id ".concat(id.toString()).concat(" removido com sucesso!"));
        } catch (SQLException e) {
            System.err.println("Erro ao remover autor:  ".concat(e.getMessage()));
        }
    }

    private static final String SQL_DELETE_ALL = "DELETE FROM autor?";

    public void removerTodos() {
        try {
            Connection conn = new JdbcFactory().criarConexao();
            PreparedStatement ps = conn.prepareStatement(SQL_DELETE_ALL);
            ps.execute();
            ps.close();
            conn.close();
            System.out.println("Todos os autores removidos com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao remover todos os autores:  ".concat(e.getMessage()));
        }
    }
}