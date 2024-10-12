package POO;

public abstract class FormaPagamento{
    //Atributos
    private String nome;

    //Construtor
    public FormaPagamento(String nome) {
        this.nome = nome;
    }

    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Métodos extras
    public abstract void pagar(double valor);

    public abstract void solicitarDadosPagamento();
}
