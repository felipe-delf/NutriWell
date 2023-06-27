package br.com.login.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String usuario = "root";
    private String senha = "root";
    private String host = "localhost";
    private String porta = "3306";
    private String db = "aplicacao";

    public Connection getConnection() throws SQLException {
        
        String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo", host, porta, db);
        System.out.println("Conexão efetuada com sucesso");
        return DriverManager.getConnection(url, usuario, senha);

    }
    
    
    public static void main(String[] args) {
        Conexao cn = new Conexao();
        
        try {
            Connection connection = cn.getConnection();
            
            // Faça o que você precisa fazer com a conexão aqui
            
            connection.close(); // Lembre-se de fechar a conexão quando terminar de usá-la
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
}
