package entidades.estabelecimento;

public class Produto {
    private static int idProdutoAux;
    private int idProduto;
    private double custo;
    private double preco;
    public int Caixa_id;
    public int Cliente_cpf;

    public Produto(int idProduto, double custo, double preco) {
        this.idProduto = idProdutoAux++;
        this.custo = custo;
        this.preco = preco;

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

    public int getCaixa_id() {
        return Caixa_id;
    }

    public void setCaixa_id(int caixa_id) {
        Caixa_id = caixa_id;
    }

    public int getCliente_cpf() {
        return Cliente_cpf;
    }

    public void setCliente_cpf(int cliente_cpf) {
        Cliente_cpf = cliente_cpf;
    }
}
