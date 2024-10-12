package POO;

public class Bebida extends Produto {
    // atributo
    private String tamanho;

    // construtor
    public Bebida(String nome, String descricao, double preco, String tamanho) {
        super(nome, descricao, preco);
        this.tamanho = tamanho;
    }

    //getter e setter
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    // toString
    @Override
    public String toString() {
        return getNome()+", tamanho: "+ tamanho+
                "\nDescrição: "+getDescricao()+
                "\nPreço: "+ getPreco();
    }
}
