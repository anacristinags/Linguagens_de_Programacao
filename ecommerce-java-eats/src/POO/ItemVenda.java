package POO;

public class ItemVenda {
    // atributos
    private Produto produto;
    private int quantidade;

    // construtor
    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // getter e setter para Produto
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // getter e setter para Quantidade
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // método para calcular o preço total por item
    public double calcularTotal() {
        return produto.getPreco() * quantidade;
    }

    // toString
    @Override
    public String toString() {
        return "Produto: " + produto + ", Quantidade: " + quantidade + "\nTotal: " + calcularTotal();
    }
}