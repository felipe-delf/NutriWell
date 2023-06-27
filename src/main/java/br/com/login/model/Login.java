package br.com.login.model;

public class Login {

    private String usuario, email, senha, cpf;

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public void cadastrar(String usuario, String email, String senha, String cpf) {

        this.email = email;
        this.senha = senha;
        this.usuario = usuario;
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    

}
