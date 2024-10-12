package POO;

public class Pizza extends Produto {
    // atributo
    private String tamanho;

    // construtor
    public Pizza(String nome, String descricao, double preco, String tamanho) {
        super(nome, descricao, preco);
        this.tamanho = tamanho;
    }

    // getter e setter para Tamanho
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    // toString
    @Override
    public String toString() {
        return getNome()+"\nDescrição: "+getDescricao()+
                "\nPreço: "+ getPreco()+", tamanho: "+ tamanho;
    }
}
