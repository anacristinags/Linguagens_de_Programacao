import java.util.Random;

// classe para servir de array dos itens do carrinho
public class ItemCarrinho {
    // atributos
    private String nome, observacao;
    private int quantidade;
    private double preco;
    private Random random = new Random();
    String numPedido;

    //construtor
    public ItemCarrinho(String nome, int quantidade, double preco, String observacao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.observacao = observacao;
        numPedido = String.format("%04d", random.nextInt(10000));
    }

    // getters e toString
    public String getNome() {return nome;}
    public int getQuantidade() {return quantidade;}
    public double getPreco() {return preco;}
    public String getObservacao() {return observacao;}
    public String getNumPedido() {return numPedido;}
    public double getPrecoTotal() {return quantidade * preco;}

    @Override
    public String toString() {
        return "Número do Pedido: "+numPedido+"\n"+quantidade + " x " + nome + ", Valor: R$ " +
                String.format("%.2f", getPrecoTotal())+ " \nObservação: "+observacao+"\n";
    }

}
