package entidades.cliente;

public class Fidelidade extends Cliente {
    private static int idFidelidadeAux;
    private int idFidelidade;
    public int Cliente_cpf;

    public Fidelidade(int cpf, String nome, String telefone, String email, double gasto,int idFidelidade) {
        super(cpf, nome, telefone, email, gasto);
        //Cliente_cpf = cpf;?
        idFidelidade = idFidelidadeAux++;
    }

    public int getIdFidelidade() {
        return idFidelidade;
    }

    public int getCliente_cpf() {
        return Cliente_cpf;
    }

    public void setCliente_cpf(int cliente_cpf) {
        Cliente_cpf = cliente_cpf;
    }
}
