package entidades.estabelecimento;

import Controler.ProdutoDB;

public class Produto {
    private int idProduto;
    private String nome;
    private double custo;
    private double preco;
    public int Caixa_id;
    public String Cliente_cpf;
    ProdutoDB produtoDB = new ProdutoDB();

    public Produto(String nome, double custo, double preco) {
        idProduto = (produtoDB.researchProduto() + 1);
        this.nome = nome;
        this.custo = custo;
        this.preco = preco;
    }

    public Produto(){
        idProduto = (produtoDB.researchProduto() + 1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
