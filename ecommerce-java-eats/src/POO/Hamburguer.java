package POO;

public class Hamburguer extends Produto {
    // atributo
    private String pontoCarne;
    private String obsCliente;

    //construtor
    public Hamburguer(String nome, String descricao, double preco, String pontoCarne, String obsCliente) {
        super(nome, descricao, preco);
        this.pontoCarne = pontoCarne;
        this.obsCliente = obsCliente;
    }

    // getter e setter para Ponto da Carne
    public String getPontoCarne() {
        return pontoCarne;
    }
    public void setPontoCarne(String pontoCarne) {
        this.pontoCarne = pontoCarne;
    }

    // getter e setter para Observação do Cliente
    public String getObsCliente() {
        return obsCliente;
    }
    public void setObsCliente(String obsCliente) {
        this.obsCliente = obsCliente;
    }

    // toString
    @Override
    public String toString() {
        return getNome()+
                "\nDescrição: "+getDescricao()+", pontoCarne: " + pontoCarne+
                "\nPreço: "+ getPreco() + "\nObservação do Cliente:"+obsCliente;

    }
}
