package br.com.login.Controller;

import br.com.login.DAO.Conexao;
import br.com.login.DAO.LoginDAO;
import br.com.login.view.CadastroView;
import br.com.login.view.LoginView;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {

    public void cadastroUsuario(CadastroView view) throws SQLException {

        Connection conexao = new Conexao().getConnection();
        LoginDAO cadastro = new LoginDAO();
        cadastro.cadastrarUsuario(view.getTxt_usuarioCadastro().getText(), view.getTxt_emailCadastro().getText(), view.getTxt_senhaCadastro().getText(), view.getTxt_cpfCadastro().getText());

    }

    public void loginUsuario(LoginView view) throws SQLException {

        Connection conexao = new Conexao().getConnection();
        LoginDAO login = new LoginDAO();
        login.login(view.getTxt_emailLogin().getText(), view.getTxt_senhaLogin().getText());

    }
}
