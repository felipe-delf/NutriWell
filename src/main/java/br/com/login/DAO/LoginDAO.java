package br.com.login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public void cadastrarUsuario(String usuario, String email, String senha, String cpf) throws SQLException {

        Connection conexao = new Conexao().getConnection();
        String sql = "insert into login(usuario, email, senha, cpf) values ('"+usuario+"','"+email+"','"+senha+"','"+cpf+"');";
        System.out.println(sql);
        PreparedStatement statment = conexao.prepareStatement(sql);
        statment.execute();
        conexao.close();
    }

     public boolean login(String email, String senha) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email, senha FROM login WHERE email = ? AND senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, senha);
        ResultSet rs = statement.executeQuery();
        boolean loginValido = rs.next(); // Verifica se há um registro no resultado da consulta
        conexao.close();
        return loginValido;
    }
}
