/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastro.model.util;

import cadastro.model.util.PessoaFisica;
import cadastro.model.util.ConectorBD;
import cadastro.model.util.SequenceManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Temis
 */

public class PessoaFisicaDAO {
    private final ConectorBD connector;

    public PessoaFisicaDAO() {
        connector = new ConectorBD();
    }

    public PessoaFisica getPessoa(int id) throws SQLException, Exception {
        String sql = "SELECT pf.Pessoa_idPessoa, p.nome, p.logradouro, p.cidade, p.estado, p.telefone, p.email, pf.cpf "
            + "FROM PessoaFisica pf "
            + "INNER JOIN Pessoa p ON pf.Pessoa_idPessoa = p.idPessoa "
            + "WHERE pf.Pessoa_idPessoa = ?";
        PessoaFisica pessoa = null;
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = connector.getConnection(); 
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                pessoa = new PessoaFisica(
                    rs.getString("cpf"),
                    rs.getInt("Pessoa_idPessoa"), 
                    rs.getString("nome"),
                    rs.getString("logradouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email")
                );
                return pessoa;
            } else {
                return null;
            }
        } finally {
            connector.close(rs);
            connector.close(stmt);
            connector.close(con);
        }
    }

    public List<PessoaFisica> getPessoas() throws SQLException, Exception {
        String sql = "SELECT pf.Pessoa_idPessoa, p.nome, p.logradouro, p.cidade, p.estado, p.telefone, p.email, pf.cpf "
            + "FROM Pessoa p "
            + "INNER JOIN PessoaFisica pf ON p.idPessoa = pf.Pessoa_idPessoa;";
        List<PessoaFisica> lista = new ArrayList<>();
        Connection con = null; 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = connector.getConnection(); 
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new PessoaFisica(
                    rs.getString("cpf"),
                    rs.getInt("Pessoa_idPessoa"),
                    rs.getString("nome"),
                    rs.getString("logradouro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("telefone"),
                    rs.getString("email")
                ));
            }
            return lista;
        } finally {
            connector.close(rs);
            connector.close(stmt);
            connector.close(con);
        }
    }

    public void incluir(PessoaFisica pessoa) throws SQLException, Exception {
        String sqlPessoa = "INSERT INTO Pessoa(idPessoa, nome, logradouro, cidade, estado, telefone, email) VALUES(?, ?, ?, ?, ?, ?, ?);";
        String sqlPessoaFisica = "INSERT INTO PessoaFisica(Pessoa_idPessoa, cpf) VALUES(?, ?);";
        Connection con = null; 
        PreparedStatement stmt = null;
        PreparedStatement stmtPf = null;
        try {
            con = connector.getConnection();
            con.setAutoCommit(false);

            SequenceManager sequenceManager = new SequenceManager();
            int idNovaPessoa = sequenceManager.getValue("orderPessoa");

            stmt = con.prepareStatement(sqlPessoa);
            stmt.setInt(1, idNovaPessoa);
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getLogradouro());
            stmt.setString(4, pessoa.getCidade());
            stmt.setString(5, pessoa.getEstado());
            stmt.setString(6, pessoa.getTelefone());
            stmt.setString(7, pessoa.getEmail());
            stmt.executeUpdate();

            pessoa.setId(idNovaPessoa);

            stmtPf = con.prepareStatement(sqlPessoaFisica);
            stmtPf.setInt(1, idNovaPessoa);
            stmtPf.setString(2, pessoa.getCpf());
            stmtPf.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            throw e;
        } finally {
            connector.close(stmtPf);
            connector.close(stmt);
            connector.close(con);
        }
    }

    public void alterar(PessoaFisica pessoa) throws SQLException, Exception {
        String sqlPessoa = "UPDATE Pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ? WHERE idPessoa = ?";
        String sqlPessoaFisica = "UPDATE PessoaFisica SET cpf = ? WHERE Pessoa_idPessoa = ?;";
        Connection con = null; 
        PreparedStatement stmt = null;
        PreparedStatement stmtPf = null;
        try {
            con = connector.getConnection();
            stmt = con.prepareStatement(sqlPessoa);
            stmtPf = con.prepareStatement(sqlPessoaFisica);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getLogradouro());
            stmt.setString(3, pessoa.getCidade());
            stmt.setString(4, pessoa.getEstado());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setString(6, pessoa.getEmail());
            stmt.setInt(7, pessoa.getId());
            stmt.executeUpdate();

            stmtPf.setString(1, pessoa.getCpf());
            stmtPf.setInt(2, pessoa.getId());
            stmtPf.executeUpdate();
        } finally {
            connector.close(stmtPf);
            connector.close(stmt);
            connector.close(con);
        }
    }

    public void excluir(int id) throws SQLException, Exception {
        String sqlPessoa = "DELETE FROM Pessoa WHERE idPessoa = ?;";
        String sqlPessoaFisica = "DELETE FROM PessoaFisica WHERE Pessoa_idPessoa = ?;";
        Connection con = null; 
        PreparedStatement stmt = null;
        PreparedStatement stmtPf = null;
        try {
            con = connector.getConnection();
            stmtPf = con.prepareStatement(sqlPessoaFisica);
            stmtPf.setInt(1, id);
            stmtPf.executeUpdate();

            stmt = con.prepareStatement(sqlPessoa);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            connector.close(stmt);
            connector.close(stmtPf);
            connector.close(con);
        }
    }
}
