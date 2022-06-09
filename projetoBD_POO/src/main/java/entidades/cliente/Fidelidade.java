package entidades.cliente;

import Controler.FidelidadeDB;

public class Fidelidade extends Cliente {
    private int idFidelidade;
    public String Cliente_cpf;
    FidelidadeDB fidelidadeDB = new FidelidadeDB();

    public Fidelidade(String cpf, String nome, String telefone, String email) {
        super(cpf, nome, telefone, email);
        idFidelidade = (fidelidadeDB.researchFidelidade() + 1);
        Cliente_cpf = cpf;
    }

    public Fidelidade(){
        idFidelidade = (fidelidadeDB.researchFidelidade() + 1);
    }

    public int getIdFidelidade() {
        return idFidelidade;
    }

}
