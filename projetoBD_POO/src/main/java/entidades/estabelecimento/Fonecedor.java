package entidades.estabelecimento;

public class Fonecedor {
    private int cnpj;
    private String endereco;
    private String nome;
    private double orcamento;
    private int estoque;
    public int Caixa_id;

    public Fonecedor(int cnpj, String endereco, String nome, double orcamento, int estoque) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.nome = nome;
        this.orcamento = orcamento;
        this.estoque = estoque;
    }

}
