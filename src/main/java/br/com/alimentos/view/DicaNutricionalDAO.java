package br.com.alimentos.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.login.DAO.Conexao;

public class DicaNutricionalDAO {
    private Connection conexao;

    public DicaNutricionalDAO() {
        // Aqui, você pode criar uma instância de Conexao e obter a conexão com o banco de dados
        Conexao cn = new Conexao();
        try {
            conexao = cn.getConnection();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public String obterDicaAleatoria() {
        List<String> dicas = obterTodasDicas();
        int indiceAleatorio = new Random().nextInt(dicas.size());
        return dicas.get(indiceAleatorio);
    }

    private List<String> obterTodasDicas() {
        List<String> dicas = new ArrayList<>();
        String query = "SELECT dica FROM dicas_nutricionais";
        try (PreparedStatement stmt = conexao.prepareStatement(query);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String dica = rs.getString("dica");
                dicas.add(dica);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter dicas nutricionais: " + e.getMessage());
        }
        return dicas;
    }

    // Aqui você pode implementar outros métodos relacionados à manipulação do banco de dados, se necessário
}
