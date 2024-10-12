package POO;

public abstract class Produto {
    // atributos
    private String nome;
    private String descricao;
    private double preco;

    // construtor
    public Produto(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // get e set para Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // get e set para descrição
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // get e set para Preço
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // método para imprimir informações
    public abstract String toString();

}