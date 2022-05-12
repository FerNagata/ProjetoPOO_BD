package entidades.cliente;

public abstract class Cliente {
    protected int cpf;
    protected String nome;
    protected String telefone;
    protected String email;
    protected double gasto;

    public Cliente(int cpf, String nome, String telefone, String email, double gasto) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.gasto = gasto;
    }
}
