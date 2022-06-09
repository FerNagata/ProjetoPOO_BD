package entidades.funcionario;

import Controler.LoginDB;

public class Login {
    static int idLoginAux = 0;
    private int idLogin;
    private String email;
    private String senha;
    LoginDB loginDB = new LoginDB();

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
        idLoginAux++;
        idLogin = idLoginAux;
    }

    public Login(int idLogin, String email, String senha){
        this.idLogin = idLogin;
        this.email = email;
        this.senha = senha;
    }

    public Login(){
        idLogin = (loginDB.researchLogin() + 1);

        //idLoginAux++;
        //idLogin = idLoginAux;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
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
}
