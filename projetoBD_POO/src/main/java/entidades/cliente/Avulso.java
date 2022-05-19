package entidades.cliente;

public class Avulso extends Cliente {
    private static int idAvulsoaux;
    private int idAvulso;
    public int Cliente_cpf;

    public Avulso(int cpf, String nome, String telefone, String email, double gasto) {
        super(cpf, nome, telefone, email, gasto);
        idAvulso = idAvulsoaux++;
        Cliente_cpf = cpf;
    }

    public int getIdAvulso() {
        return idAvulso;
    }

    public int getCliente_cpf() {
        return Cliente_cpf;
    }

    public void setCliente_cpf(int cliente_cpf) {
        Cliente_cpf = cliente_cpf;
    }
}
