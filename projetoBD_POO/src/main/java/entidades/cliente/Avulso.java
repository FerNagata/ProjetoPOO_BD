package entidades.cliente;

public class Avulso extends Cliente {
    private int idAvulso;
    //Coloca chave estrangeira?


    public Avulso(int cpf, String nome, String telefone, String email, double gasto, int idAvulso) {
        super(cpf, nome, telefone, email, gasto);
        this.idAvulso = idAvulso;
    }
}
